package com.mycompany.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mycompany.converter.CourseConverter;
import com.mycompany.entity.Course;
import com.mycompany.model.CourseModel;
import com.mycompany.reprository.CourseJpaRepository;


@Service("serviceCourseImpl")
public class ServiceCourseImpl implements  ServiceCourse {
	
	public static final Log LOG=LogFactory.getLog(ServiceCourseImpl.class);
	@Autowired
	@Qualifier("courseJpaRepository")
	private CourseJpaRepository courseJpaRepository;
	
   @Autowired
   @Qualifier("courseconverter")
   private CourseConverter courseconverter;


	@Override
	public List<CourseModel> listallcourse(){
		LOG.info("Call: " + "listAllCourses()");
		
		//List para devolver el conjunto de modelos
		List<CourseModel> CourseModel= new ArrayList<CourseModel>();
		
		//Asigno un iterador para recorrer el listado de entities
		Iterator<Course> iterator=courseJpaRepository.findAll().iterator();
		
		while(iterator.hasNext()) {
			
			CourseModel.add(courseconverter.entity2model(iterator.next()));
		}
	    return CourseModel;
		
	}

	@Override
	public Course addCourse(CourseModel CourseModel) {
		
		LOG.info("call : "+ "addCourse() ");
		
		Course course=new Course();
		course=(courseconverter.model2enetity(CourseModel));
		// TODO Auto-generated method stub
		return courseJpaRepository.save(course);
		
	}

		

	@Override
	public int removeCourse(CourseModel CourseModel) {
		
		LOG.info("call : "+ "delete() ");
		// TODO Auto-generated method stub
		Course course=new Course();
		course=(courseconverter.model2enetity(CourseModel));
		courseJpaRepository.delete(course.getId());
		return 0;
	}


	@Override
	public Course updatecourse(CourseModel CourseModel) {
		
		LOG.info("call : "+ "updatecourse() ");
		
		Course course=new Course();
		course=(courseconverter.model2enetity(CourseModel));
		return courseJpaRepository.save(course);
	}


}
