package tests;

import com.digitalchaos.spell.Speller;

import junit.framework.TestCase;

public class SpellerTestCase extends TestCase {

	
	Speller speller;
	
	String correntWord;
	String wrongWord;
	
	@Override
	protected void setUp() throws Exception {
		super.setUp();
		speller =  new Speller();
		correntWord = "correct";
		wrongWord = "noncorrect";
		
	}
	
	public void testCorrectlyWord()
	{
		boolean result = speller.checkText(correntWord);
		assertTrue( result );
	}
	
	public void testWrongWord()
	{
		boolean result = speller.checkText(wrongWord);
		assertFalse( result );
	}
	
	
}
