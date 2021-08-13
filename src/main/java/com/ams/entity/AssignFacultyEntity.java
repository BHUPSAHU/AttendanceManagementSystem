package com.ams.entity;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.OneToOne;

import org.springframework.beans.factory.annotation.Autowired;



@Entity
public class AssignFacultyEntity {
	@Id
	@GeneratedValue
	private long facultyid;

//	private long userId;

	private String userName;

//	private long courseId;
//
//	private String courseName;
//
//	private long subjectId;
//
//	private String subjectName;
//
//	private String semester;

	private String totalClass;
	@Autowired
	@OneToOne(targetEntity=UserEntity.class,cascade=CascadeType.ALL)
	private UserEntity user;
	
	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

	@ManyToMany(targetEntity=SubjectEntity.class,cascade=CascadeType.ALL)
	private List<SubjectEntity> subjectList;
	

	

	public List<SubjectEntity> getSubjectList() {
		return subjectList;
	}

	public void setSubjectList(List<SubjectEntity> subjectList) {
		this.subjectList = subjectList;
	}

	public long getFacultyid() {
		return facultyid;
	}

	public void setFacultyid(long facultyid) {
		this.facultyid = facultyid;
	}

//	public long getUserId() {
//		return userId;
//	}
//
//	public void setUserId(long userId) {
//		this.userId = userId;
//	}
//
	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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
//
//	public long getSubjectId() {
//		return subjectId;
//	}
//
//	public void setSubjectId(long subjectId) {
//		this.subjectId = subjectId;
//	}
//
//	public String getSubjectName() {
//		return subjectName;
//	}
//
//	public void setSubjectName(String subjectName) {
//		this.subjectName = subjectName;
//	}
//
//	public String getSemester() {
//		return semester;
//	}
//
//	public void setSemester(String semester) {
//		this.semester = semester;
//	}

	public String getTotalClass() {
		return totalClass;
	}

	public void setTotalClass(String totalClass) {
		this.totalClass = totalClass;
	}

}
