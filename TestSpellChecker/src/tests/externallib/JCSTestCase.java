package tests.externallib;


import java.util.ArrayList;
import java.util.Properties;

import junit.framework.TestCase;

import org.apache.jcs.JCS;
import org.apache.jcs.access.CacheAccess;
import org.apache.jcs.access.exception.CacheException;
import org.apache.jcs.engine.CompositeCacheAttributes;
import org.apache.jcs.engine.behavior.ICompositeCacheAttributes;
import org.apache.jcs.engine.control.CompositeCacheManager;
import org.jboss.cache.Node;
import org.jboss.cache.Region;


public class JCSTestCase extends TestCase {

	int maxNodes = 3;
	
	org.apache.jcs.engine.control.CompositeCache compositeCache;
	CacheAccess cache;
	
	protected void setUp() throws Exception {
		super.setUp();
		
		
		CompositeCacheManager ccm = CompositeCacheManager.getUnconfiguredInstance(); 
		Properties props = genConfig();
		ccm.configure(props);		
		
        ICompositeCacheAttributes cattr = new CompositeCacheAttributes();
        cattr.setMaxObjects( maxNodes );
        cattr.setUseDisk( false );
        
		this.compositeCache = ccm.getCache("test", cattr);//JCS.getAccess("test", cattr);
		
		this.cache = new CacheAccess(compositeCache);
	}

	protected Properties genConfig()
	{
		Properties properties = new Properties();
		/*
		jcs.default=
			jcs.default.cacheattributes=
			    org.apache.jcs.engine.CompositeCacheAttributes
*/		
		
		properties.put("jcs.default", "DC");
		properties.put("jcs.default.cacheattributes", "org.apache.jcs.engine.CompositeCacheAttributes");
		
		properties.put("jcs.auxiliary.DC" ,
		    "org.apache.jcs.auxiliary.disk.indexed.IndexedDiskCacheFactory" );
		properties.put("jcs.auxiliary.DC.attributes" ,
		    "org.apache.jcs.auxiliary.disk.indexed.IndexedDiskCacheAttributes" );
		properties.put("jcs.auxiliary.DC.attributes.DiskPath" , "C:/DES/work/projects/cache/disk_cahe_raw" );
		properties.put("jcs.auxiliary.DC.attributes.maxKeySize" , 100000 );
		
		
		
		return properties;
	}
	
	protected void tearDown() throws Exception {
		super.tearDown();
		
		this.cache.dispose();
	}
	
	public void testGet() throws CacheException
	{
		MockItem excpt = new MockItem();
		
		this.cache.put(excpt, excpt);
		
		MockItem actual = (MockItem) this.cache.get(excpt);
			
		assertEquals(excpt, actual);
	}
	
	public void testMaxElements() throws CacheException
	{
		int itemsCount = maxNodes + 300;
		
		ArrayList<MockItem> items = new ArrayList<MockItem>();
		
		for ( int indx = 0; indx < itemsCount; indx++ )
		{
			MockItem key = MockItem.create();
			MockItem excpt = key;
			
			items.add(excpt);
			
			cache.put( key , excpt );		
		}
		
		boolean isAllFound = true;
		
		ArrayList<MockItem> extractedItems = new ArrayList<MockItem>();
		
		for (MockItem mockItem : items) {
			MockItem extr = (MockItem) cache.get( mockItem);
			
			if ( extr == null )
				isAllFound = false;
			else
				extractedItems.add(extr);	
			
		}
		
		//assertFalse( items.containsAll(extractedItems) );
		
		assertFalse( isAllFound );		
	}
	

}
