package genericUtility;

import java.io.FileInputStream;
import java.util.Properties;

public class PropertyFileUtility {
	public String toReadDataFromPropertiesFile(String key) throws Throwable {
		FileInputStream fis = new FileInputStream("./src/test/resources/CommonData.properties");
		Properties p = new Properties();
		p.load(fis);
		String value = p.getProperty(key);
		return value;

	}

}
