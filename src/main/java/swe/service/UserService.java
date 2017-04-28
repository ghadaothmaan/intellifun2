package swe.service;

import swe.model.Student;
import swe.model.Teacher;
import swe.model.User;

public class UserService {
	public TeacherService ts = new TeacherService();
	public StudentService ss = new StudentService();
	
	public int getUserType(User u) {
		int type = 0; // 1 = teacher, 2= student 0 = invalid
		if (ts.getTeacher(u.getUsername()) != null) {
			type = 1;
		}
		else if (ss.getStudent(u.getUsername()) != null) {
			type = 2;
		}
		else type = 0;
		System.out.println(ss.getLoggedin().getUsername() + " uff bgd");
		return type;
	}
	public User getLoggedin() {
		if (ts.getLoggedin() != null) return ts.getLoggedin();
		else return ss.getLoggedin();
	}
	
	public Student getLoggedinStudent() {
		
		System.out.println("hehe " + ss.getLoggedin().getUsername());
		return ss.getLoggedin();
	}
	public Teacher getLoggedinTeacher() {
		return ts.getLoggedin();
	}
	

}
