package swe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import swe.model.Student;
import swe.service.StudentService;

@Controller
@RequestMapping("/")
public class StudentController {
	
	//@Autowired
	StudentService studentService = new StudentService();
	
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
		
		studentService.addStudent(student); // adding signed up user to our awesome static database

		return "/studentProfileSignup";
	}
	
	@RequestMapping(value = "studentProfile/{username}" , method = RequestMethod.GET)
	public String studentProfilee (@PathVariable String username, ModelMap modelMap ) {		
		Student student = studentService.getStudent(username);
		modelMap.put("student", student);
		
		return "/studentProfile";
	}
	
	
	
}






