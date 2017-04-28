package swe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
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

}
