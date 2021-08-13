package com.ams.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ams.entity.AttendanceEntity;
import com.ams.exception.RecordNotFoundException;
import com.ams.repository.AttendanceDAO;

@Service
public class AttendanceServiceImpl implements AttendanceService{
	
	static Supplier<Exception> s1=()->new RecordNotFoundException("Attendance Record Not Found in DataBase.");

	
	@Autowired
	AttendanceDAO attendanceDao;

	
	@Override
	public long add(AttendanceEntity attendance) {
		AttendanceEntity ae = attendanceDao.save(attendance);
		return ae.getAttendanceId();
	}

	@Override
	public void update(AttendanceEntity attendance) throws Exception{
		long id = attendance.getAttendanceId();
		AttendanceEntity ae = attendanceDao.findById(id).orElseThrow(s1);
		ae.setStudentId(attendance.getStudentId());
		ae.setSubjectName(attendance.getSubjectName());
		ae.setStudentId(attendance.getStudentId());
		ae.setStudentName(attendance.getStudentName());
		ae.setSemester(attendance.getSemester());
		ae.setDate(attendance.getDate());
		ae.setTotalClass(attendance.getTotalClass());
		ae.setStatus(attendance.getStatus());
		ae.setTotal(attendance.getTotal());
		ae.setPercentage(attendance.getPercentage());
		ae.setCourseId(attendance.getCourseId());
		ae.setCourseName(attendance.getCourseName());
		attendanceDao.save(attendance);
		
		}

	@Override
	public void delete(AttendanceEntity attendance) throws Exception {
		AttendanceEntity ae = attendanceDao.findById(attendance.getAttendanceId()).orElseThrow(s1);
		attendanceDao.deleteById(ae.getAttendanceId());
		
	}

	@Override
	public AttendanceEntity findByName(String name) {
		AttendanceEntity ae = attendanceDao.findByStudentName(name);
		return ae;
	}

	@Override
	public AttendanceEntity findByPk(long id) throws Exception {
		AttendanceEntity ae = attendanceDao.findById(id).orElseThrow(s1);
		return ae;
	}

	@Override
	public List<AttendanceEntity> findAllAttendances() {
		List<AttendanceEntity> aeList = attendanceDao.findAll();
		return aeList;
	}
}
