package com.ams.service;

import java.util.List;

import com.ams.entity.StudentEntity;

public interface StudentService {
	public long add(StudentEntity student);
	public StudentEntity update(StudentEntity student) throws Exception;
	public long delete(long id);
	public StudentEntity findByName(String name);
	public StudentEntity findByPk(long id)throws Exception;
	public StudentEntity findByRoll(long roll);
	public List<StudentEntity> findAllStudents();
}
