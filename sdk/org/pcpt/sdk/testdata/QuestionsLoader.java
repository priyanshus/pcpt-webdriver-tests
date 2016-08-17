package org.pcpt.sdk.testdata;

public class QuestionsLoader {
	public String title;
	public String[] options;
	public String correctAnswer;
	public String type;

	public QuestionsLoader(String title, String[] options, String correctAnswer, String type) {
		this.title = title;
		this.options = options;
		this.correctAnswer = correctAnswer;
		this.type = type;
	}

	public QuestionsLoader() {
	}
}
