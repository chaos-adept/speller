package com.digitalchaos.cache.plaincache;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

import com.digitalchaos.cache.Cache;
import com.digitalchaos.cache.CacheOptions;

public class PlainCache implements Cache {

	Map<Object, Serializable> container;
	
	public PlainCache(CacheOptions cacheOptions) {
		container = new HashMap<Object, Serializable>();
	}

	@Override
	public void put(Object key, Serializable value) {
		container.put(key, value);
		
	}

	@Override
	public Object get(Object key) {
		return container.get(key);
	}

	@Override
	public boolean isEmpty() {
		return container.isEmpty();
	}

}
