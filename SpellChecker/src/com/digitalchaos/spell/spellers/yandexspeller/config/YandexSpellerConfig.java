package com.digitalchaos.spell.spellers.yandexspeller.config;

import javax.swing.JFrame;

import com.digitalchaos.cache.Cache;
import com.digitalchaos.cache.CacheFactories;
import com.digitalchaos.cache.CacheFactory;
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
	
	protected CacheFactories factories;	
	
	public YandexSpellerConfig(String name, CacheFactories factories) {
		super(name, new YandexSpellerFactory(factories));
		this.factories = factories;
	}
	
	static class YandexSpellerFactory implements SpellerFactory
	{
		protected CacheFactories factories;
		
		public YandexSpellerFactory(CacheFactories factories) {
			this.factories = factories;
		}

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
					CacheFactory cacheFactory = this.factories.getFactory(yaConfig.cacheOptions.providerName);
					Cache cache = cacheFactory.create(yaConfig.cacheOptions);
					CachedSpeller cachedSpeller = new CachedSpeller(yaSpeller, cache);
					return cachedSpeller;
				}
			
		}
	}
	
	@Override
	public void configurate() {
		
		
		
		YandexSpellerOptionsDialog dialog = new YandexSpellerOptionsDialog(factories);
		dialog.setModal(true);
		
		dialog.setCacheEnabled(isCacheEnabled);
		dialog.setCacheOptions(cacheOptions);
		dialog.pack();
		dialog.setVisible(true);
		
		this.isCacheEnabled = dialog.isCacheEnabled();
		this.cacheOptions = dialog.genCacheOptions();
		
		
		
		dialog.dispose();
		
		
		
	}
}
