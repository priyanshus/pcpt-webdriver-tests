package org.pcpt.test.mudule.login;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;
import org.apache.log4j.pattern.PropertiesPatternConverter;
import org.pcpt.sdk.LogReporter;
import org.pcpt.sdk.TestBase;
import org.testng.annotations.Test;

public class LoginTest extends TestBase {
	
	
	
	
	@Test
	public void loginTest1() {
		LogReporter.getInstance().logInfo("TestClass1", "LoggedByCode");
		System.out.println("Testing");
	}
	
	@Test
	public void loginTest2() {
		LogReporter.getInstance().logInfo("TestClass2", "LoggedByCode");
		System.out.println("Testing");
	}
	
	@Test
	public void loginTest3() {
		System.out.println("Testing");
	}
}
