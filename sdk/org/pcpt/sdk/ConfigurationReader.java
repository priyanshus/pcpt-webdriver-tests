package org.pcpt.sdk;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

public class ConfigurationReader {
private static ConfigurationReader instance = null;
private static Properties prop;
private static HashMap<String, String> cachedProps;
	
	private static final String BUILD_PROPERTIES_PATH = "/build.properties";
	
	private ConfigurationReader() {
	}
	
	public static ConfigurationReader getInstance() {
		if (instance == null) {

			instance = new ConfigurationReader();
			loadProperties();
		}

		return instance;
	}
	
	/**
	 * Load properties file
	 * 
	 * @param path
	 *            Path of the file
	 */
	private static void loadProperties() {
		String path = System.getProperty("user.dir") + BUILD_PROPERTIES_PATH;
		prop = new Properties();
		cachedProps = new HashMap<String, String>();
		try {
			prop.load(new FileInputStream(path));
		} catch (FileNotFoundException f) {
			System.out.println("Could not find the properties file");
			f.printStackTrace();
		} catch (IOException e) {
			System.out.println("Could not load the properties file");
			e.printStackTrace();
		}
	}
	
	/**
	 * Reads the value of given key from properties file
	 * 
	 * @param key
	 *            Key
	 * @return String value of specified key
	 */
	public String getPropertyValue(String key) {
		if (cachedProps.get(key) == null) {
			String value = prop.getProperty(key);

			if (value == null) {
				System.err.println("No such key '" + key + "' exist in properties file");
				return null;
			}
			cachedProps.put(key, value);
			return value;
		} else {
			return cachedProps.get(key);
		}
	}
}
