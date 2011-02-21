package tests;

import com.digitalchaos.spell.Speller;
import com.digitalchaos.spell.spellers.yandexspeller.YandexSpeller;

public class YandexSpellerTestCase extends SpellerTestCase {

	@Override
	protected Speller createSpeller() {
		return new YandexSpeller();
	}


}
