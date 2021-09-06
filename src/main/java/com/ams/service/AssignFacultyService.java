package com.ams.service;

import java.util.List;

import com.ams.entity.FacultyEntity;

public interface AssignFacultyService {

	public long add(FacultyEntity assignfaculty);

	public void update(FacultyEntity assignfaculty) throws Exception;

	public long delete(long id) throws Exception;

	FacultyEntity findByPK(long id) throws Exception;

	FacultyEntity findByUserName(String name);

	public List<FacultyEntity> findAllAssignFaculty();
}
