package com.digitalchaos.spell.utils;

import com.digitalchaos.cache.Cache;
import com.digitalchaos.spell.Speller;

public class CachedSpeller implements Speller {

	Speller adaptee;
	Cache cache;
	
	public CachedSpeller(Speller adaptee, Cache cache)
	{
		this.adaptee = adaptee;
		this.cache = cache;
	}
	
	@Override
	public boolean checkText(String word) {
		Boolean cachedResult = (Boolean) this.cache.get(word);
		if ( cachedResult != null )
		{
			return cachedResult;
		}
		else
			{
				Boolean calcedResult = this.adaptee.checkText(word);
				cache.put(word, calcedResult);
				return calcedResult;
			}
	}

}
