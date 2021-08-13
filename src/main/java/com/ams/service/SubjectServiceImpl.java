package com.ams.service;

import java.util.List;
import java.util.function.Supplier;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ams.entity.SubjectEntity;
import com.ams.exception.RecordNotFoundException;
import com.ams.repository.SubjectDAO;

@Service
public class SubjectServiceImpl implements SubjectService{
	  
	  static Supplier<Exception>s1=()->new RecordNotFoundException("Subject Not Found in DataBase");
	  
	 @Autowired
	  private SubjectDAO sub;
	  
	  @Override
	  public long add(SubjectEntity subject) 
	  { 
		  SubjectEntity s=sub.save(subject); 
		  return s.getSubjectId();
		  
	  }
	  
	  @Override
	  public void update(SubjectEntity subject)throws Exception
	  { 
		  long id=subject.getSubjectId();
		  SubjectEntity s=sub.findById( id).orElseThrow(s1);
		  s.setCourseId(subject.getCourseId());
		  s.setCourseName(subject.getCourseName());
		  s.setSubjectName(subject.getSubjectName()); 
		  s.setSubjectCode(subject.getSubjectCode());
		  s.setSemester(subject.getSemester());
		  s.setDescription(subject.getDescription()); 
		  sub.save(s);	  	  
	  }
	  
	  @Override
	  public void delete(SubjectEntity subject)
		  { 
			  sub.delete(subject); 		  
		  }
	  
	  @Override 
	  public SubjectEntity findByName(String subjectName) 
	  { 
		  SubjectEntity s=sub.findBySubjectName(subjectName);
		  return s;
	  }
	  
	  @Override
	  public SubjectEntity findByPk(long subjectId) throws Exception
	  { 
		  SubjectEntity s=sub.findById(subjectId).orElseThrow(s1);
		  return s;   
	  } 
	  
	  @Override public List<SubjectEntity> findAllSubject()
	  {    
		  List<SubjectEntity> subList =sub.findAll();
		  return subList; 	  
	  }
}
