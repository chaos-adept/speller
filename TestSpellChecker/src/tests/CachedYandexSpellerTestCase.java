package tests;

import com.digitalchaos.cache.CacheOptions;
import com.digitalchaos.cache.nullcache.NullCache;
import com.digitalchaos.spell.Speller;
import com.digitalchaos.spell.spellers.yandexspeller.YandexSpeller;
import com.digitalchaos.spell.utils.CachedSpeller;

public class CachedYandexSpellerTestCase extends YandexSpellerTestCase {
	
	@Override
	protected Speller createSpeller() {
		YandexSpeller yaSpeller = (YandexSpeller) super.createSpeller();
		
		NullCache nullCache = new NullCache();
		
		CachedSpeller cachedSpeller = new CachedSpeller( yaSpeller , nullCache );
		return cachedSpeller;
	}
	
	

}
