package com.ams.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ams.entity.StudentEntity;
import com.ams.repository.StudentDAO;
@SpringBootTest
class StudentServiceImplTest {

	@Autowired
	StudentServiceImpl studentService;
	@MockBean
	StudentDAO	repo;

	@Test
	void testAdd() {
		StudentEntity temp = createAndSaveStudent();
		Mockito.when(repo.save(temp)).thenReturn(temp);
		assertThat(temp.getId()).isEqualTo(studentService.add(temp));
	}

	@Test
	void testUpdate() throws Exception{
		StudentEntity temp = createAndSaveStudent();
		Optional<StudentEntity> tempopt =Optional.of(temp);
		Mockito.when(repo.findById(temp.getId())).thenReturn(tempopt);
    	Mockito.when(repo.save(temp)).thenReturn(temp);
		temp.setCourseName("Train102");
		studentService.update(temp);
		assertThat(temp).isEqualTo(studentService.findByPk(temp.getId()));		
	}

	@Test
	void testDelete() {
		StudentEntity temp = createAndSaveStudent();
		studentService.delete(temp);
		verify(repo,times(1)).deleteById(temp.getId());
	}

	@Test
	void testFindByName() {
		StudentEntity temp = createAndSaveStudent();
		Mockito.when(repo.findByName(temp.getName())).thenReturn(temp);
		assertThat(temp).isEqualTo(studentService.findByName(temp.getName()));
	}

	@Test
	void testFindByPk() throws Exception{
		StudentEntity temp = createAndSaveStudent();
		Optional<StudentEntity> tempopt = Optional.of(temp);
		Mockito.when(repo.findById(temp.getId())).thenReturn(tempopt);
		assertThat(temp).isEqualTo(studentService.findByPk(temp.getId()));
	}

	@Test
	void testFindAllStudents() {
		StudentEntity temp = createAndSaveStudent();
		List<StudentEntity> tempList = new ArrayList<>();
		tempList.add(temp);
		Mockito.when(repo.findAll()).thenReturn(tempList);
		assertThat(1).isEqualTo(studentService.findAllStudents().size());
	}
	
	
	
	private StudentEntity createAndSaveStudent() {
		StudentEntity temp = new StudentEntity();
		Date dt = new Date();
		temp.setRollNo(101);
		temp.setFirstName("Mohan");
		temp.setLastName("Kumar");
		temp.setDob(dt);
		temp.setGender("Male");
		temp.setMobileNo("8602109476");
		temp.setCourseId(301);
		temp.setCourseName("Train101");
		temp.setSubjectId(201);
		temp.setSubjectName("Java");
		temp.setSemester("2nd");
		temp.setEmailId("sample@example.com");
		temp.setFatherEmailId("sample2@example.com");
		temp.setFatherMobileNo("1234587400");
		temp.setProfilePic("Path");
		temp.setName(temp.getFirstName(), temp.getLastName());
		return temp;
	}

}
