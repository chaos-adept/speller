package tests.externallib;

import java.util.ArrayList;



import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.Element;
import net.sf.ehcache.config.CacheConfiguration;
import net.sf.ehcache.store.MemoryStoreEvictionPolicy;
import junit.framework.TestCase;

public class EhCacheTestCase extends TestCase {

	
	int maxElements = 1;
	int maxElementsOnDisk = 30000;
	
	Cache cache;
	
	CacheManager manager;
	
	protected void setUp() throws Exception {
		super.setUp();
		
		   manager = CacheManager.create();

		   //Create a Cache specifying its configuration.

		   
		   CacheConfiguration config = new CacheConfiguration("test", maxElements);
		   
		   config.memoryStoreEvictionPolicy(MemoryStoreEvictionPolicy.LRU);
		   
		   config.setMaxElementsInMemory(maxElements);
		   config.overflowToDisk(true);
		   config.maxElementsOnDisk( maxElementsOnDisk );
		   //config.setDiskStorePath( "C:/DES/work/projects/cache/disk_cahe_raw" );
		   config.diskPersistent(false);
		   config.eternal(false);
		   config.diskSpoolBufferSizeMB(1);
		   config.diskExpiryThreadIntervalSeconds(1500);
		   
		   
		   this.cache = new Cache( config );
		   
		   manager.addCache(cache);		
		
		   
		   
		   
	}

	protected void tearDown() throws Exception {
		super.tearDown();
		manager.removeCache( cache.getName() );
		cache.dispose();
		
	}
	
	public void testInstance()
	{
		assertNotNull(cache);
	}
	
	public void testGet()
	{
		MockItem key = MockItem.create();
		MockItem excpt = key;
		
		Element element = new Element(key, excpt);
		cache.put(element);		
		
		Element actualEl = cache.get(key);
		
		assertEquals( element.getValue(), actualEl.getValue() );
		
		assertNull( cache.get("123") );
		
	}
	
	
	public void testMaxElements()
	{
		
		int itemsCount = maxElements + 1000;
		
		ArrayList<MockItem> items = new ArrayList<MockItem>();
		
		
		for ( int indx = 0; indx < itemsCount; indx++ )
		{
			MockItem key = MockItem.create();
			MockItem excpt = key;
			
			items.add(excpt);
			
			Element element = new Element(key, excpt);
			cache.put(element);	
		}
		
		
		//reg.processEvictionQueues();
		
		boolean isAllFound = true;
		
		ArrayList<MockItem> extractedItems = new ArrayList<MockItem>();
		
		for (MockItem mockItem : items) {
			
			Element element = cache.get( mockItem );
			
			if ( element == null )
				isAllFound = false;
			else
			{
				MockItem extr = (MockItem) element.getObjectValue();
				extractedItems.add(extr);	
				
			}
			
		}
		
		//assertFalse( items.containsAll(extractedItems) );
		
		assertFalse( isAllFound );
				
		
	}
	

}
