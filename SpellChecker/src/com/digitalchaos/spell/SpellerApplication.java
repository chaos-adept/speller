package com.digitalchaos.spell;

import javax.swing.JFrame;

import com.digitalchaos.spell.config.SpellerConfig;
import com.digitalchaos.spell.config.SpellerConfig.SpellerFactory;
import com.digitalchaos.spell.config.SpellerConfigurator;
import com.digitalchaos.spell.gui.SpellerFrame;
import com.digitalchaos.spell.spellers.simplespeller.SimpleSpeller;
import com.digitalchaos.spell.spellers.simplespeller.config.SimpleSpellerConfig;
import com.digitalchaos.spell.spellers.yandexspeller.config.YandexSpellerConfig;

public class SpellerApplication {

	public static void main(String[] args) {	
		Run();
	}
	
	public static void Run()
	{
		SpellerApplication app = new SpellerApplication();
		app.run();
	}
	
	Speller speller;
	SpellerFrame frame;
	
	SpellerConfigurator spellerConfig;
	
	public SpellerApplication()
	{
		
		constructConfig();
		
		Speller speller = createDefaultSpeller();
		
		this.frame = new SpellerFrame( speller , spellerConfig );
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();		
		
		run();			
	}

	private void constructConfig() {
		spellerConfig = new SpellerConfigurator();

		SimpleSpellerConfig simpleSpellerConfig = new SimpleSpellerConfig( "Simple Speller", this.frame );
		spellerConfig.addConfig(simpleSpellerConfig);
		
		YandexSpellerConfig yaSpellerConfig = new YandexSpellerConfig("Yandex Speller");
		spellerConfig.addConfig(yaSpellerConfig);
		
		spellerConfig.setDefaultConfig(simpleSpellerConfig.name);
	}

	private Speller createDefaultSpeller() {
		return spellerConfig.getDefaultConfig().constructSpeller();
	}

	public void run() {
		frame.setVisible(true);
	}
	




}
