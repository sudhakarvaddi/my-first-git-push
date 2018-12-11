package framework_sudha;

import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Optional;
import org.testng.annotations.Parameters;

public class Configuration_vsr {
	private static ThreadLocal<Configuration_vsr> E = new ThreadLocal<>();

	public static void set(Configuration_vsr data) {
		E.set(data);
	}

	public static Configuration_vsr get() {

		return E.get();
	}

	@Parameters("environment")
	@BeforeSuite
	public static void env_Config(@Optional String environment) {

		environment = (environment == null) ? environment : "qa";
		Data_vsr.set(new Data_vsr());
		UtilityMethods_vsr.set(new UtilityMethods_vsr());
		switch (environment.toLowerCase()) {
		case "qa":
			Data_vsr.envconfig = UtilityMethods_vsr.get().readToMap("Config//envconfig_qa.property");
			break;
		case "dev":
			Data_vsr.envconfig = UtilityMethods_vsr.get().readToMap("Config//envconfig_dev.property");
			break;
		}
		Data_vsr.objectrepository = UtilityMethods_vsr.get().loadRepository("objectRepository//.xRepositoryml");
		Data_vsr.get().executionConfigData=UtilityMethods_vsr.get().readToMap("Config//execution_config.property");
		
		
	}

}


