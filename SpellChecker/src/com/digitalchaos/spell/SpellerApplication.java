package com.digitalchaos.spell;

import javax.swing.JFrame;

import com.digitalchaos.spell.gui.SpellerFrame;
import com.digitalchaos.spell.spellers.simplespeller.SimpleSpeller;
import com.digitalchaos.spell.spellers.yandexspeller.YandexSpeller;

public class SpellerApplication {

	public static void main(String[] args) {	
		Speller speller = createYandexSpeller();
		
		JFrame frame = new SpellerFrame( speller );
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.pack();
		frame.setVisible(true);		
	}

	protected static Speller createYandexSpeller() {
		return new YandexSpeller();
	}

	protected static Speller createSimpleSpeller() {
		SimpleSpeller speller = new SimpleSpeller();
		speller.addCorrectWord("word");
		return speller;
	}

}
