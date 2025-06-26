package amazonUtils;

import java.io.FileInputStream;
import java.util.Properties;

public class ConfigReader {

	static Properties prop;
	// static
	static {
		try {
			FileInputStream fis = new FileInputStream("/Users/lt535j/eclipse-workspace/Amazon/config.properties");
			prop = new Properties();
			prop.load(fis);
		}catch(Exception e) {
			
		}
	}
	// get properties
	public static Properties getProperties() {
		return prop;
	}
	// get property
	public String getProperty(String key) {
		return prop.getProperty(key);
	}
}
