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

import com.ams.entity.SubjectEntity;
import com.ams.repository.SubjectDAO;
@SpringBootTest
class SubjectServiceImplTest {

	@Autowired
	SubjectServiceImpl subjectservice;
	@MockBean
	SubjectDAO sub;
	
	
	private SubjectEntity dataSubject()
	{
		SubjectEntity temp=new SubjectEntity();
		//temp.setSubjectId(2);
		temp.setDescription("Theory");
		temp.setSemester("Third");
		temp.setSubjectCode("MCA01");
		temp.setSubjectName("Java");
		return temp;
	}
	@Test
	void testAdd()
	{
		SubjectEntity temp=dataSubject();
		Mockito.when(sub.save(temp)).thenReturn(temp);
		assertThat(temp.getSubjectId()).isEqualTo(subjectservice.add(temp));
	}
	
	@Test
	void testUpdate()throws Exception
	{
		SubjectEntity temp= dataSubject();
		Optional<SubjectEntity> op=Optional.of(temp);
		Mockito.when(sub.findById(temp.getSubjectId())).thenReturn(op);
		Mockito.when(sub.save(temp)).thenReturn(temp);
		temp.setSubjectName("JavaScript");
		subjectservice.update(temp);
		assertThat(temp).isEqualTo(subjectservice.findByPk(temp.getSubjectId()));
	}
	
	@Test
	void testDelete() throws Exception
	{
		SubjectEntity temp=dataSubject();
		Optional<SubjectEntity> tempOpt= Optional.of(temp);
		Mockito.when(sub.findById(temp.getSubjectId())).thenReturn(tempOpt);
		subjectservice.delete(temp.getSubjectId());
		verify(sub,times(1)).deleteById(temp.getSubjectId());	
	}
	
	@Test
	void testFindByName()
	{
		SubjectEntity temp=dataSubject();
		Mockito.when(sub.findBySubjectName(temp.getSubjectName())).thenReturn(temp);
		assertThat(temp).isEqualTo(subjectservice.findByName(temp.getSubjectName()));		
	}
	
	@Test
	void testFindByPk()throws Exception
	{
		SubjectEntity temp=dataSubject();
		Optional<SubjectEntity>op=Optional.of(temp);
		Mockito.when(sub.findById(temp.getSubjectId())).thenReturn(op);
		assertThat(temp).isEqualTo(subjectservice.findByPk(temp.getSubjectId()));
	}
	 
	@Test
	void testFindAllStudents()
	{
		SubjectEntity temp=dataSubject();
		List<SubjectEntity>list=new ArrayList<>();
		list.add(temp);
		Mockito.when(sub.findAll()).thenReturn(list);
		assertThat(1).isEqualByComparingTo(subjectservice.findAllSubject().size());
	}

}
