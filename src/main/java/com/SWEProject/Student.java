package com.SWEProject;

public class Student {
	private String name, username, gender, email, password, pic;
	private int score;

	public Student(String name, String username, String gender, String email, String password, String pic, int score) {
		super();
		this.name = name;
		this.username = username;
		this.gender = gender;
		this.email = email;
		this.password = password;
		this.pic = pic;
		this.score = score;
	}
	
	public Student() {
		this.name = "";
		this.username = "";
		this.gender = "";
		this.email = "";
		this.password = "";
		this.pic = "default-user.png"; // msln?
		this.score = 0;
	}
	
	public String getPic() {
		return pic;
	}
	public void setPic(String pic) {
		this.pic = pic;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getUsername() {
		return username;
	}
	public void setUsername(String username) {
		this.username = username;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public int getScore() {
		return score;
	}
	public void setScore(int score) {
		this.score = score;
	}
	
	
}
