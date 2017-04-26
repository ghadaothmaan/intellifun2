package com.SWEProject.course;

import java.util.ArrayList;
import java.util.Arrays;

import com.SWEProject.Course;
import com.SWEProject.Game;
import com.SWEProject.Question;

public class CourseService {

	private ArrayList<String> as = new ArrayList<>(Arrays.asList("a1", "a2", "a3"));

	private ArrayList<Question> qs = new ArrayList<>(Arrays.asList(
			new Question("question1", 1, as),
			new Question("question2", 2, as),
			new Question("question3", 3, as)
			));
	
	private ArrayList<Game> games = new ArrayList<>(Arrays.asList (
			new Game(1, "TF", "game1", qs),
			new Game(2, "MCQ", "game2", qs),
			new Game(3, "TF", "game3", qs)
			));
	
	private ArrayList<Course> courses = new ArrayList<>(Arrays.asList (
			 new Course(1, "Math 101", "Math 101 desription", games),
			 new Course(2, "Math 102", "Math 102 description", games)
			 ));
	
	
	public void addCourse(Course c) {
		courses.add(c); // add game to database 
	}
	
	public Course getCourse (int id) {
		for (int i = 0; i < courses.size(); i++) {
			if (courses.get(i).getId() == id) {
				return courses.get(i); 
			}
		}
		return null;
	}
	
	public void createCourse (String name, String description) {
		Course newCourse = new Course(courses.size() + 1, name, description);
		addCourse(newCourse);
	}
	
	
	public ArrayList<Course> viewCourses() {
		return courses;
	}
	
}
