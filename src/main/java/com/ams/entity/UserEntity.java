package com.ams.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;
import javax.validation.constraints.Size;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class UserEntity {
	
	@Id
	@GeneratedValue
	private long userId;

	@Length(min = 3, max = 15)
	@NotNull(message = "userName is required")
	private String userName;

	@Length(min = 3, max = 15)
	@NotNull(message = "firstName is required")
	private String firstName;

	@Length(min = 3, max = 15)
	@NotNull(message = "lastName is required")
	private String lastName;

	@Size(min = 10, max = 10)
	@Pattern(regexp = "(^$|[0-9]{10})")
	private String mobileNo;

	@NotNull(message = "profilepic is required")
	@Min(4)
	private String profilePic;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
	@NotNull(message = "date of birth is required")
	@Past
	private LocalDate dob;

	@Length(min = 6, max = 15)
	@NotNull(message = "password is required")
	private String password;

	@Length(min = 1, max = 1)
	@NotNull(message = "roleType is required")
	private String roleType;

//	@OneToOne(fetch = FetchType.LAZY,cascade= CascadeType.ALL)
//	@JoinColumn(name = "facultyid")
//	private AssignFacultyEntity assignFaculty;
//	
//	
//	
//	
//
//	public AssignFacultyEntity getAssignFaculty() {
//		return assignFaculty;
//	}
//
//	public void setAssignFaculty(AssignFacultyEntity assignFaculty) {
//		this.assignFaculty = assignFaculty;
//	}

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

	public String getRoleType() {
		return roleType;
	}

	public void setRoleType(String roleType) {
		this.roleType = roleType;
	}

	public UserEntity() {
	}

	

	public long getUserId() {
		return userId;
	}

	public void setUserId(long userId) {
		this.userId = userId;
	}

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
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

}
