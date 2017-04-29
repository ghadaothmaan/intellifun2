package swe.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import swe.model.Teacher;
import swe.service.TeacherService;

@Controller
@RequestMapping("/")
public class TeacherController {
	
	TeacherService teacherService = new TeacherService();
	
	// signup stuff
	
		
}



