package org.pcpt.sdk;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeSuite;

/**
 * Test base which is responsible to launch the browser and
 * closes the open browser instances at the end of execution
 * <br><br>
 * 
 * <b>Note:</b> All test classed should extend this test base
 */
public class TestBase {
	private WebDriver driver;
	private String url;

	@BeforeSuite
	public void setup() {
		PropertiesReader prop = new PropertiesReader(Constants.BUILD_PROERTIES_PATH);
		url = prop.getPropertyValue("url");

		driver = DriverFactory.getInstance().getDriver();
		driver.get(url);
	}

	@AfterSuite
	public void teardown() {
		driver.quit();
	}
}
