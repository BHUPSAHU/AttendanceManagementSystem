package com.ams.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;

@Entity
public class CourseEntity {

	@Id
	@GeneratedValue

	@NotNull
	@Size(max = 5, message = "Course id should be atleast 2 characters")
	private long courseId;
	

	@NotNull
	@Pattern(regexp = "[A-Za-z\\s]+", message = "course name is not valid")
	@Length(min = 2, max = 10, message = "course name should be between 2 and 10  characters")
	@Column(name = "Course.Name")
	private String courseName;

	@NotNull
	@Pattern(regexp = "[A-Za-z\\s]+", message = "course description entered is not valid")
	@Length(min = 2, max = 10, message = "course description should be between 2 and 10  characters")
	@Column(name = "Description.Name")
	private String description;

//	  Creating one to many relation with subjects

	//@OneToMany(cascade = CascadeType.ALL)
	//private List<SubjectEntity> ; // Initialization required to avoid NullPointerException

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