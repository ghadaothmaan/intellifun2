package swe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import swe.service.TeacherService;

@Controller
@RequestMapping("/")
public class TeacherController {
	
	TeacherService teacherService = new TeacherService();
	
	// signup stuff
	
		
}



