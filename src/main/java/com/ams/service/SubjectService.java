package com.ams.service;

import java.util.List;

import com.ams.entity.SubjectEntity;

public interface SubjectService {
	public long add(SubjectEntity subject);
	public void update(SubjectEntity subject) throws Exception;
	public void delete(SubjectEntity subject);
	public SubjectEntity findByName(String subject);
	public SubjectEntity findByPk(long subjectId) throws Exception;
	public List<SubjectEntity> findAllSubject() throws Exception;
}
