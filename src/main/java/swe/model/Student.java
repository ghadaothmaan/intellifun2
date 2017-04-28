package swe.model;

public class Student extends User {
	
	private int score = 0;

	public Student() {
		super();
		this.score = 0;
	}
	
	public Student(String name, String username, String gender, String email, String password, String pic,int score) {
		super(name, username, gender, email, password, pic);
		this.score = score;
	}
	
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	
}
