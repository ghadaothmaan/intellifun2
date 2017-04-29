package swe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import swe.service.StudentService;

@Controller
@RequestMapping("/")
public class StudentController {
	
	//@Autowired
	StudentService studentService = new StudentService();
	
	// signup stuff
	
	
}






