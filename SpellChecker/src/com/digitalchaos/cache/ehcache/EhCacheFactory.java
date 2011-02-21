package com.digitalchaos.cache.ehcache;

import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import net.sf.ehcache.Cache;
import net.sf.ehcache.CacheManager;
import net.sf.ehcache.config.CacheConfiguration;
import net.sf.ehcache.store.MemoryStoreEvictionPolicy;

import com.digitalchaos.cache.CacheFactory;
import com.digitalchaos.cache.CacheOptions;

public class EhCacheFactory implements CacheFactory {

	Map<String, MemoryStoreEvictionPolicy> memoryManagmentMapping;
	
	CacheManager manager;
	
	public static int cachesCounter = 0;
	
	public EhCacheFactory()
	{
		memoryManagmentMapping = new HashMap<String, MemoryStoreEvictionPolicy>();
		memoryManagmentMapping.put("FIFO", MemoryStoreEvictionPolicy.FIFO);
		memoryManagmentMapping.put("LFU", MemoryStoreEvictionPolicy.LFU);
		memoryManagmentMapping.put("LRU", MemoryStoreEvictionPolicy.LRU);
		
		manager = CacheManager.create();
	}
	
	@Override
	public com.digitalchaos.cache.Cache create(CacheOptions options) {

	   CacheConfiguration config = new CacheConfiguration();
	   config.name( genCacheName() );
	   MemoryStoreEvictionPolicy memEvictPolicy = memoryManagmentMapping.get(options.memoryManagmentAlgorithmName);
	   
	   config.memoryStoreEvictionPolicy(memEvictPolicy);
	   
	   config.setMaxElementsInMemory(options.maxMemoryElementCount);
	   config.overflowToDisk(true);
	   config.maxElementsOnDisk( options.maxDiskElementCount );
	   config.diskPersistent(false);
	   config.eternal(false);
	   config.diskSpoolBufferSizeMB(1);
	   config.diskExpiryThreadIntervalSeconds(1500);	
	   
	   Cache cache = new Cache( config );
	   
	   manager.addCache(cache);			
		
	   return new EhCacheAdapter(cache);
	}

	private String genCacheName() {
		cachesCounter++;
		return "cache" + ( cachesCounter );
	}

	@Override
	public boolean isCanBeLimited() {
		return true;
	}

	@Override
	public String[] getMemoryManagmentAlgorithmNames() {
		Set<String> keys = memoryManagmentMapping.keySet();
		
		return keys.toArray(new String[keys.size()]);
	}

	@Override
	public String[] getDiskManagmentAlgorithmNames() {
		return new String[] {"default"};
	}

}
