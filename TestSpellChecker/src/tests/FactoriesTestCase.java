package tests;

import com.digitalchaos.cache.CacheFactories;

import junit.framework.TestCase;

public class FactoriesTestCase extends TestCase {

	CacheFactories factories;
	
	protected void setUp() throws Exception {
		super.setUp();
		
		factories = new CacheFactories();
		
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testGettingProviders()
	{
		assertNotNull(  factories.getCacheProviders() );
	}

}
