package tests;

import com.digitalchaos.cache.Cache;
import com.digitalchaos.cache.CacheFactories;
import com.digitalchaos.cache.CacheFactory;
import com.digitalchaos.cache.CacheOptions;

import junit.framework.TestCase;

public class FactoriesTestCase extends TestCase {

	CacheFactories factories;
	
	String providerName;
	
	protected void setUp() throws Exception {
		super.setUp();
		
		factories = new CacheFactories();
		providerName = "mockProvider";
		CacheFactory factory = new MockFactory();
		factories.registryCacheFactory(providerName, factory );
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}
	
	public void testGettingProviders()
	{
		assertNotNull( factories.getCacheProviders() );
	}
	
	public void testGetFactoryByProvider()
	{
		assertNotNull( factories.getFactory(providerName) );
	}
	
	
	
	public class MockFactory implements CacheFactory
	{
		@Override
		public Cache create(CacheOptions options) {
			return null;
		}

		@Override
		public boolean isCanBeLimited() {
			// TODO Auto-generated method stub
			return false;
		}

		@Override
		public String[] getMemoryManagmentAlgorithmNames() {
			// TODO Auto-generated method stub
			return null;
		}

		@Override
		public String[] getDiskManagmentAlgorithmNames() {
			// TODO Auto-generated method stub
			return null;
		}
		
	}

}
