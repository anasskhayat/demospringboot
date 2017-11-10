package com.mycompany.converter;

import org.springframework.stereotype.Component;

import com.mycompany.entity.Course;
import com.mycompany.model.CourseModel;

@Component("courseconverter")
public class CourseConverter {

public CourseModel entity2model(Course course) {
	CourseModel coursemodel = new CourseModel();
	coursemodel.setName(course.getName());
	coursemodel.setDescription(course.getDescription());
	coursemodel.setPrice(course.getPrice());
	coursemodel.setHours(course.getHours());
	return coursemodel;
}
	public Course model2enetity(CourseModel coursemodel) {
		
		Course course= new Course();
		course.setName(coursemodel.getName());
		course.setDescription(coursemodel.getDescription());
		course.setPrice(coursemodel.getPrice());
		course.setHours(coursemodel.getHours());
		
		return  course ; 
	
}
}