package com.digitalchaos.spell.spellers.simplespeller.config;

import java.util.ArrayList;
import java.util.List;

import javax.swing.JFrame;

import com.digitalchaos.spell.Speller;
import com.digitalchaos.spell.config.SpellerConfig;
import com.digitalchaos.spell.spellers.simplespeller.SimpleSpeller;
import com.digitalchaos.spell.spellers.simplespeller.gui.SimpleSpellerOptionsDialog;

public class SimpleSpellerConfig extends SpellerConfig {

	
	protected ArrayList<String> correctWords;
	
	protected JFrame appFrame;
	
	public SimpleSpellerConfig(String name, JFrame appFrame) 
	{
		super(name, new SpellFactory() );
		correctWords = new ArrayList<String>();
		this.appFrame = appFrame;
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

	@Override
	public void configurate() {
		
		SimpleSpellerOptionsDialog dialog = new SimpleSpellerOptionsDialog(this.appFrame);
		dialog.setWords( getCorrectWords() );
		dialog.setModal(true);
		dialog.setVisible(true);
		if ( dialog.isAccepted() )
		{
			correctWords.clear();
			correctWords.addAll( dialog.getWords() );
			
		}
		
		dialog.dispose();
	}
	
}
