package org.pcpt.sdk;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;

import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Utility class which provides methods to read json test data files.
 */
public class TestDataReader {
	/**
	 * Maps json file to java class to access the json data
	 * 
	 * @param cls
	 *            Class to which json needs to be mapped
	 * @param path
	 *            Path of json file
	 * @return Instance of java class where json is mapped
	 */
	public static <T> T loadJsonFile(Class<T> cls, String path) {
		ObjectMapper mapper = new ObjectMapper();

		String dir = System.getProperty("user.dir") + path;
		dir = dir.replace("/", File.separator);

		try {
			FileInputStream file = new FileInputStream(new File(dir));
			T obj = mapper.readValue(file, cls);
			return obj;
		} catch (JsonMappingException e) {
			System.err.println("Could not map the provided json at path : " + dir);
			e.printStackTrace();
			return null;
		} catch (IOException e) {
			System.err.println("Could not find the provided json at path : " + dir);
			e.printStackTrace();
			return null;
		}
	}
}
