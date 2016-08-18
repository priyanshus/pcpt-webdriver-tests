package org.pcpt.sdk.automation.login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

public class LoginPage {

	@FindBy(id = "username")
	protected WebElement usernameInputBox;
	
	@FindBy(id = "password")
	protected WebElement passwordInputBox;
	
	@FindBy(id = "loginbutton")
	protected WebElement loginButton;
	
	public void login(String username, String password) {
		usernameInputBox.sendKeys(username);
		passwordInputBox.sendKeys(password);
		loginButton.clear();
	}
}
