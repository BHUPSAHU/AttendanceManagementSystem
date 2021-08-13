package com.ams.service;

import java.util.List;

import com.ams.entity.AttendanceEntity;

public interface AttendanceService {
	public long add(AttendanceEntity attendance);
	public void update(AttendanceEntity attendance) throws Exception;
	public void delete(AttendanceEntity attendance) throws Exception;
	public AttendanceEntity findByName(String name);
	public AttendanceEntity findByPk(long id) throws Exception;
	public List<AttendanceEntity> findAllAttendances();
	}
