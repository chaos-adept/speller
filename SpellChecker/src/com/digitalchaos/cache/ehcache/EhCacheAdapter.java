package com.digitalchaos.cache.ehcache;

import java.io.Serializable;

import net.sf.ehcache.Element;

import com.digitalchaos.cache.Cache;

public class EhCacheAdapter implements Cache {

	net.sf.ehcache.Cache adaptee;
	 
	public EhCacheAdapter( net.sf.ehcache.Cache adaptee )
	{
		this.adaptee = adaptee;
	}
	
	@Override
	public void put(Object key, Serializable value) {
		Element el = new Element(key, value);
		this.adaptee.put( el );

	}

	@Override
	public Object get(Object key) {
		return this.adaptee.get(key);
	}

	@Override
	public boolean isEmpty() {
		return this.adaptee.getSize() == 0;
	}

}
