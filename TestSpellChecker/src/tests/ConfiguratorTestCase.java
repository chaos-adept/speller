package tests;

import com.digitalchaos.spell.Speller;
import com.digitalchaos.spell.config.SpellerConfig;
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
		
		SpellerConfig expectedConfig = new SpellerConfig(configName);
		
		spellerConfigurator.addConfig( expectedConfig );
		
		SpellerConfig actualConfig = spellerConfigurator.getConfig( configName );
		
		assertSame(expectedConfig, actualConfig);
		
	}
	
	public void testCreatingSpeller()
	{
		String configName = "test";
		
		SpellerConfig config = new SpellerConfig(configName);
		//config.configName = configName;
		
		final SimpleSpeller expectedSpeller = new SimpleSpeller();
		
		config.spellerFactory = new SpellerConfig.SpellerFactory() {
			
			@Override
			public Speller create() {
				return expectedSpeller;
			}
		};;;
		
		spellerConfigurator.addConfig( config );
		
		spellerConfigurator.setDefaultConfig(configName);
		
		Speller actualSpeller = spellerConfigurator.getDefaultConfig().spellerFactory.create();

		assertSame(expectedSpeller, actualSpeller);
		
	}
	

	protected void tearDown() throws Exception {
		super.tearDown();
	}

}
