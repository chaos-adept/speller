package tests;

import com.digitalchaos.spell.Speller;

import junit.framework.TestCase;

public abstract class SpellerTestCase extends TestCase {

	Speller speller;
	protected String correntWord;

	protected abstract Speller createSpeller();

	protected String wrongWord;

	public SpellerTestCase() {
		super();
	}

	public SpellerTestCase(String name) {
		super(name);
	}

	@Override
	protected void setUp() throws Exception {
		super.setUp();
		
		initTexts();
		
		speller = createSpeller();
	}

	public void testCorrectlyWord() {
		boolean result = speller.checkText(correntWord);
		assertTrue( result );
	}

	public void testWrongWord() {
		boolean result = speller.checkText(wrongWord);
		assertFalse( result );
	}

	protected void initTexts()
	{
		correntWord = "correct";
		wrongWord = "noncorrect";
	}

}