package com.ams.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

/*
Entity Definition of COURSE_ENTITY Table
@author: Aishwarya K. 
*/

@Entity
public class CourseEntity {

	@Id
	@GeneratedValue
	private long courseId;

	@NotNull
	@Length( min=2,max = 30, message = "course name should be between 2 and 30 characters")
	private String courseName;

	@NotNull		
	@Length( max = 200, message = "course description should be max 200 characters")
	private String description;


/*
 Setter Getters for the Entity Attributes
*/
	
	public long getCourseId() {
		return courseId;
	}

	public void setCourseId(long courseId) {
		this.courseId = courseId;
	}

	public String getCourseName() {
		return courseName;
	}

	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}


}