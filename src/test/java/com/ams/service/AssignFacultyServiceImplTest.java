package com.ams.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ams.entity.FacultyEntity;
import com.ams.repository.AssignFacultyDAO;
@SpringBootTest
class AssignFacultyServiceImplTest {

	@Autowired
	AssignFacultyServiceImpl assignfacultyservice;
	
	@MockBean
	AssignFacultyDAO repo;
	
	@Test
	void testAdd() {
		FacultyEntity temp =createAndSaveAssignFaculty();
		Mockito.when(repo.save(temp)).thenReturn(temp);
		assertThat(temp.getFacultyid()).isEqualTo(assignfacultyservice.add(temp));
	}
	@Test
	void testUpdate() throws Exception{
		FacultyEntity temp = createAndSaveAssignFaculty();
		Optional<FacultyEntity> tempopt =Optional.of(temp);
		Mockito.when(repo.findById(temp.getFacultyid())).thenReturn(tempopt);
    	Mockito.when(repo.save(temp)).thenReturn(temp);
//		temp.setCourseName("CSE");
		assignfacultyservice.update(temp);
		assertThat(temp).isEqualTo(assignfacultyservice.findByPK(temp.getFacultyid()));		
	}
		
	@Test
	void testDelete() throws Exception {
		FacultyEntity temp = createAndSaveAssignFaculty();
		Optional<FacultyEntity> tempopt =Optional.of(temp);
		Mockito.when(repo.findById(temp.getFacultyid())).thenReturn(tempopt);
		assignfacultyservice.delete(temp.getFacultyid());
		verify(repo,times(1)).deleteById(temp.getFacultyid());
	}
	

	@Test
	void testFindByName() {
		FacultyEntity temp = createAndSaveAssignFaculty();
		Mockito.when(repo.findByUserName(temp.getUserName())).thenReturn(temp);
		assertThat(temp).isEqualTo(assignfacultyservice.findByUserName(temp.getUserName()));
	}

	@Test
	void testFindByPk() throws Exception{
		FacultyEntity temp = createAndSaveAssignFaculty();
		Optional<FacultyEntity> tempopt = Optional.of(temp);
		Mockito.when(repo.findById(temp.getFacultyid())).thenReturn(tempopt);
		assertThat(temp).isEqualTo(assignfacultyservice.findByPK(temp.getFacultyid()));
	}

	@Test
	void testFindAllStudents()  {
		FacultyEntity temp = createAndSaveAssignFaculty();
		List<FacultyEntity> tempList = new ArrayList<>();
		tempList.add(temp);
		Mockito.when(repo.findAll()).thenReturn(tempList);
		assertThat(1).isEqualTo(assignfacultyservice.findAllAssignFaculty().size());
	}
	
	private FacultyEntity createAndSaveAssignFaculty() {
		FacultyEntity temp = new FacultyEntity();
//		temp.setUserId((long) 1100);
		temp.setUserName("Somil");
//		temp.setCourseId((long) 150);
//		temp.setCourseName("CSE");
//		temp.setSubjectId((long) 765);
//		temp.setSubjectName("java");
		temp.setTotalClass("10");
		return temp;
		
		
	
	}

}
