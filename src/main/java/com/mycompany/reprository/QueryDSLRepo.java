package com.mycompany.reprository;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import org.springframework.stereotype.Repository;
import com.mycompany.entity.Course;
import com.mycompany.entity.QCourse;
import com.querydsl.core.BooleanBuilder;
import com.querydsl.core.types.Predicate;
import com.querydsl.jpa.impl.JPAQuery;

@Repository("queryDSLRepo")
public class QueryDSLRepo {

	private QCourse qCourse = QCourse.course;

	@PersistenceContext
	private EntityManager em;

	public void find() {
		

		JPAQuery<Course> query = new JPAQuery<Course>(em);

		Course course1 = query.select(qCourse).from(qCourse).where(qCourse.id.eq(23)).fetchOne();

		List<Course> courses = query.select(qCourse).from(qCourse).where(qCourse.hours.between(20, 50)).fetch();

		Course course2 = (Course) query.select(qCourse.name, qCourse.description).from(qCourse).where(qCourse.id.eq(23))
				.fetchOne();
	}

	public Course findtwo(boolean exist) {
		
		JPAQuery<Course> query = new JPAQuery<Course>(em);
		
		BooleanBuilder predicateBuilder= new BooleanBuilder(qCourse.description.endsWith("op"));
     
      
      if(exist) {
    	  Predicate predicate2=qCourse.id.eq(23);
    	  predicateBuilder.and(predicate2);
    	
      }else {
    	  Predicate predicate3 =qCourse.description.endsWith("op");
    	  predicateBuilder.or(predicate3);
      }
      return  query.select(qCourse).from(qCourse).where(predicateBuilder).fetchOne();
	}
		
	

}
