package com.ams.entity;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

import org.hibernate.validator.constraints.Length;

@Entity
public class AttendanceEntity {
	
	@Id
	@GeneratedValue
	private long attendanceId;
	
	@Length(min=3,max=15)
	@NotNull(message = "SubjectName is required")
	private String subjectName;
	
	@Length(min=2,max=5)
	@NotNull(message= "Semester is required")
	private String semester;
	
	@NotNull(message = "Date is required")
	private Date attendanceDate;
	
	@Length(min=1,max=3)
	@NotNull(message= "TotalClass is required")
	private String totalClass;
	
	@Min(1)
	@NotNull(message= "Status is required")
	private long status;
	
	@Min(1)
	@NotNull(message= "Total is required")
	private long total;
	
	@Length(min=1,max=2)
	@NotNull(message= "Percentage is required")
	private String percentage;
	
	@Min(2)
	@NotNull(message= "CourseId is required")
	private long courseId;
	
	@Length(min=3,max=10)
	@NotNull(message= "CourseName is required")
	private String courseName;

	
	@ManyToOne
	private StudentEntity student;
	
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

	@Override
	public String toString() {
		return "AttendanceEntity [attendanceId=" + attendanceId + ", subjectName=" + subjectName + ", semester="
				+ semester + ", attendanceDate=" + attendanceDate + ", totalClass=" + totalClass + ", status=" + status
				+ ", total=" + total + ", percentage=" + percentage + ", courseId=" + courseId + ", courseName="
				+ courseName + ", student=" + student + "]";
	}

	
}
