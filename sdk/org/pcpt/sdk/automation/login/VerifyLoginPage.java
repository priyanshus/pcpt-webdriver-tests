package org.pcpt.sdk.automation.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.pcpt.sdk.It;

/**
 * Verify content on login page
 */
public class VerifyLoginPage {
	private LoginPage loginPage;
	
	public VerifyLoginPage(WebDriver driver) {
		loginPage = PageFactory.initElements(driver, LoginPage.class);
	}
	
	/**
	 * Verify login page has displayed username input box
	 * 
	 * @param element WebElement for username input box
	 */
	public void hasDisplayedUserNameInputBox (WebElement element) {
		It.shouldBeVisible(loginPage.usernameInputBox);
	}
}
