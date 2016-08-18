package org.pcpt.sdk.automation.login;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;

/**
 * Page class which replicates the view of login page
 */
public class LoginPage {

	@FindBy(id = "username")
	protected WebElement usernameInputBox;

	@FindBy(id = "password")
	protected WebElement passwordInputBox;

	@FindBy(id = "loginbutton")
	protected WebElement loginButton;

	/**
	 * Login
	 * 
	 * @param username
	 *            username
	 * @param password
	 *            password
	 */
	public void login(String username, String password) {
		usernameInputBox.sendKeys(username);
		passwordInputBox.sendKeys(password);
		loginButton.clear();
	}
}
