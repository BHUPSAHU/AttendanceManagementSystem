package com.ams.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ams.entity.FacultyEntity;
import com.ams.exception.RecordNotFoundException;
import com.ams.repository.AssignFacultyDAO;

@Service
public class AssignFacultyServiceImpl implements AssignFacultyService {
	
	Supplier<Exception> s1 = () -> new RecordNotFoundException("Faculty Record Not Found in DataBase.");
	
	@Autowired
	AssignFacultyDAO repo;

	@Override
	public List<FacultyEntity> findAllAssignFaculty() {
		List<FacultyEntity> tempList = repo.findAll();
		return tempList;
	}

	@Override
	public long add(FacultyEntity entity) {
		FacultyEntity temp = repo.save(entity);
		return temp.getFacultyid();
	}

	@Override
	public void update(FacultyEntity entity) throws Exception {
		long id = entity.getFacultyid();
		
		FacultyEntity temp = repo.findById(id).orElseThrow(s1);
//		temp.setUserId(entity.getUserId());
		temp.setUserName(entity.getUserName());
//		temp.setCourseId(entity.getCourseId());
//		temp.setCourseName(entity.getCourseName());
//		temp.setSubjectId(entity.getSubjectId());
//		temp.setSubjectName(entity.getSubjectName());
//		temp.setSemester(entity.getSemester());
		temp.setTotalClass(entity.getTotalClass());
		repo.save(temp);
	}

	@Override
	public void delete(FacultyEntity assignfaculty) throws Exception {
		FacultyEntity temp = repo.findById(assignfaculty.getFacultyid()).orElseThrow(s1);
		repo.deleteById(temp.getFacultyid());
	}

	@Override
	public FacultyEntity findByUserName(String name) {
		FacultyEntity temp = repo.findByUserName(name);
		return temp;
	}

	@Override
	public FacultyEntity findByPK(long id) throws Exception {
		FacultyEntity temp = repo.findById(id).orElseThrow(s1);
		return temp;
	}
	
}
