package swe.service;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import swe.model.Student;

public class StudentService {
	
	private Student loggedin;
	
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
		System.out.println("new student: " + students.get(students.size() - 1).getUsername());
		loggedin = s;
	}	
	
	public Student getStudent(String username) {
		for (int i = 0; i < students.size(); i++) {
			if (students.get(i).getUsername().equals(username)) {
				loggedin = students.get(i);
				System.out.println(" student: " + students.get(students.size() - 1).getUsername());

				return students.get(i); 
			}
		}
		return null;
	}
	
	// that's redundant now
	public Student findStudent(String username) {
		return students.stream().filter(s -> s.getUsername().equals(username)).findFirst().get();
	}
	
	public Student getLoggedin() {
		return loggedin;
	}
		
		
}
