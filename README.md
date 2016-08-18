# pcpt-webdriver-tests

WebDriver framework based on page objects. Have support for :

* Allure report
* Log4j
* TestNg
* Ant

## How to setup

Clone this repository using command: `git clone`

### System requirement

The system should have ant, java and allure cli installed. Allure CLI is required to generate the fancy html report. To install Allure CLI please refer to http://wiki.qatools.ru/display/AL/Allure+Commandline.  
 
## How to run 

You can run the tests either right clicking or using ant command. To run using ant command, you have to issue command `ant run`.

## Project strucuture

```
|-- browser-drivers
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
|-- build.properties									// project perperties
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
|               |-- ConfigurationReader.java		// build.properties reader
|               |-- Constants.java					// Project constants	
|               |-- DriverFactory.java				// Responsible to instantiate webdriver
|               |-- It.java							// Global assertions
|               |-- LogReporter.java				// To log the checkpoints
|               |-- PropertiesReader.java			// Properties file reader
|               |-- TestBase.java					// Test Base Class
|               |-- testdata
|               |   |-- QuestionsLoader.java      // Used to read questions.json
|               |   `-- UsersLoader.java			// Used to read users.json
|               |-- TestDataReader.java				// Test Data reader class
|               `-- Wait.java						// Common wait methods	
|-- test-data											// test-data files
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

New test classes should go to `tests` folder under `org.pcpt.test.module.<module-name>`. Each test class should extend the `TestBase` in order to fulfill the common life cycle of test. For example

```
class LoginTest extends TestBase {
	@Test
	public void performLogin() {
		// Do something
	}
}
```