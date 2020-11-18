package dataProviders;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

	private final String propertyFilePath = "configs/Configuration.properties";
	FileInputStream reader = null;
	static Properties properties = null;

	public ConfigFileReader() {
		try {
			reader = new FileInputStream(propertyFilePath);
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
	}

	public static String getBaseURL() {
		String baseURL = properties.getProperty("baseURL_Prod");
		if (baseURL != null)
			return baseURL;
		else
			throw new RuntimeException("baseURL not specified in the Configuration.properties file.");
	}

	public static String getMainPageTitle() {
		String title = properties.getProperty("Prod_title");
		if (title != null)
			return title;
		else
			throw new RuntimeException("Page title not specified in the Configuration.properties file.");
	}

	public static String getAPI_KEY() {
		String API_KEY = properties.getProperty("API_KEY");
		if (API_KEY != null)
			return API_KEY;
		else
			throw new RuntimeException("API_KEY not specified in the Configuration.properties file.");
	}

	public static String getBROWSER() {
		String BROWSER = properties.getProperty("BROWSER");
		if (BROWSER != null)
			return BROWSER;
		else
			throw new RuntimeException("BROWSER not specified in the Configuration.properties file.");
	}
}
