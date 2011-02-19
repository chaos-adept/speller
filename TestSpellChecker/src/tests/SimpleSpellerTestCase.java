package tests;

import com.digitalchaos.spell.Speller;
import com.digitalchaos.spell.spellers.simplespeller.SimpleSpeller;


public class SimpleSpellerTestCase extends SpellerTestCase {

	
	@Override
	protected Speller createSpeller() {
		
		SimpleSpeller simpleSpeller =  new SimpleSpeller();
		simpleSpeller.addCorrectWord(correntWord);
		return simpleSpeller;
	}


	
}
