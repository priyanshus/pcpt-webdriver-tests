package org.pcpt.sdk;

/**
 * Class responsible to provider browser driver for Chrome and Internet Explorer
 * <br>
 * <br>
 * 
 * Class fetches information about current operating system and arch bit and
 * provides the path of browser driver. The browsr drivers are located at:<br>
 * <br>
 * [project-directory]/libs/browser-driver/[operating-system]/[os-bits]/driver
 * 
 * <br>
 */
public class BrowserUtils {
	private static BrowserUtils instance = null;

	private static final String DRIVERS_FOLDER = "/browser-drivers";
	private String className = this.getClass().getSimpleName();

	private BrowserUtils() {
	}

	public static BrowserUtils getInstance() {
		if (instance == null)
			instance = new BrowserUtils();
		return instance;
	}

	/**
	 * Check if current os is 64bits or not
	 * 
	 * @return boolean
	 */
	private boolean is64bitSystem() {
		boolean is64bit = false;
		if (System.getProperty("os.name").contains("Windows")) {
			is64bit = (System.getenv("ProgramFiles(x86)") != null);

		} else {
			is64bit = (System.getProperty("os.arch").indexOf("64") != -1);
		}
		
		LogReporter.getInstance().logInfo(className, "Found the system as 64bit: " + is64bit);
		return is64bit;
	}

	/**
	 * Get the name of current operation system
	 * 
	 * @return String
	 */
	private String getOsFamily() {
		String osName = System.getProperty("os.name");
		LogReporter.getInstance().logInfo(className, "Found the os as: " + osName);
		return osName;
	}

	/**
	 * Method responsible to get the path of chrome driver based on current
	 * operating system and arch bits
	 * 
	 * @return String
	 */
	public String getChromeDriverPath() {
		String path = System.getProperty("user.dir") + DRIVERS_FOLDER;

		String osFamily = getOsFamily();
		boolean is64bitSystem = is64bitSystem();

		if (osFamily.contains("Windows")) {
			path += "/windows/<bits>/chromedriver.exe";
		} else if (osFamily.contains("Linux")) {
			path += "/linux/<bits>/chromedriver";
		} else if (osFamily.contains("Mac")) {
			path += "/mac/<bits>/chromedriver";
		}

		if (is64bitSystem) {
			path = path.replace("<bits>", "64bits");
		} else {
			path = path.replace("<bits>", "32bits");
		}
		
		LogReporter.getInstance().logInfo(className, "Found chrome driver path as: " + path);
		return path;
	}

	/**
	 * Method responsible to get the path of ie driver based on current
	 * operating system and arch bits
	 * 
	 * @return String
	 */
	public String getIEDriverPath() {
		String path = System.getProperty("user.dir");

		String osFamily = getOsFamily();
		boolean is64bitSystem = is64bitSystem();
		if (osFamily.contains("Windows")) {
			path += "/windows/<bits>/iedriver.exe";
		} else {
			System.err.println("IE Driver is not available for currect operating system");
		}

		if (is64bitSystem) {
			path.replace("<bits>", "64bits");
		} else {
			path.replace("<bits>", "32bits");
		}
		
		LogReporter.getInstance().logInfo(className, "Found ie driver path as: " + path);
		return path;
	}
}
