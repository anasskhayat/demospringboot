package com.mycompany.service;

import java.util.List;

import com.mycompany.entity.Course;
import com.mycompany.model.CourseModel;


public interface ServiceCourse {
	
	public abstract List<CourseModel> listallcourse();
	public abstract Course addCourse(CourseModel CourseModel);
	public abstract int removeCourse(CourseModel CourseModel);
	public abstract Course updatecourse(CourseModel CourseModel);

}
