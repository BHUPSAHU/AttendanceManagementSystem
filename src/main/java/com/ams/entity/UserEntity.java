package com.ams.entity;

import java.time.LocalDate;

import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.OneToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Pattern;

import org.hibernate.validator.constraints.Length;
import org.springframework.format.annotation.DateTimeFormat;


@Entity
public class UserEntity {
	
	@Id
	@GeneratedValue
	private long userId;

	@NotNull
	@Length(min = 3, max = 30, message = "First name should be between 3 and 30  characters")
	private String firstName;
	
	@NotNull
	@Length(min = 1, max = 30, message = "Last name should be between 1 and 30  characters")
	private String lastName;

	@NotNull
	@Length(min = 10, max = 10, message = "Mobile number should be only 10 digits")
	@Pattern(regexp="(^$|[0-9]{10})", message = "Mobile number should be only Numbers")
	private String mobileNo;

	@Length(min = 10, message = "Profile Picture URL should be minimum 10 characters ")
	private String profilePic;

	@DateTimeFormat(pattern = "yyyy-MM-dd")
    @NotNull(message="date of birth is required")
	@Past(message ="Date should be past dates" )
	private LocalDate dob;

	@Length(min = 6, max = 15)
	@NotNull(message="password is required")
	private String password;

	@Min(1)
	@NotNull(message= "Role Type is required")
	private long roleType;
	
	@OneToOne(cascade=CascadeType.ALL)
	private FacultyEntity assignFaculty;

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

	public FacultyEntity getAssignFaculty() {
		return assignFaculty;
	}

	public void setAssignFaculty(FacultyEntity assignFaculty) {
		this.assignFaculty = assignFaculty;
	}

	
}
