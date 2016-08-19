package org.pcpt.sdk;

import java.util.concurrent.TimeUnit;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

/**
 * Class responsible to instantiate webdriver <br>
 * <br>
 * 
 * In order to get the driver instance in page/test class, should be used only
 * in the following way: <br>
 * <br>
 * 
 * WebDriver driver = DriverFactory.getInstance().getDriver();
 */
public class DriverFactory {
	private static DriverFactory instance = null;
	private static PropertiesReader propReader;
	private WebDriver driver;
	private String className = this.getClass().getSimpleName();

	private DriverFactory() {
	}

	/**
	 * Constructor
	 */
	public static DriverFactory getInstance() {
		propReader = new PropertiesReader(Constants.BUILD_PROERTIES_PATH);
		if (instance == null) {
			instance = new DriverFactory();
			new AllureConfiguration("report/allure-result");
		}
		return instance;
	}

	/**
	 * Instantiate WebDriver
	 * 
	 * <br>
	 * It reads the value of `remote.execution` from build.properties. If remote
	 * execution is enabled then it will instantiate a remove driver otherwise a
	 * local driver.
	 * 
	 * @return Instance of WebDriver
	 */
	public WebDriver getDriver() {
		String remoteEnabled = propReader.getPropertyValue("remote.execution");

		if (remoteEnabled == "false") {
			LogReporter.getInstance().logInfo(className, "Instantiated local driver");

			return getLocalDriver();
		} else if (remoteEnabled == "true") {
			LogReporter.getInstance().logInfo(className, "Instantiated remote driver");

			return getRemoteDriver();
		} else {
			LogReporter.getInstance().logInfo(className, "Instantiated local driver");

			return getLocalDriver();
		}
	}

	/**
	 * Private method to instantiate local webdriver by fetching the browser
	 * information from build.properties.Alos sets timeout for implicit wait and
	 * maximizes the window.<br>
	 * 
	 * <b>Note: Should not be called directly in test classes.</b>
	 * 
	 * @return Instance of WebDriver
	 */
	private WebDriver getLocalDriver() {
		String browserName = ConfigurationReader.getInstance().getPropertyValue("browser.name");
		String implicitWaitTimeout = propReader.getPropertyValue("implicit.timeout");
		Long timeout = Long.parseLong(implicitWaitTimeout);
		
		if (browserName.equals("chrome") || browserName.equals("Chrome")) {
			String chromeDriverPath = BrowserUtils.getInstance().getChromeDriverPath();
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			driver = new ChromeDriver();
			
			LogReporter.getInstance().logInfo(className, "Instantiated chrome driver");
		} else if (browserName.equals("Firefox") || browserName.equals("firefox")) {
			driver = new FirefoxDriver();
			
			LogReporter.getInstance().logInfo(className, "Instantiated ff driver");
		} else if (browserName.equals("ie") || browserName.equals("IE")) {
			driver = new InternetExplorerDriver();
			
			LogReporter.getInstance().logInfo(className, "Instantiated ie driver");
		} else {
			String chromeDriverPath = BrowserUtils.getInstance().getChromeDriverPath();
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			driver = new ChromeDriver();
			
			LogReporter.getInstance().logInfo(className, "Instantiated chrome driver");
		}

		driver.manage().timeouts().implicitlyWait(timeout, TimeUnit.SECONDS);
		driver.manage().window().maximize();
		
		return driver;
	}

	/**
	 * Private method to instantiate remote webdriver by fetching the browser
	 * information from build.properties.<br>
	 * 
	 * <b>Note: Should not be called directly in test classes.</b> TODO: Will be
	 * implemented later
	 * 
	 * @return Instance of WebDriver
	 */
	private WebDriver getRemoteDriver() {
		return driver;
	}
}
