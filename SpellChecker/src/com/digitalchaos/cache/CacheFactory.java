package com.digitalchaos.cache;

public interface CacheFactory {

	public Cache create( CacheOptions options );

	public boolean isCanBeLimited();

	public String[] getMemoryManagmentAlgorithmNames();

	public String[] getDiskManagmentAlgorithmNames();
	
	
	
}
