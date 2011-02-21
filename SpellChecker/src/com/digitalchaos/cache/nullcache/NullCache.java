package com.digitalchaos.cache.nullcache;

import java.io.Serializable;

import com.digitalchaos.cache.Cache;

public class NullCache implements Cache {

	@Override
	public void put(Object key, Serializable value) {
		
	}

	@Override
	public Object get(Object key) {
		return null;
	}

	@Override
	public boolean isEmpty() {
		return true;
	}

	


}
