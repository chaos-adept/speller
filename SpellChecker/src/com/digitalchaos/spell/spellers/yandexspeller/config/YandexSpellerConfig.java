package com.digitalchaos.spell.spellers.yandexspeller.config;

import javax.swing.JFrame;

import com.digitalchaos.cache.CacheOptions;
import com.digitalchaos.spell.Speller;
import com.digitalchaos.spell.config.SpellerConfig;
import com.digitalchaos.spell.spellers.yandexspeller.YandexSpeller;
import com.digitalchaos.spell.spellers.yandexspeller.gui.YandexSpellerOptionsDialog;

public class YandexSpellerConfig extends SpellerConfig {

	public boolean isEnableCache;
	public CacheOptions cacheOptions;	
	
	
	public YandexSpellerConfig(String name) {
		super(name, new YandexSpellerFactory());
	}
	
	static class YandexSpellerFactory implements SpellerFactory
	{
		@Override
		public Speller create(SpellerConfig config) {
			return new YandexSpeller();
		}
	}
	
	@Override
	public void configurate() {
		YandexSpellerOptionsDialog dialog = new YandexSpellerOptionsDialog();
		dialog.setModal(true);
		dialog.setVisible(true);
		dialog.dispose();
		
	}
}
