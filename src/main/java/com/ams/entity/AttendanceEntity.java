package com.ams.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

/*
  Entity Definition of ATTENDANCE_ENTITY Table
  @author: Tejaswini 
 */
@Entity
public class AttendanceEntity {
	
	@Id
	@GeneratedValue
	private long attendanceId;
	
	@Length(min=3,max=15)
	@NotNull(message = "\nSubjectName is required")
	private String subjectName;
	
	@Length(min=2,max=5)
	@NotNull(message= "\nSemester is required")
	private String semester;
	
	@NotNull(message = "\nDate is required")
	private Date attendanceDate;
	
	@Length(min=1,max=3)
	@NotNull(message= "\nTotalClass is required")
	private String totalClass;
	
	@Min(1)
	@NotNull(message= "\nStatus is required")
	private long status;
	
	@Min(1)
	@NotNull(message= "\nTotal is required")
	private long total;
	
	@Length(min=1,max=2)
	@NotNull(message= "\nPercentage is required")
	private String percentage;
	
	@Min(2)
	@NotNull(message= "\nCourseId is required")
	private long courseId;
	
	@Length(min=3,max=10)
	@NotNull(message= "\nCourseName is required")
	private String courseName;

/*
 Many To one Relation with Student Entity
*/
	@ManyToOne
	private StudentEntity student;
	

	
/*
 Setter Getters for the Entity Attributes
*/

	public StudentEntity getStudent() {
		return student;
	}

	public void setStudent(StudentEntity student) {
		this.student = student;
	}

	public long getAttendanceId() {
		return attendanceId;
	}

	public void setAttendanceId(long attendanceId) {
		this.attendanceId = attendanceId;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public String getSemester() {
		return semester;
	}

	public void setSemester(String semester) {
		this.semester = semester;
	}

	
	public Date getAttendanceDate() {
		return attendanceDate;
	}

	public void setAttendanceDate(Date attendanceDate) {
		this.attendanceDate = attendanceDate;
	}

	public String getTotalClass() {
		return totalClass;
	}

	public void setTotalClass(String totalClass) {
		this.totalClass = totalClass;
	}

	public long getStatus() {
		return status;
	}

	public void setStatus(long status) {
		this.status = status;
	}

	public long getTotal() {
		return total;
	}

	public void setTotal(long total) {
		this.total = total;
	}

	public String getPercentage() {
		return percentage;
	}

	public void setPercentage(String percentage) {
		this.percentage = percentage;
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

	
}
