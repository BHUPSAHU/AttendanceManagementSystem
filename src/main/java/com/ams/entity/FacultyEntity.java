package com.ams.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;


@Entity
public class FacultyEntity {
	@Id
	@GeneratedValue
	private long facultyid;

	@NotNull
	@Pattern(regexp = "[A-Za-z\\s]+", message = "User name is not valid")
	@Length(min = 2, max = 10, message = "User name should be between 2 and 10  characters")
	private String userName;

	@NotNull
	@Pattern(regexp = "[A-Za-z\\s]+", message = "totalclass is not valid")
	@Length(min = 2, max = 10, message = "totalclass should be between 2 and 10  characters")
	private String totalClass;
	
	@OneToOne(mappedBy = "assignFaculty")
	private UserEntity user;

	@OneToMany
	private List<SubjectEntity> subjectList;
	

	public UserEntity getUser() {
		return user;
	}

	public void setUser(UserEntity user) {
		this.user = user;
	}

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

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getTotalClass() {
		return totalClass;
	}

	public void setTotalClass(String totalClass) {
		this.totalClass = totalClass;
	}

	@Override
	public String toString() {
		return "FacultyEntity [facultyid=" + facultyid + ", userName=" + userName + ", totalClass=" + totalClass
				+ ", user=" + user + ", subjectList=" + subjectList + "]";
	}

	
}
