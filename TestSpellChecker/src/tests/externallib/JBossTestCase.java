package tests.externallib;

import java.util.ArrayList;

import org.jboss.cache.Cache;
import org.jboss.cache.CacheFactory;
import org.jboss.cache.DefaultCacheFactory;
import org.jboss.cache.Fqn;
import org.jboss.cache.Node;
import org.jboss.cache.Region;
import org.jboss.cache.config.Configuration;
import org.jboss.cache.config.Configuration.CacheMode;
import org.jboss.cache.config.EvictionAlgorithmConfig;
import org.jboss.cache.config.EvictionConfig;
import org.jboss.cache.config.EvictionRegionConfig;
import org.jboss.cache.eviction.LRUAlgorithmConfig;
import org.jboss.cache.lock.IsolationLevel;
import org.jboss.cache.transaction.GenericTransactionManagerLookup;

import junit.framework.TestCase;

public class JBossTestCase extends TestCase {

	
	Cache cache;
	Fqn defaultFqn;
	Fqn testFqn;
	
	int maxNodes = 1;
	   	
	
	protected void setUp() throws Exception {
		super.setUp();
		
		   Configuration config = new Configuration();

		   config.setCacheMode(CacheMode.LOCAL);

		   //config.setLockAcquisitionTimeout(15000);

		   defaultFqn = Fqn.fromString("_default_");
		   EvictionConfig defaultConfig = new EvictionConfig();
		   EvictionRegionConfig defaultEvictionRegionConfig = new EvictionRegionConfig();
		   defaultEvictionRegionConfig.setRegionFqn(defaultFqn);
		   
		   
		   EvictionAlgorithmConfig algConfig = new LRUAlgorithmConfig(0, 0, maxNodes);
		   defaultEvictionRegionConfig.setEvictionAlgorithmConfig( algConfig );
		   
		   this.testFqn = Fqn.fromString("/app/test");
		   
		   EvictionRegionConfig testRegion = new EvictionRegionConfig();
		   testRegion.setRegionFqn(testFqn);
		   testRegion.setDefaults(defaultEvictionRegionConfig);
		   
		   defaultConfig.addEvictionRegionConfig(defaultEvictionRegionConfig );
		   defaultConfig.addEvictionRegionConfig( testRegion  );
		   
		   
		   
		   config.setEvictionConfig(defaultConfig);
		   
		   CacheFactory factory = new DefaultCacheFactory();

		   
		   
		   cache = factory.createCache(config);		
		   
	}

	
	@Override
	protected void tearDown() throws Exception {

		super.tearDown();
		cache.stop();
		cache.destroy();
	}
	
	
	public void testPut()
	{
		
		Object key = new Object();
		Object excpt = MockItem.create();
		
		cache.put(testFqn, key, excpt);
		
		Object actual = cache.get(testFqn, key);
		
		assertEquals(excpt, actual);
		
		
	}
	
	public void testMaxNodes()
	{
		
		int itemsCount = maxNodes + 50;
		
		ArrayList<MockItem> items = new ArrayList<MockItem>();
		
		
		
		
		Node node = cache.getRoot().addChild(testFqn);
		
		Region reg = cache.getRegion(node.getFqn(), true);
		
		for ( int indx = 0; indx < itemsCount; indx++ )
		{
			MockItem key = MockItem.create();
			MockItem excpt = key;
			
			items.add(excpt);
			
			node.put( key, excpt);		
		}
		
		
		reg.processEvictionQueues();
		
		boolean isAllFound = true;
		
		ArrayList<MockItem> extractedItems = new ArrayList<MockItem>();
		
		for (MockItem mockItem : items) {
			MockItem extr = (MockItem) node.get( mockItem);
			
			if ( extr == null )
				isAllFound = false;
			else
				extractedItems.add(extr);	
			
		}
		
		//assertFalse( items.containsAll(extractedItems) );
		
		assertFalse( isAllFound );
		
		
	}
	
}
