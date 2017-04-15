package com.SWEProject.student;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.SWEProject.Student;

@Controller
@RequestMapping("/")
public class StudentController {
	
	//@Autowired
	Student student = new Student();
	
	// signup stuff
	@RequestMapping(value = "studentForm", method = RequestMethod.GET)
	public String register (Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "/studentForm";
	}
	
	@RequestMapping(value = "studentForm", method = RequestMethod.POST)
	public String showStudentHome (@ModelAttribute(value = "student") Student s) {		
		student = new Student(s.getName(), s.getUsername(), s.getGender(), s.getEmail(),
							  s.getPassword(), s.getPic(), 0);
		
		StudentService studentService = new StudentService();
		studentService.addStudent(student); // adding signed up user to our awesome static database
		
		return "/studentHome";
	}
	
	@RequestMapping( value = "studentHome/{username}" , method = RequestMethod.GET)
	public String studentHome (@PathVariable String username, ModelMap modelMap ) {		
		StudentService studentService = new StudentService();
		student = studentService.getStudent(username);
		modelMap.put("student", student);
		return "/studentHome";
	}
	
	// login stuff
	@RequestMapping(value = "studentLogin", method = RequestMethod.GET)
	public String login (Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "/studentLogin";
	}
	
	// redirect html page
	// redirect:/url/{username} model.put 
	
	@RequestMapping(value = "studentLogin", method = RequestMethod.POST)
	public String showStudentHomee (@ModelAttribute(value = "student") Student s) {
		
		StudentService studentService = new StudentService();
		student = studentService.getStudent(s.getUsername());
		
		if (student != null) {
			if (student.getPassword().equals(student.getPassword())) {
				return "redirect:/studentHome/" + student.getUsername() + ".html";
			}
		}
		return "/error";
	}
	
}






