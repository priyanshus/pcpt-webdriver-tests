package org.pcpt.sdk.automation.login;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.PageFactory;
import org.pcpt.sdk.It;

public class VerifyLoginPage {
	private LoginPage loginPage;
	
	public VerifyLoginPage(WebDriver driver) {
		loginPage = PageFactory.initElements(driver, LoginPage.class);
	}
	
	public void hasDisplayedUserNameInputBox (WebElement element) {
		It.shouldBeVisible(loginPage.usernameInputBox);
	}
}
