package com.digitalchaos.spell.spellers.yandexspeller;

import java.rmi.RemoteException;

import net.yandex.speller.services.spellservice.CheckTextRequest;
import net.yandex.speller.services.spellservice.CheckTextResponse;
import net.yandex.speller.services.spellservice.SpellError;
import net.yandex.speller.services.spellservice.SpellServiceSoapProxy;

import com.digitalchaos.spell.Speller;

public class YandexSpeller implements Speller {

	SpellServiceSoapProxy proxy;
	
	public YandexSpeller()
	{
		this.proxy = new SpellServiceSoapProxy();
	}
	
	@Override
	public boolean checkText(String word) {
		
		CheckTextRequest parameters = new CheckTextRequest(word, "", 0, "");
		try {
			CheckTextResponse response = proxy.checkText( parameters );
			
			SpellError[] errors = response.getSpellResult();
			return errors.length == 0;
			
		} catch (RemoteException e) {
			e.printStackTrace();
			throw new RuntimeException(e);
		}
	}

}
