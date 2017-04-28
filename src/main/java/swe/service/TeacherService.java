package swe.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import swe.model.Teacher;

public class TeacherService {
	
	private Teacher loggedin;
	
	private List<Teacher> teachers = new ArrayList<>(Arrays.asList (
			 new Teacher("Takeda Sensei", "sensei", "male", "sensei@gmail.com", "123", "s.jpeg"),
			 new Teacher("Ukai Coach", "coach", "male", "coach@gmail.com", "123", "c.jpg"),
			 new Teacher("Teacher3","teach3", "male", "teach3@gmail.com", "123", "default-user.png"),
			 new Teacher("Teacher4", "teach4", "male", "teach4@gmail.com", "123", "default-user.png")
			));	
		
	public List<Teacher> getAllTeachers() {
		return teachers; 
	}
	
	public void addTeacher(Teacher t) {
		teachers.add(t);
		loggedin = t;
	}
	
	// thats redundant now
	public Teacher findTeacher(String username) {
		return teachers.stream().filter(t -> t.getUsername().equals(username)).findFirst().get();
	}
	
	public Teacher getTeacher(String username) {
		for (int i = 0; i < teachers.size(); i++) {
			if (teachers.get(i).getUsername().equals(username)) {
				loggedin = teachers.get(i);
				return teachers.get(i); 
			}
		}
		return null;
	}
	
	public Teacher getLoggedin() {
		return loggedin;
	}
	
}
