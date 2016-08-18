package org.pcpt.sdk;

import org.apache.log4j.Logger;
import org.apache.log4j.PropertyConfigurator;

/**
 * Class to log the messages <br>
 * Log messages can be checked here: /log-report/debug-info.log
 */
public class LogReporter {
	private static LogReporter instance = null;
	private static boolean isDebugginEnabled = false;
	private static Logger log = null;
	private static String LOG__PROPERTIES = "log4j.properties";

	private LogReporter() {
	}

	public static LogReporter getInstance() {
		if (instance == null) {

			instance = new LogReporter();
			isDubuggingEnabled();
		}

		return instance;
	}

	/**
	 * Looks for flag present in build.properties and will enabled the log only
	 * if flag is on
	 */
	private static void isDubuggingEnabled() {
		String flag = ConfigurationReader.getInstance().getPropertyValue("debugging.enabled");
		if (flag.equals("true")) {
			isDebugginEnabled = true;
		}
	}

	/**
	 * Logs the message into the log file <br>
	 * Here the logging point specifies what kind of message it is. Ideally it
	 * should be the name of class for which logging is done.
	 * 
	 * @param loggingPoint
	 *            Logging point
	 * @param message
	 *            Message
	 */
	public void logInfo(String loggingPoint, String message) {
		if (isDebugginEnabled) {
			log = Logger.getLogger(loggingPoint);
			PropertyConfigurator.configure(LOG__PROPERTIES);
			log.info(message);
		}
	}

	/**
	 * Logs the error message into the log file <br>
	 * Here the logging point specifies what kind of message it is. Ideally it
	 * should be the name of class for which logging is done.
	 * 
	 * @param loggingPoint
	 *            Logging point
	 * @param message
	 *            Message
	 */
	public void logError(String loggingPoint, String errorMessage) {
		if (isDebugginEnabled) {
			log = Logger.getLogger(loggingPoint);
			PropertyConfigurator.configure(LOG__PROPERTIES);
			log.error(errorMessage);
		}
	}
}
