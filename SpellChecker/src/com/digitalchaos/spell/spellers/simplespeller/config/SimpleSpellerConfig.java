package com.digitalchaos.spell.spellers.simplespeller.config;

import java.util.ArrayList;
import java.util.List;

import com.digitalchaos.spell.Speller;
import com.digitalchaos.spell.config.SpellerConfig;
import com.digitalchaos.spell.spellers.simplespeller.SimpleSpeller;

public class SimpleSpellerConfig extends SpellerConfig {

	
	protected ArrayList<String> correctWords;
	
	public SimpleSpellerConfig(String name) 
	{
		super(name, new SpellFactory() );
		correctWords = new ArrayList<String>();
	}

	public List<String> getCorrectWords() 
	{
		return correctWords;
	}
	
	static class SpellFactory implements SpellerFactory
	{

		public SpellFactory() {

		}


		@Override
		public Speller create(SpellerConfig config) {
			SimpleSpellerConfig smplConf = (SimpleSpellerConfig)(config);
			
			SimpleSpeller speller = new SimpleSpeller();
			
			for (String word : smplConf.getCorrectWords()) {
				speller.addCorrectWord(word);
			}
			
			return speller;
		}
		
	}
	
}
