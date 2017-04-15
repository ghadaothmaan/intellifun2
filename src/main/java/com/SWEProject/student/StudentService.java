package com.SWEProject.student;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import com.SWEProject.Student;

public class StudentService {
	
	private List<Student> students = new ArrayList<>(Arrays.asList (
			 new Student("Hinata Shouyou", "mini-spiderman", "male", "littlegiant@gmail.com", "123", "h.jpeg", 1),
			 new Student("Kageyama Tobio", "king", "male", "illsurpassoikawa@gmail.com", "123", "k.jpg", 2),
			 new Student("Tsukkishima Kei","tsukki", "male", "sarcasticaf@gmail.com", "123", "t.jpg", 3),
			 new Student("Yamaguchi Tadashi", "tadashi", "male", "imnotgoodenough@gmail.com", "123", "y.png", 4)
			));	
		
	public List<Student> getAllStudents() {
		return students; 
	}

	public void addStudent(Student s) {
		students.add(s);
	}	
	
	public Student getStudent(String username) {
		return students.stream().filter(s -> s.getUsername().equals(username)).findFirst().get();
	}
	
	// that's redundant now
	public Student findStudent(String username) {
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getUsername().equals(username)) {
				return students.get(i); 
			}
		}
		return null;
	}
	
}




