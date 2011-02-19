package com.digitalchaos.spell.spellers.simplespeller;

import java.util.Set;
import java.util.TreeSet;

import com.digitalchaos.spell.Speller;

public class SimpleSpeller implements Speller 
{
	Set<String> correctWords;
	
	public SimpleSpeller()
	{
		correctWords = new TreeSet<String>();
	}
	
	public void addCorrectWord( String word )
	{
		correctWords.add(word);
	}
	
	@Override
	public boolean checkText(String word)
	 {
		 return correctWords.contains(word);
	 }
}
