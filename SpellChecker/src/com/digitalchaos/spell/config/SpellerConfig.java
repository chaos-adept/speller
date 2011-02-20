package com.digitalchaos.spell.config;

import com.digitalchaos.spell.Speller;
import com.digitalchaos.spell.config.SpellerConfig.SpellerFactory;

public class SpellerConfig {

	public String name;
	public SpellerFactory spellerFactory;
	
	public SpellerConfig(String name)
	{
		this.name = name;
	}
	
	public interface SpellerFactory
	{
		public Speller create();
	}
	
	
}
