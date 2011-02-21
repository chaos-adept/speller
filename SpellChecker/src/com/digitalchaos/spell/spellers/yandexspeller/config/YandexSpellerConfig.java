package com.digitalchaos.spell.spellers.yandexspeller.config;

import javax.swing.JFrame;

import com.digitalchaos.cache.Cache;
import com.digitalchaos.cache.CacheOptions;
import com.digitalchaos.cache.nullcache.NullCache;
import com.digitalchaos.spell.Speller;
import com.digitalchaos.spell.config.SpellerConfig;
import com.digitalchaos.spell.spellers.yandexspeller.YandexSpeller;
import com.digitalchaos.spell.spellers.yandexspeller.gui.YandexSpellerOptionsDialog;
import com.digitalchaos.spell.utils.CachedSpeller;

public class YandexSpellerConfig extends SpellerConfig {

	public boolean isCacheEnabled;
	public CacheOptions cacheOptions;	
	
	
	public YandexSpellerConfig(String name) {
		super(name, new YandexSpellerFactory());
	}
	
	static class YandexSpellerFactory implements SpellerFactory
	{
		@Override
		public Speller create(SpellerConfig config) {
			YandexSpellerConfig yaConfig = (YandexSpellerConfig) config;
			YandexSpeller yaSpeller = new YandexSpeller();
			
			if ( ! yaConfig.isCacheEnabled )
			{
				
				return yaSpeller;
			}
			else
				{
					
					Cache cache = new NullCache();
					CachedSpeller cachedSpeller = new CachedSpeller(yaSpeller, cache  );
					return cachedSpeller;
				}
			
		}
	}
	
	@Override
	public void configurate() {
		YandexSpellerOptionsDialog dialog = new YandexSpellerOptionsDialog();
		dialog.setModal(true);
		
		dialog.setCacheEnabled(isCacheEnabled);
		dialog.pack();
		dialog.setVisible(true);
		
		this.isCacheEnabled = dialog.isCacheEnabled();
		
		dialog.dispose();
		
		
		
	}
}
