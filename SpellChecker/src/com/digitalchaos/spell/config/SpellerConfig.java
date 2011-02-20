package com.digitalchaos.spell.config;

import com.digitalchaos.spell.Speller;
import com.digitalchaos.spell.config.SpellerConfig.SpellerFactory;

public class SpellerConfig {

	public String name;
	protected SpellerFactory spellerFactory;
	
	public SpellerConfig(String name, SpellerFactory spellerFactory)
	{
		this.name = name;
		this.spellerFactory = (spellerFactory);
	}

	protected SpellerFactory getSpellerFactory() {
		return spellerFactory;
	}

	public Speller constructSpeller()
	{
		return getSpellerFactory().create(this);
	}
	
	public interface SpellerFactory
	{
		public Speller create(SpellerConfig config);
	}
	
	
}
