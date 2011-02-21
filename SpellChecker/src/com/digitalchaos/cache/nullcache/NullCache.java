package com.digitalchaos.cache.nullcache;

import java.io.Serializable;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;
import java.util.TreeMap;

import com.digitalchaos.cache.Cache;
import com.digitalchaos.cache.CacheOptions;

public class NullCache implements Cache {

	//LinkedList<Serializable> removingQuene;
	Map<Object, Serializable> container;
	
	public NullCache(CacheOptions cacheOptions) {
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

}
