package swe.model;

import java.util.ArrayList;

public class Game {
	
	private int id;
	private String name, type;
	private ArrayList<QuestionMCQ> questions = new ArrayList<QuestionMCQ>(3);
	
	public Game(int id, String type, String name) {
		super();
		this.id = id;
		this.type = type;
		this.name = name;
		this.questions = new ArrayList<QuestionMCQ>(3);
	}
	
	public Game(int id, String type, String name, ArrayList<QuestionMCQ> questions) {
		super();
		this.id = id;
		this.type = type;
		this.name = name;
		this.questions = new ArrayList<QuestionMCQ>(3);
	}
	
	public Game() {
		this.name = "";
		this.type = "";
		this.questions = new ArrayList<QuestionMCQ>(3);
		for (int i = 0; i < 3; i++) {
			questions.add(null);
		}
	}
	
	public int getId() {
		return id;
	}
	public ArrayList<QuestionMCQ> getQuestions() {
		return questions;
	}

	public void setQuestions(ArrayList<QuestionMCQ> questions) {
		this.questions = questions;
	}
	
	public void addQuestion(QuestionMCQ q) {
		questions.add(q); // add q to database 
	}
	

	public void setId(int id) {
		this.id = id;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	
	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}
	
	
	
}
