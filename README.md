# pcpt-webdriver-tests

WebDriver framework based on page objects. Have support for :

* Allure report
* Log4j
* TestNg
* Ant

## How to setup

Clone this repository using command: 

```git clone https://github.com/priyanshus/pcpt-webdriver-tests.git```

### System requirement

The system should have ant, java and allure cli installed. Allure CLI is required to generate the fancy html report. To install Allure CLI please refer to http://wiki.qatools.ru/display/AL/Allure+Commandline.  
 
## How to run 

You can run the tests either right clicking or using ant command. To run using ant command, you have to issue command `ant run`.

## Project strucuture

```
|-- browser-drivers								   	// Browser drivers according to os
|   |-- linux
|   |   |-- 32bits
|   |   |   `-- chromedriver
|   |   `-- 64bits
|   |       `-- chromedriver
|   |-- mac
|   |   `-- 32bits
|   |       `-- chromedriver
|   `-- windows
|       `-- 32bits
|           |-- chromedriver.exe
|           |-- iedriverdriver.exe
|           `-- iedriver.exe
|-- build.properties								// project perperties
|-- build.xml		
|-- ivy.xml
|-- lib
|-- log4j.properties
|-- sdk
|   `-- org
|       `-- pcpt
|           `-- sdk
|               |-- automation
|               |   `-- login						// Test module package	
|               |       |-- LoginPage.java			// Page class for login
|               |       `-- VerifyLoginPage.java	// Verificatin class for login	
|               |-- BrowserUtils.java				// Browser utils like chromedriver
|				|-- AllureConfiguration.java		// Config for allure report
|               |-- ConfigurationReader.java		// build.properties reader
|               |-- Constants.java					// Project constants	
|               |-- DriverFactory.java				// Responsible to instantiate webdriver
|               |-- It.java							// Global assertions
|               |-- LogReporter.java				// To log the checkpoints
|               |-- PropertiesReader.java			// Properties file reader
|               |-- TestBase.java					// Test Base Class
|               |-- testdata
|               |   |-- QuestionsLoader.java        // Used to read questions.json
|               |   `-- UsersLoader.java			// Used to read users.json
|               |-- TestDataReader.java				// Test Data reader class
|               `-- Wait.java						// Common wait methods	
|-- test-data									 	// test-data files
|   |-- questions.json
|   `-- users.json
|-- testng-xmls								  		// xml suites
|   |-- login.xml
|   `-- singin.xml
`-- tests                                    		// test folder
    `-- org
        `-- pcpt
            `-- test
                `-- mudule
                    `-- login
                        |-- JsonReader.java  		// A sample java class to read json file
                        `-- LoginTest.java   		// A sample test class

```

### How to write new tests

The tests will be running on top of `build.properties`, the build.properties file contains important informations like browser which needs to be launched, test url, time out etc. Please have a look at build.properties to get more details.

Tests are based on page object model and test data will be coming from json file. The json files are kept under `test-data` directory. To read the test data you have to create a loader class corresponding to each json file under `prg.pcpt.sdk.testdata`. Please have look at `UsersLoader.java` to know more about it.

New test classes should go to `tests` folder under `org.pcpt.test.module.<module-name>`. Each test class should extend the `TestBase` in order to fulfill the common life cycle of test. For example:

```
class LoginTest extends TestBase {
	@Test
	public void performLogin() {
		// Do something
	}
}
```

Each view of application should be replicated in page class under sdk folder as `org.pcpt.sdk.automation.<module-name>`. The module package contains two java classes one of them is responsible to provide common methods of page and the other one should have only verification methods.

An example of test:

```
public UsersTest extends TestBase {
	private LoginPage loginPage;
	private HomePage homePage;
	private CreateUser createUserPage;
	private VerifyUserPage verifyUserPage;

	@BeforeTest
	public void instantiateSdk() {
		loginPage = PageFactory.initElements(driver, LoginPage.class);
		homePage = PageFactory.initElements(driver, HomePage.class);
		createUserPage = PageFactory.initElements(driver, CreateUser.class);
		verifyUserPage = new VerifyUserPage(driver);
	}
	
	@Test
	public void createTestUser() {
		homePage = loginPage.login(username,password);
		createUserPage = homePage.openCreateUserPage();
		createUserPage.createNewUser(userdetails);
		
		verifyUserPage.hasUser(userdetails);
	}
}
```

#### Logs

Debug logs can be found in `/log-report/debug-info.log` but make sure the debugger is enabled from build.properties.i.e. `debugging.enabled = true`

#### Reports

Testng factory reporst will be accessible under `/report` directory and the allure reports will get generated under `allure-result` folder which further needs to be converted into html using allure-cli command.


