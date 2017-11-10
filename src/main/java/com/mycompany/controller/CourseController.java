package com.mycompany.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;
import com.mycompany.model.CourseModel;
import com.mycompany.service.ServiceCourse;

@Controller
@RequestMapping("/course")
public class CourseController {

	public static final String course_view = "courses";

	public static final Log LOG = LogFactory.getLog(CourseController.class);

	@Autowired
	@Qualifier("serviceCourseImpl")
	private ServiceCourse serviceCourse;

	@GetMapping("/listcourse")

	public ModelAndView listallcourse() {

		LOG.info("call :" + "listallcourse()");
		ModelAndView mav = new ModelAndView(course_view);
		mav.addObject("course", new CourseModel());
		mav.addObject("courses", serviceCourse.listallcourse());
		return mav;
	}

	@PostMapping("/addcours")
	public String addcours(@ModelAttribute("courses") CourseModel Course) {

		LOG.info("call :" + "addcours()" + "--pram" + Course.toString());
		serviceCourse.addCourse(Course);
		return "redirect:/course/listcourse";

	}
	@PostMapping("/removeCourse")
	
	public String removeCourse(@ModelAttribute("courses") CourseModel remove) {
		
		LOG.info("call :" + "removecours()" + "--pram" + remove.toString());
		
		serviceCourse.removeCourse(remove);
	
		return "redirect:/course/listcourse";
		
	}
   @PostMapping("/updatecourse")
   public String updatecourse(@ModelAttribute("courses") CourseModel update) {
	   
	   LOG.info("call :" + "updatecourse()" + "--pram" + update.toString());
	   
	   serviceCourse.updatecourse(update);
		return "redirect:/course/listcourse";
   }
   
}
