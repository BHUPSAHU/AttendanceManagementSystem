package com.ams.entity;

import java.time.LocalDate;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.Email;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

/*
Entity Definition of STUDENT_ENTITY Table
@author: Bhupesh Kumar Sahu 
*/

@Entity
public class StudentEntity {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long studentId;

	@NotNull(message= "Enrollment Number is required")
	@Min(3)
	private long rollNo;

	@NotNull
	@Length(min = 3, max = 30, message = "First name should be between 3 and 30  characters")	
	private String firstName;

	@NotNull
	@Length(min = 1, max = 30, message = "Last name should be between 1 and 30  characters")
	private String lastName;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message="date of birth is required")
	@Past(message ="Date should be past dates" )
	private LocalDate dob;

	@NotNull
	@Length(min = 4, max = 10, message = "Gender should be between 1 and 10  characters")
	private String gender;

	@NotNull(message= "Student Mobile Number is required")
	@Length(min = 10, max = 10, message = "Mobile number should be only 10 digits")
	@Pattern(regexp="(^$|[0-9]{10})", message = "Mobile number should be only Numbers")
	private String mobileNo;

	@NotNull(message= "Course Id is required")
	@Min(3)
	private long courseId;

	@NotNull(message= "Course Name is required")
	@Length( min=2,max = 30, message = "course name should be between 2 and 30 characters")
	private String courseName;

	@NotNull(message= "Student Email is required")
	@Email(message = "Email should be valid")
	private String emailId;

	@NotNull(message= "Father's Email is required")
	@Email(message = "Email should be valid")
	private String fatherEmailId;

	
	@NotNull(message= "Fathers Mobile Number is required")
	@Length(min = 10, max = 10, message = "Mobile number should be only 10 digits")
	@Pattern(regexp="(^$|[0-9]{10})", message = "Mobile number should be only Numbers")
	private String fatherMobileNo;

	@Length(min = 10, message = "Profile Picture URL should be minimum 10 characters ")
	private String profilePic;

/*
 Merging First name and Last name to result full name 
*/	
	
	private String name;

/*
 Setter Getters for the Entity Attributes
*/
	public long getStudentId() {
		return studentId;
	}

	public void setStudentId(long studentId) {
		this.studentId = studentId;
	}

	public long getRollNo() {
		return rollNo;
	}

	public void setRollNo(long rollNo) {
		this.rollNo = rollNo;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getGender() {
		return gender;
	}

	public void setGender(String gender) {
		this.gender = gender;
	}

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

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

	public String getEmailId() {
		return emailId;
	}

	public void setEmailId(String emailId) {
		this.emailId = emailId;
	}

	public String getFatherEmailId() {
		return fatherEmailId;
	}

	public void setFatherEmailId(String fatherEmailId) {
		this.fatherEmailId = fatherEmailId;
	}

	public String getFatherMobileNo() {
		return fatherMobileNo;
	}

	public void setFatherMobileNo(String fatherMobileNo) {
		this.fatherMobileNo = fatherMobileNo;
	}

	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	public String getName() {
		return name;
	}

	public void setName(String firstName,String lastName) {
		this.name = firstName+ " "+ lastName;
	}

}
