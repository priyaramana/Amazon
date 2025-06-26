package amazonUtils;

import java.util.Properties;

import org.apache.log4j.PropertyConfigurator;
import org.testng.log4testng.Logger;

public class LoggerClass {

	Properties prop;
	static Logger logger;
	static {
		PropertyConfigurator.configure("/Users/lt535j/eclipse-workspace/Amazon/log4j.properties");
		logger = Logger.getLogger(LoggerClass.class);
	}
	public void info(String message) {
		logger.info(message);
	}
}
