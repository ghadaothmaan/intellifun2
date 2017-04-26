package com.SWEProject.teahcer;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.SWEProject.Teacher;

@Controller
@RequestMapping("/")
public class TeacherController {
	
	// signup stuff
	@RequestMapping(value = "teacherForm", method = RequestMethod.GET)
	public String register (Model model) {
		Teacher teacher = new Teacher();
		model.addAttribute("teacher", teacher);
		return "/teacherForm";
	}
		
	@RequestMapping(value = "teacherForm", method = RequestMethod.POST)
	public String showTeacherHome (@ModelAttribute(value = "teacher") Teacher t) {		
		Teacher teacher = new Teacher(t.getName(), t.getUsername(), t.getGender(), t.getEmail(),
							  t.getPassword(), t.getPic(), 0);
			
		TeacherService teacherService = new TeacherService();
		teacherService.addTeacher(teacher); // adding signed up user to our awesome static database
		
		return "/teacherHome";
	}
		
	@RequestMapping(value = "teacherHome/{username}" , method = RequestMethod.GET)
	public String teacherHome (@PathVariable String username, ModelMap modelMap) {
		TeacherService teacherService = new TeacherService();
		Teacher teacher = new Teacher();
		teacher = teacherService.getTeacher(username);
		modelMap.put("teacher", teacher);
		return "/teacherHome";
	}
		
	// login stuff
	@RequestMapping(value = "teacherLogin", method = RequestMethod.GET)
	public String login (Model model) {
		Teacher teacher = new Teacher();
		model.addAttribute("teacher", teacher);
		return "/teacherLogin";
	}
		
	@RequestMapping(value = "teacherLogin", method = RequestMethod.POST)
	public String showTeacherHomee (@ModelAttribute(value = "teacher") Teacher t) {
			
		TeacherService teacherService = new TeacherService();
		Teacher teacher = teacherService.getTeacher(t.getUsername());
			
		if (teacher != null) {
			if (teacher.getPassword().equals(t.getPassword())) {
				return "redirect:/teacherHome/" + teacher.getUsername() + ".html";
			}
		}
		return "/myerror";
	}	
		
}



