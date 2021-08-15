package com.ams.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.NotNull;
import org.hibernate.validator.constraints.Length;

@Entity
public class SubjectEntity {
	
	@Id
	@GeneratedValue
		
	private long subjectId;

	@NotNull
	@Length(min = 2, max = 30, message = "Subject name should be between 2 and 30  characters")
	private String subjectName;

	@NotNull
	@Length(min = 2, max = 30, message = "Subject Code should be between 2 and 30  characters")
	private String subjectCode;

	@NotNull
	@Length(min = 2, max = 30, message = "Semester should be between 2 and 30  characters")
	private String semester;

	@NotNull
	@Length(min = 2, max = 200, message = "Description should be between 2 and 200  characters")
	private String description;

	@ManyToOne
	public CourseEntity course;


	public CourseEntity getCourse() {
		return course;
	}

	public void setCourse(CourseEntity course) {
		this.course = course;
	}

	public long getSubjectId() {
		return subjectId;
	}

	public void setSubjectId(long subjectId) {
		this.subjectId = subjectId;
	}


	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	@Override
	public String toString() {
		return "SubjectEntity [subjectId=" + subjectId + ", subjectName=" + subjectName + ", subjectCode=" + subjectCode
				+ ", semester=" + semester + ", description=" + description + ", course=" + course
				+  "]";
	}

}
