package com.digitalchaos.cache;

import java.io.Serializable;

public interface Cache {

	void put(Object key, Serializable value);

	Object get(Object key);

	boolean isEmpty();
	
}
