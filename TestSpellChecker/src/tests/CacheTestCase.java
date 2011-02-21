package tests;

import java.io.Serializable;
import java.util.ArrayList;

import com.digitalchaos.cache.Cache;
import com.digitalchaos.cache.CacheOptions;
import com.digitalchaos.cache.nullcache.NullCache;

import junit.framework.TestCase;

public class CacheTestCase extends TestCase {

	Cache cache;
	CacheOptions cacheOptions;
	
	protected void setUp() throws Exception {
		super.setUp();
		cacheOptions = new CacheOptions();
		cacheOptions.maxElements = 1;
		cache = new NullCache(cacheOptions);
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testPut()
	{
		Serializable expected = new MockCacheItem();
		Object key = new Object();
		cache.put( key , expected);
		
		Object actual = cache.get(key);
		
		assertSame(expected, actual);
	}
	
	public void testMaxElements()
	{
		ArrayList<Object> expecteds = new ArrayList<Object>();
		for (int i = 0; i < cacheOptions.maxElements; i++) {
			
			MockCacheItem value = new MockCacheItem();
			Object key = value;
			
			expecteds.add(value);
			
			cache.put(key, value);
		}
		
		
		for (Object value : expecteds) {
			
			Object key = value;
			
			Object actual = cache.get(key);
			assertSame(value, actual);
		}
		
	}

	public class MockCacheItem implements Serializable
	{
		
	}
	
}
