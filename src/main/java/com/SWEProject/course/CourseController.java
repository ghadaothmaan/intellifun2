package com.SWEProject.course;

import java.util.ArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.SWEProject.Course;
import com.SWEProject.Game;

@Controller
@RequestMapping("/")
public class CourseController {
	
//	  @Autowired
//    private CourseService courseservice;
//    @Autowired
//    private GameService gameService;
	
	// create course stuff
	@RequestMapping(value = "createCourseForm", method = RequestMethod.GET)
	public String create (Model model) {
		Course course = new Course();
		model.addAttribute("course", course);
		return "/createCourseForm";
	}
		
	@RequestMapping(value = "createCourseForm", method = RequestMethod.POST)
	public String createGame (@ModelAttribute(value = "course") Course c) {		
		CourseService courseService = new CourseService();
		courseService.createCourse(c.getName(), c.getDescription()); 
		return "/courseInfo";
	}
	
	// view courses
	@RequestMapping(value = "viewCourses", method = RequestMethod.GET)
	public String viewCourses (Model model) {
		CourseService courseService = new CourseService();
		ArrayList<Course> courses = courseService.viewCourses();
		model.addAttribute("courses", courses);
		return "/viewCourses";
	}
	
	@RequestMapping(value = "course/{id}")
    public String showCourse(@PathVariable int id, Model model) {
		CourseService courseService = new CourseService();
		Course course = courseService.getCourse(id);
        ArrayList<Game> games = course.getGames();
        model.addAttribute("course", course);
        //model.addAttribute("user", userService.getLoggedin());
        model.addAttribute("games", games);
        return "courseInfo";
    }
	
}







