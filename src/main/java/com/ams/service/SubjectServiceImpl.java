package com.ams.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ams.entity.SubjectEntity;
import com.ams.exception.SubjectNotFoundException;
import com.ams.repository.SubjectDAO;

@Service
public class SubjectServiceImpl implements SubjectService {

	static Supplier<Exception> s1 = () -> new SubjectNotFoundException("Subject Not Found in DataBase");

	@Autowired
	private SubjectDAO sub;

	// saving a specific record by using the method save()
	@Override
	public long add(SubjectEntity subject) {
		SubjectEntity s = sub.save(subject);
		return s.getSubjectId();

	}

	// updating a record
	@Override
	public void update(SubjectEntity subject) throws Exception {
		long id = subject.getSubjectId();
		SubjectEntity s = sub.findById(id).orElseThrow(s1);
		s.setSubjectName(subject.getSubjectName());
		s.setSubjectCode(subject.getSubjectCode());
		s.setSemester(subject.getSemester());
		s.setDescription(subject.getDescription());
		s.setCourse(subject.getCourse());
		sub.save(s);
	}

	// deleting a specific record by using the method deleteById()
	@Override
	public long delete(long id) throws Exception {
		sub.deleteById(id);
		return id;
	}

	// getting a specific record by using the method findByName()
	@Override
	public SubjectEntity findByName(String subjectName) {
		SubjectEntity s = sub.findBySubjectName(subjectName);
		return s;
	}

	// getting a specific record by using the method findById()
	@Override
	public SubjectEntity findByPk(long subjectId) throws Exception {
		SubjectEntity s = sub.findById(subjectId).orElseThrow(s1);
		return s;
	}

	// getting all records by using method findAll()
	@Override
	public List<SubjectEntity> findAllSubject() {
		List<SubjectEntity> subList = sub.findAll();
		return subList;
	}
}
