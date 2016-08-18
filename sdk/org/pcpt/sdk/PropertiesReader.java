package org.pcpt.sdk;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.HashMap;
import java.util.Properties;

/**
 * Utility class to read the properties files
 * 
 * <br>
 * <br>
 * <b>Example:</b>
 * 
 * <pre>
 * {
 * 	&#64;code
 * 	PropertiesReader prop = new PropertiesReader(pathOfPropFile);
 * 	String value = prop.getPropertyValue(key);
 * 	System.out.println(value);
 * }
 * </pre>
 */
public class PropertiesReader {
	private Properties prop;
	private HashMap<String, String> cachedProps;

	/**
	 * Constructor
	 * 
	 * @param path
	 *            Path of the file
	 */
	public PropertiesReader(String path) {
		loadProperties(path);
	}

	/**
	 * Load properties file
	 * 
	 * @param path
	 *            Path of the file
	 */
	private void loadProperties(String path) {
		path = System.getProperty("user.dir") + path;
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
