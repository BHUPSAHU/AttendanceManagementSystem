package com.ams.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ams.entity.AttendanceEntity;
import com.ams.exception.AttendanceNotFoundException;
import com.ams.repository.AttendanceDAO;

@Service
public class AttendanceServiceImpl implements AttendanceService {

	static Supplier<Exception> s1 = () -> new AttendanceNotFoundException("Attendance Record Not Found in DataBase.");

	@Autowired
	AttendanceDAO attendanceDao;

	// saving a specific record by using the method save()
	@Override
	public long add(AttendanceEntity attendance) {
		AttendanceEntity ae = attendanceDao.save(attendance);
		return ae.getAttendanceId();
	}

	// updating a record
	@Override
	public void update(AttendanceEntity attendance) throws Exception {
		long id = attendance.getAttendanceId();
		AttendanceEntity ae = attendanceDao.findById(id).orElseThrow(s1);
		ae.setSubjectName(attendance.getSubjectName());
		ae.setSemester(attendance.getSemester());
		ae.setAttendanceDate(attendance.getAttendanceDate());
		ae.setTotalClass(attendance.getTotalClass());
		ae.setStatus(attendance.getStatus());
		ae.setTotal(attendance.getTotal());
		ae.setPercentage(attendance.getPercentage());
		ae.setStudent(attendance.getStudent());
		attendanceDao.save(attendance);

	}

	// deleting a specific record by using the method deleteById()
	@Override
	public void delete(AttendanceEntity attendance) throws Exception {
		AttendanceEntity ae = attendanceDao.findById(attendance.getAttendanceId()).orElseThrow(s1);
		attendanceDao.deleteById(ae.getAttendanceId());

	}

	// getting a specific record by using the method findByName()
	@Override
	public AttendanceEntity findByName(String name) {
		AttendanceEntity ae = attendanceDao.findBySubjectName(name);
		return ae;
	}

	// getting a specific record by using the method findById()
	@Override
	public AttendanceEntity findByPk(long id) throws Exception {
		AttendanceEntity ae = attendanceDao.findById(id).orElseThrow(s1);
		return ae;
	}

	// getting all records by using method findAll()
	@Override
	public List<AttendanceEntity> findAllAttendances() {
		List<AttendanceEntity> aeList = attendanceDao.findAll();
		return aeList;
	}
}
