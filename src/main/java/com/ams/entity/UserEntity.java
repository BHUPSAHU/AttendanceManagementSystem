package com.ams.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
//import javax.validation.constraints.Min;

import org.springframework.beans.factory.annotation.Autowired;

@Entity
public class UserEntity {
	
	@Id
	@GeneratedValue
	private long userId;

	private String firstName;

	private String lastName;

	private String mobileNo;

	private String profilePic;

	private LocalDate dob;

	private String password;

	private long roleType;
	
//	@Autowired
	@OneToOne(cascade=CascadeType.ALL)
	private AssignFacultyEntity assignFaculty;

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
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

	public String getMobileNo() {
		return mobileNo;
	}

	public void setMobileNo(String mobileNo) {
		this.mobileNo = mobileNo;
	}

	public String getProfilePic() {
		return profilePic;
	}

	public void setProfilePic(String profilePic) {
		this.profilePic = profilePic;
	}

	public LocalDate getDob() {
		return dob;
	}

	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public long getRoleType() {
		return roleType;
	}

	public void setRoleType(long roleType) {
		this.roleType = roleType;
	}

	public AssignFacultyEntity getAssignFaculty() {
		return assignFaculty;
	}

	public void setAssignFaculty(AssignFacultyEntity assignFaculty) {
		this.assignFaculty = assignFaculty;
	}

	
}
