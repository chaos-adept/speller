package com.digitalchaos.spell.config;

import java.util.Map;
import java.util.TreeMap;

public class SpellerConfigurator {

	Map<String, SpellerConfig> configs;
	
	protected String defaultConfigName;
	
	public SpellerConfigurator()
	{
		configs = new TreeMap<String, SpellerConfig>();
	}
	
	public void addConfig(SpellerConfig config) 
	{
		configs.put(config.name, config);
	}

	public SpellerConfig getConfig(String configName) {
		return configs.get(configName);
	}

	public void setDefaultConfig(String configName) {
		defaultConfigName = configName;
		
	}

	public SpellerConfig getDefaultConfig() {
		
		//TODO надо заменить типы эксепшенов на более подходящие
		if (defaultConfigName == null)
			throw new RuntimeException("default config name not defined");
		
		SpellerConfig defaultConfig = getConfig(defaultConfigName);
		
		if ( defaultConfig == null )
			throw new RuntimeException( "cant find default config by name '" + defaultConfigName + "'");
		
		return defaultConfig;
	}

	
}
