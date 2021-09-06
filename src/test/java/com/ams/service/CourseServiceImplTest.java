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

import com.ams.entity.CourseEntity;
import com.ams.repository.CourseDAO;

@SpringBootTest
class CourseServiceImplTest {

	@Autowired
	CourseServiceImpl courseservice;
	@MockBean
	CourseDAO sub;

	private CourseEntity dataCourse() {
		CourseEntity temp = new CourseEntity();
		temp.setCourseName("JavaFullStack");
		temp.setDescription("Learn Java");
		return temp;
	}

	@Test
	void testAdd() {
		CourseEntity temp = dataCourse();
		Mockito.when(sub.save(temp)).thenReturn(temp);
		assertThat(temp.getCourseId()).isEqualTo(courseservice.add(temp));
	}

	@Test
	void testUpdate() throws Exception {
		CourseEntity temp = dataCourse();
		Optional<CourseEntity> op = Optional.of(temp);
		Mockito.when(sub.findById(temp.getCourseId())).thenReturn(op);
		Mockito.when(sub.save(temp)).thenReturn(temp);
		temp.setCourseName("JavaScript");
		courseservice.update(temp);
		assertThat(temp).isEqualTo(courseservice.findByPk(temp.getCourseId()));
	}

	@Test
	void testDelete() throws Exception {
		CourseEntity temp = dataCourse();
		Optional<CourseEntity> tempopt = Optional.of(temp);
		Mockito.when(sub.findById(temp.getCourseId())).thenReturn(tempopt);
		courseservice.delete(temp.getCourseId());
		verify(sub, times(1)).delete(temp);
		;
	}

	@Test
	void testFindByName() {
		CourseEntity temp = dataCourse();
		Mockito.when(sub.findByCourseName(temp.getCourseName())).thenReturn(temp);
		assertThat(temp).isEqualTo(courseservice.findByName(temp.getCourseName()));
	}

	@Test
	void testFindByPk() throws Exception {
		CourseEntity temp = dataCourse();
		Optional<CourseEntity> op = Optional.of(temp);
		Mockito.when(sub.findById(temp.getCourseId())).thenReturn(op);
		assertThat(temp).isEqualTo(courseservice.findByPk(temp.getCourseId()));
	}

	@Test
	void testFindAllStudents() {
		CourseEntity temp = dataCourse();
		List<CourseEntity> list = new ArrayList<>();
		list.add(temp);
		Mockito.when(sub.findAll()).thenReturn(list);
		assertThat(1).isEqualByComparingTo(courseservice.findAllCourse().size());
	}
}
