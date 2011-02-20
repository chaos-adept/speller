package tests;

import java.util.List;

import com.digitalchaos.spell.Speller;
import com.digitalchaos.spell.config.SpellerConfig;
import com.digitalchaos.spell.config.SpellerConfig.SpellerFactory;
import com.digitalchaos.spell.config.SpellerConfigurator;
import com.digitalchaos.spell.spellers.simplespeller.SimpleSpeller;

import junit.framework.TestCase;

public class ConfiguratorTestCase extends TestCase {

	SpellerConfigurator spellerConfigurator;
	
	protected void setUp() throws Exception {
		super.setUp();
		
		spellerConfigurator = new SpellerConfigurator();
		
	}
	
	
	public void testAddConfiguration()
	{
		String configName = "test";
		
		SpellerConfig expectedConfig = createConfig(configName);
		
		spellerConfigurator.addConfig( expectedConfig );
		
		SpellerConfig actualConfig = spellerConfigurator.getConfig( configName );
		
		assertSame(expectedConfig, actualConfig);
		
	}

	protected SpellerConfig createConfig(String configName)
	{
		return createConfig(configName , new SpellerFactory() {
			
			@Override
			public Speller create(SpellerConfig config) {
				return null;
			}
		});
	}

	protected SpellerConfig createConfig(String configName, SpellerFactory factory) {
		return new SpellerConfig(configName,factory);
	}
	
	public void testCreatingSpeller()
	{
		String configName = "test";
		
		
		//config.configName = configName;
		
		final SimpleSpeller expectedSpeller = new SimpleSpeller();
		
		
		SpellerConfig.SpellerFactory factory = (new SpellerConfig.SpellerFactory() {
			@Override
			public Speller create(SpellerConfig config) {
				return expectedSpeller;
			}
		});;;
		
		SpellerConfig config = createConfig(configName, factory);
		
		spellerConfigurator.addConfig( config );
		
		spellerConfigurator.setDefaultConfig(configName);
		
		Speller actualSpeller = spellerConfigurator.getDefaultConfig().constructSpeller();

		assertSame(expectedSpeller, actualSpeller);
		
	}
	
	public void testGettingConfigList()
	{
		
		String[] expectedConfgNames = new String[] { "some1" , "some2"};
		
		for (String name : expectedConfgNames) {
			spellerConfigurator.addConfig( createConfig(name) );
		}
		
		List<String> actualconfNames = spellerConfigurator.getConfigNames();
		
		for (String name : expectedConfgNames) {
			boolean isContain = actualconfNames.contains(name);
			assertTrue( isContain );
		}
	}

	protected void tearDown() throws Exception {
		super.tearDown();
	}

}
