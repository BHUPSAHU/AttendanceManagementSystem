package com.ams.service;

import java.util.List;

import com.ams.entity.AssignFacultyEntity;

public interface AssignFacultyService {

	public long add(AssignFacultyEntity assignfaculty);

	public void update(AssignFacultyEntity assignfaculty) throws Exception;

	public void delete(AssignFacultyEntity assignfaculty) throws Exception;

	AssignFacultyEntity findByPK(long id) throws Exception;

	AssignFacultyEntity findByUserName(String name);

	public List<AssignFacultyEntity> findAllAssignFaculty();
}
