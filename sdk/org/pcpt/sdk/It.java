package org.pcpt.sdk;

import org.openqa.selenium.WebElement;
import org.testng.Assert;

/**
 * Class contains global assertion methods
 */
public class It {

	/**
	 * Verifies specified webelement has expected text
	 * 
	 * @param element Web Element
	 * @param expectedText Expected text
	 */
	public static void shouldHaveText(WebElement element, String expectedText) {
		String actualText = element.getText();
		boolean isFlag = actualText.equalsIgnoreCase(expectedText);

		Assert.assertTrue(isFlag,
				"The actual text : " + actualText + "does not match with expected text :" + expectedText);
	}
	
	/**
	 * Verifies specified webelement is visible on the page
	 * 
	 * @param element Web Element
	 * @param logMessage Log message 
	 */
	public static void shouldBeVisible(WebElement element, String logMessage) {
		Assert.assertTrue(element.isDisplayed(), logMessage);
	}
	
	/**
	 * Verifies specified webelement is visible on the page
	 * 
	 * @param element Web Element
	 */
	public static void shouldBeVisible(WebElement element) {
		final String logMessage = "Specified webelement has been displayed on the page";
		
		Assert.assertTrue(element.isDisplayed(), logMessage);
	}
}
