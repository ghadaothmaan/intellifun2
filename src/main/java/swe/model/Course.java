package swe.model;

import java.util.ArrayList;

public class Course {
	
	private String name, description;
	private int id;
	private ArrayList<Game> games =  new ArrayList<>();
	
	public Course(int id, String name, String description, ArrayList<Game> games) {
		super();
		this.name = name;
		this.description = description;
		this.id = id;
		this.games = games;
	}
	
	public Course() {
		super();
		this.name = "";
		this.description = "";
		this.id = 0;
		this.games = null;
	}
	
	public Course(int id, String name, String description) {
		super();
		this.name = "";
		this.description = "";
		this.id = 0;
		this.games = null;
	}
	
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getDescription() {
		return description;
	}
	public void setDescription(String description) {
		this.description = description;
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public ArrayList<Game> getGames() {
		return games;
	}
	public void setGames(ArrayList<Game> games) {
		this.games = games;
	}
	
}
