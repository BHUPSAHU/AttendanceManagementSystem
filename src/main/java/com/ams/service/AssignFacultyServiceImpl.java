package com.ams.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ams.entity.AssignFacultyEntity;
import com.ams.exception.RecordNotFoundException;
import com.ams.repository.AssignFacultyDAO;

@Service
public class AssignFacultyServiceImpl implements AssignFacultyService {
	
	Supplier<Exception> s1 = () -> new RecordNotFoundException("Faculty Record Not Found in DataBase.");
	
	@Autowired
	AssignFacultyDAO repo;

	@Override
	public List<AssignFacultyEntity> findAllAssignFaculty() {
		List<AssignFacultyEntity> tempList = repo.findAll();
		return tempList;
	}

	@Override
	public long add(AssignFacultyEntity entity) {
		AssignFacultyEntity temp = repo.save(entity);
		return temp.getFacultyid();
	}

	@Override
	public void update(AssignFacultyEntity entity) throws Exception {
		long id = entity.getFacultyid();
		
		AssignFacultyEntity temp = repo.findById(id).orElseThrow(s1);
		temp.setUserId(entity.getUserId());
		temp.setUserName(entity.getUserName());
		temp.setCourseId(entity.getCourseId());
		temp.setCourseName(entity.getCourseName());
		temp.setSubjectId(entity.getSubjectId());
		temp.setSubjectName(entity.getSubjectName());
		temp.setSemester(entity.getSemester());
		temp.setTotalClass(entity.getTotalClass());
		repo.save(temp);
	}

	@Override
	public void delete(AssignFacultyEntity assignfaculty) throws Exception {
		AssignFacultyEntity temp = repo.findById(assignfaculty.getFacultyid()).orElseThrow(s1);
		repo.deleteById(temp.getFacultyid());
	}

	@Override
	public AssignFacultyEntity findByUserName(String name) {
		AssignFacultyEntity temp = repo.findByUserName(name);
		return temp;
	}

	@Override
	public AssignFacultyEntity findByPK(long id) throws Exception {
		AssignFacultyEntity temp = repo.findById(id).orElseThrow(s1);
		return temp;
	}
	
}
