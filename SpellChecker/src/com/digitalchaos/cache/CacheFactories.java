package com.digitalchaos.cache;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.digitalchaos.cache.nullcache.NullCache;
import com.digitalchaos.cache.plaincache.PlainCache;

public class CacheFactories 
{
	
	Map<String, CacheFactory> registry;
	
	public CacheFactories()
	{
		registry = new HashMap<String, CacheFactory>();
		
		registryCacheFactory("Null cache", new CacheFactory() {

			@Override
			public Cache create(CacheOptions options) {
				return new NullCache();
			}

			@Override
			public boolean isCanBeLimited() {
				return false;
			}

			@Override
			public String[] getMemoryManagmentAlgorithmNames() {
				return new String[] {"none"};
			}

			@Override
			public String[] getDiskManagmentAlgorithmNames() {
				return new String[] {"none"};
			}
		});
		
		registryCacheFactory("Plain cache", new CacheFactory() {

			@Override
			public Cache create(CacheOptions options) {
				return new PlainCache(options);
			}

			@Override
			public boolean isCanBeLimited() {
				return false;
			}
			
			@Override
			public String[] getMemoryManagmentAlgorithmNames() {
				return new String[] {"none"};
			}

			@Override
			public String[] getDiskManagmentAlgorithmNames() {
				return new String[] {"none"};
			}			
			
		});
		
	}
	
	public void registryCacheFactory( String name , CacheFactory factory )
	{
		registry.put(name, factory);
	}
	
	public String[] getCacheProviders()
	{
		Set<String> keySet = registry.keySet();
		return keySet.toArray( new String[keySet.size()] );
	}

	public CacheFactory getFactory(String name) {
		return registry.get(name);
	}
	
	
}
