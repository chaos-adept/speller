package tests;

import com.digitalchaos.cache.CacheOptions;
import com.digitalchaos.cache.nullcache.NullCache;
import com.digitalchaos.spell.Speller;
import com.digitalchaos.spell.spellers.yandexspeller.YandexSpeller;
import com.digitalchaos.spell.utils.CachedSpeller;

public class CachedYandexSpellerTestCase extends CachedSpellerTestCase {
	
	@Override
	protected Speller createAdapteeSpeller() {
		return new YandexSpeller();
	}
	

}
