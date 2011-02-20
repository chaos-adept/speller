package com.digitalchaos.spell.spellers.yandexspeller.config;

import com.digitalchaos.spell.Speller;
import com.digitalchaos.spell.config.SpellerConfig;
import com.digitalchaos.spell.spellers.yandexspeller.YandexSpeller;

public class YandexSpellerConfig extends SpellerConfig {

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
}
