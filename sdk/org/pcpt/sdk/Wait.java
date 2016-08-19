package org.pcpt.sdk;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.support.ui.ExpectedCondition;
import org.openqa.selenium.support.ui.WebDriverWait;

/**
 * Class contains common reusable explicit waits
 */
public class Wait {
	private WebDriver driver;
	private static PropertiesReader propReader;
	private int timeout;

	/**
	 * Constructor
	 */
	Wait(WebDriver driver) {
		this.driver = driver;
		propReader = new PropertiesReader(Constants.BUILD_PROERTIES_PATH);
		String tout = propReader.getPropertyValue("explicit.timeout");
		timeout = Integer.parseInt(tout);
	}

	/**
	 * Waits until angular finishes http calls in backend
	 */
	public void untilAngularFinishesHttpCalls() {
		final String javaScriptToLoadAngular = "var injector = window.angular.element('body').injector();"
				+ "var $http = injector.get('$http');" + "return ($http.pendingRequests.length === 0)";

		ExpectedCondition<Boolean> pendingHttpCallsCondition = new ExpectedCondition<Boolean>() {
			public Boolean apply(WebDriver driver) {
				return ((JavascriptExecutor) driver).executeScript(javaScriptToLoadAngular).equals(true);
			}
		};
		WebDriverWait wait = new WebDriverWait(driver, timeout);
		wait.until(pendingHttpCallsCondition);
	}
}
