package com.SWEProject.student;

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
	
	// make autowired freakig work
	
	// signup stuff
	@RequestMapping(value = "studentForm", method = RequestMethod.GET)
	public String register (Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "/studentForm";
	}
	
	@RequestMapping(value = "studentForm", method = RequestMethod.POST)
	public String showStudentHome (@ModelAttribute(value = "student") Student s) {		
		Student student = new Student(s.getName(), s.getUsername(), s.getGender(),
									s.getEmail(), s.getPassword(), s.getPic(), 0);
		
		StudentService studentService = new StudentService();
		studentService.addStudent(student); // adding signed up user to our awesome static database
		
		return "/studentProfileSignup";
	}
	
	@RequestMapping(value = "studentHome", method = RequestMethod.GET)
	public String showStudentHomeee (@ModelAttribute(value = "student") Student s, Model model) {		
		// logged in user
		StudentService studentService = new StudentService();
		//Student student = new Student();
		s = studentService.getLoggedin();
		model.addAttribute("student", s);
		System.out.println(s.getUsername());
		
		return "/studentHome";
	}
	
	// login stuff
	@RequestMapping(value = "studentLogin", method = RequestMethod.GET)
	public String login (Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		
		return "/studentLogin";
	}
	
	@RequestMapping(value = "studentLogin", method = RequestMethod.POST)
	public String showStudentHomee (@ModelAttribute(value = "student") Student s) {
		StudentService studentService = new StudentService();
		Student student = studentService.getStudent(s.getUsername());
		
		if (student != null) {
			if (student.getPassword().equals(s.getPassword())) {
				//return "redirect:/studentHome/" + student.getUsername();
				return "/studentHome";
			}
		}
		return "/myerror";
	}
	
//	@RequestMapping(value = "studentHome/{username}" , method = RequestMethod.GET)
//	public String studentHome (@PathVariable String username, ModelMap modelMap ) {		
//		StudentService studentService = new StudentService();
//		Student student = studentService.getStudent(username);
//		//student = studentService.getLoggedin();
//		modelMap.put("student", student);
//		
//		return "/studentHome";
//	}

	
	@RequestMapping(value = "studentProfile/{username}" , method = RequestMethod.GET)
	public String studentProfilee (@PathVariable String username, ModelMap modelMap ) {		
		StudentService studentService = new StudentService();
		Student student = studentService.getStudent(username);
		modelMap.put("student", student);
		
		return "/studentProfile";
	}
	
	
	
}






