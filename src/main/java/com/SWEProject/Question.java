package com.SWEProject;

import java.util.ArrayList;

public class Question {

	String question;
	int correctIndex;
	ArrayList<String> answers = new ArrayList<String>(3);
	
	public Question() {
		this.question = "";
		this.correctIndex = 0;
		this.answers = null;
	}

	public Question(String question, int correctIndex, ArrayList<String> answers) {
		super();
		this.question = question;
		this.correctIndex = correctIndex;
		this.answers = answers;
	}

	public String getQuestion() {
		return question;
	}

	public void setQuestion(String question) {
		this.question = question;
	}

	public int getCorrectIndex() {
		return correctIndex;
	}

	public void setCorrectIndex(int correctIndex) {
		this.correctIndex = correctIndex;
	}

	public ArrayList<String> getAnswers() {
		return answers;
	}

	public void setAnswers(ArrayList<String> answers) {
		this.answers = answers;
	}
	
	
	
}
