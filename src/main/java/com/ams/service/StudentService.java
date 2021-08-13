package com.ams.service;

import java.util.List;

import com.ams.entity.StudentEntity;

public interface StudentService {
	public long add(StudentEntity student);
	public StudentEntity update(StudentEntity student) throws Exception;
	public void delete(StudentEntity student);
	public StudentEntity findByName(String name);
	public StudentEntity findByPk(long id)throws Exception;
	public List<StudentEntity> findAllStudents();
}
