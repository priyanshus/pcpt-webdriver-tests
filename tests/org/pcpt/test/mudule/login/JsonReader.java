package org.pcpt.test.mudule.login;

import org.pcpt.sdk.Constants;
import org.pcpt.sdk.TestDataReader;
import org.pcpt.sdk.testdata.QuestionsLoader;
import org.pcpt.sdk.testdata.UsersLoader;

/**
 * Dummy class to test json reader
 */
public class JsonReader {
	public static void main(String[] arg) {
		UsersLoader[] user = TestDataReader.loadJsonFile(UsersLoader[].class, Constants.USERS_TEST_DATA_FILE_PATH);
		System.out.println(user[0].firstname);
		

		QuestionsLoader[] question = TestDataReader.loadJsonFile(QuestionsLoader[].class, Constants.QUESTIONS_TEST_DATA_FILE_PATH);
		System.out.println(question[0].title);
	}
}
