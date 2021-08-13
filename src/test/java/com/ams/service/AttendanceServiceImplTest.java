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

import com.ams.entity.AttendanceEntity;
import com.ams.repository.AttendanceDAO;
@SpringBootTest
class AttendanceServiceImplTest {
	@Autowired
	AttendanceServiceImpl attendanceService;
	
	@MockBean
	AttendanceDAO attendanceDao;

	@Test
	void testAdd() {
		AttendanceEntity ae = createAndSaveAttendance();
				
		Mockito.when(attendanceDao.save(ae)).thenReturn(ae);
		assertThat(ae.getAttendanceId()).isEqualTo(attendanceService.add(ae));
	}

	@Test
	void testUpdate() throws Exception {
		AttendanceEntity ae = createAndSaveAttendance();
		Optional<AttendanceEntity> aeOpt = Optional.of(ae);
		Mockito.when(attendanceDao.findById(ae.getAttendanceId())).thenReturn(aeOpt);
		Mockito.when(attendanceDao.save(ae)).thenReturn(ae);
		ae.setCourseName("Angular2.0");
		attendanceService.update(ae);
		assertThat(ae).isEqualTo(attendanceService.findByPk(ae.getAttendanceId()));
		
	}

	@Test
	void testDelete() throws Exception  {
		AttendanceEntity ae = createAndSaveAttendance();
		Optional<AttendanceEntity> aeOpt = Optional.of(ae);
		Mockito.when(attendanceDao.findById(ae.getAttendanceId())).thenReturn(aeOpt);
		attendanceService.delete(ae);
		verify(attendanceDao,times(1)).deleteById(ae.getAttendanceId());
		
	}

	@Test
	void testFindByName()  {
		AttendanceEntity ae = createAndSaveAttendance();
		Mockito.when(attendanceDao.findBySubjectName(ae.getSubjectName())).thenReturn(ae);
		assertThat(ae).isEqualTo(attendanceService.findByName(ae.getSubjectName()));
		
	}

	@Test
	void testFindByPk() throws Exception {
		AttendanceEntity ae = createAndSaveAttendance();
		Optional<AttendanceEntity> aeOpt = Optional.of(ae);
		Mockito.when(attendanceDao.findById(ae.getAttendanceId())).thenReturn(aeOpt);
		assertThat(ae).isEqualTo(attendanceService.findByPk(ae.getAttendanceId()));
		
	}

	@Test
	void testFindAllAttendances() {
		AttendanceEntity ae = createAndSaveAttendance();
		List<AttendanceEntity> aeList = new ArrayList<>();
		aeList.add(ae);
		Mockito.when(attendanceDao.findAll()).thenReturn(aeList);
		assertThat(1).isEqualTo(attendanceService.findAllAttendances().size());
	}
	
	private AttendanceEntity createAndSaveAttendance() {
		
		AttendanceEntity ae = new AttendanceEntity();
		ae.setAttendanceId(1);
		ae.setSubjectId(352);
		ae.setSubjectName("Python");
		ae.setSemester("4th");
		ae.setTotalClass("B-52");
		ae.setStatus(1);
		ae.setTotal(32);
		ae.setPercentage("56.7");
		ae.setCourseId(811);
		ae.setCourseName("Angular");
		
		return ae;
		
	}

}
