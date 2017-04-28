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
	@RequestMapping(value = "teacherForm", method = RequestMethod.GET)
	public String register (Model model) {
		Teacher teacher = new Teacher();
		model.addAttribute("teacher", teacher);
		return "/teacherForm";
	}
		
	@RequestMapping(value = "teacherForm", method = RequestMethod.POST)
	public String showTeacherHome (@ModelAttribute(value = "student") Teacher s) {		
		Teacher teacher = new Teacher(s.getName(), s.getUsername(), s.getGender(),
									s.getEmail(), s.getPassword(), s.getPic());
		
		teacherService.addTeacher(teacher); // adding signed up user to our awesome static database
		
		return "/teacherProfileSignup";
	}
	
	@RequestMapping(value = "teacherProfile/{username}" , method = RequestMethod.GET)
	public String teacherProfile (@PathVariable String username, ModelMap modelMap ) {		
		Teacher teacher = teacherService.getTeacher(username);
		modelMap.put("teacher", teacher);
		
		return "/teacherProfile";
	}
		
}



