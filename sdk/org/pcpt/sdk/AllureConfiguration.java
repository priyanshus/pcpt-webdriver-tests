package org.pcpt.sdk;

/**
 * Class to configure allure report <br>
 * 
 * <b>Important:</b> Make sure changes in this class match with build.xml
 */
public class AllureConfiguration {

	/**
	 * Constructor
	 * 
	 * @param pathToAllureReport
	 *            Specify the path where allure reports need to be generated
	 */
	public AllureConfiguration(String pathToAllureReport) {
		System.setProperty("allure.results.directory", pathToAllureReport);
	}
}
