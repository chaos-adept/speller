package tests;

import java.io.Serializable;

import com.digitalchaos.cache.Cache;
import com.digitalchaos.spell.Speller;
import com.digitalchaos.spell.spellers.simplespeller.SimpleSpeller;
import com.digitalchaos.spell.utils.CachedSpeller;

public class CachedSpellerTestCase extends SpellerTestCase {

	MockCache mockCache;
	
	@Override
	protected Speller createSpeller() {
		
		SimpleSpeller adaptee = new SimpleSpeller();
		adaptee.addCorrectWord(correntWord);
		
		mockCache = new CachedSpellerTestCase.MockCache();
		CachedSpeller speller = new CachedSpeller(adaptee, mockCache);
		
		return speller;
	}
	
	public void testCacheRequesting()
	{
		String key = "someword";
		mockCache.hasCacheValue = true;
		boolean actualResult = speller.checkText(key);
		
		assertTrue(mockCache.wasRequested);
		assertEquals( mockCache.cacheValue , actualResult);
		
	}
	
	public void testPutting()
	{
		mockCache.hasCacheValue = false;
		boolean actualResult = speller.checkText(correntWord);
		assertTrue(mockCache.wasPutted);
		assertEquals( mockCache.cacheValue , actualResult);
	}
	
	public class MockCache implements Cache
	{
		public boolean wasRequested;
		public boolean wasPutted;
		public boolean cacheValue = true;
		public boolean puttedValue = false;
		public boolean hasCacheValue = false;
		
		@Override
		public void put(Object key, Serializable value) {
			wasPutted = true;
			puttedValue = (Boolean)value;
		}

		@Override
		public Object get(Object key) {
			
			wasRequested = true;
			
			if (hasCacheValue)
				return cacheValue;
			
			return null;
		}

		@Override
		public boolean isEmpty() {
			return false;
		}
		
	}

}
