package com.ams.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToMany;
import javax.persistence.ManyToOne;

@Entity
public class SubjectEntity {
	
	@Id
	@GeneratedValue
	private long subjectId;
	
//	private long courseId;
//
//	private String courseName;

	private String subjectName;

	private String subjectCode;

	private String semester;

	private String description;

	@ManyToMany(mappedBy = "subjectList",cascade=CascadeType.ALL)
	private List<AssignFacultyEntity> assignFacultyList;
	
	@ManyToOne
	@JoinColumn(name="courseId")
	private CourseEntity course;

	public List<AssignFacultyEntity> getAssignFacultyList() {
		return assignFacultyList;
	}

	public void setAssignFacultyList(List<AssignFacultyEntity> assignFacultyList) {
		this.assignFacultyList = assignFacultyList;
	}

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

//	public long getCourseId() {
//		return courseId;
//	}
//
//	public void setCourseId(long courseId) {
//		this.courseId = courseId;
//	}
//
//	public String getCourseName() {
//		return courseName;
//	}
//
//	public void setCourseName(String courseName) {
//		this.courseName = courseName;
//	}

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

}
