package swe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import swe.model.Student;
import swe.model.Teacher;
import swe.model.User;
import swe.service.UserService;

@Controller
@RequestMapping("/")
public class UserController {
	
	UserService us = new UserService();
	
	@RequestMapping(value = "login", method = RequestMethod.GET)
	public String yallalogin (Model model) {
		System.out.println("hello");
		User user = new User();
		model.addAttribute("user", user);
		return "/login";
	}
		
	@RequestMapping(value = "login", method = RequestMethod.POST)
	public String showHome (@ModelAttribute(value = "user") User t) {
		
		int usertype = us.getUserType(t);
		User u = us.getLoggedin();
		
		System.out.println("da el logged in: " + u.getUsername());
		
		if (usertype == 0) return "/myerror";
		else if (usertype == 1) {
			if (t.getPassword().equals(u.getPassword()))
				return "redirect:/teacherHome";		
		}
		else if (usertype == 2) {
			if (t.getPassword().equals(u.getPassword())) {
				System.out.println("wda el pw bta3o: " + t.getPassword());
				return "redirect:/studentHome";
			}
		}
		return "/myerror";
	}
	
	@RequestMapping(value = "studentHome", method = RequestMethod.GET)
	public String showStudentHome (Model model) {		
		// logged in user
		Student student = us.getLoggedinStudent();
		System.out.println("hi " + student.getUsername());
		model.addAttribute("student", student);
		
		return "/studentHome";
	}
	
	@RequestMapping(value = "teacherHome", method = RequestMethod.GET)
	public String showTeacherHome (Model model) {		
		// logged in user
		Teacher teacher = us.getLoggedinTeacher();
		System.out.println("hi " + teacher.getUsername());
		model.addAttribute("teacher", teacher);
		
		return "/teacherHome";
	}
	
	// student signup
	@RequestMapping(value = "studentForm", method = RequestMethod.GET)
	public String registerStudent (Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "/studentForm";
	}
	
	@RequestMapping(value = "studentForm", method = RequestMethod.POST)
	public String showStudentHome (@ModelAttribute(value = "student") Student s) {		
		Student student = new Student(s.getName(), s.getUsername(), s.getGender(),
									s.getEmail(), s.getPassword(), s.getPic(), 0);
		
		us.ss.addStudent(student); // adding signed up user to our awesome static database
		
		return "/studentProfileSignup";
	}

	@RequestMapping(value = "studentProfile/{username}" , method = RequestMethod.GET)
	public String studentProfilee (@PathVariable String username, ModelMap modelMap ) {		
		Student student = us.ss.getStudent(username);
		modelMap.put("student", student);
		
		return "/studentProfile";
	}
	
	// teacher signup
	@RequestMapping(value = "teacherForm", method = RequestMethod.GET)
	public String registerTeacher (Model model) {
		Teacher teacher = new Teacher();
		model.addAttribute("teacher", teacher);
		return "/teacherForm";
	}
		
	@RequestMapping(value = "teacherForm", method = RequestMethod.POST)
	public String showTeacherHome (@ModelAttribute(value = "student") Teacher s) {		
		Teacher teacher = new Teacher(s.getName(), s.getUsername(), s.getGender(),
									s.getEmail(), s.getPassword(), s.getPic());
		
		us.ts.addTeacher(teacher); // adding signed up user to our awesome static database
		
		return "/teacherProfileSignup";
	}
	
	@RequestMapping(value = "teacherProfile/{username}" , method = RequestMethod.GET)
	public String teacherProfile (@PathVariable String username, ModelMap modelMap ) {		
		Teacher teacher = us.ts.getTeacher(username);
		modelMap.put("teacher", teacher);
		
		return "/teacherProfile";
	}
	
	

}
