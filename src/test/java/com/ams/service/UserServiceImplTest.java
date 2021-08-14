package com.ams.service;

import static org.assertj.core.api.Assertions.assertThat;
import static org.mockito.Mockito.times;
import static org.mockito.Mockito.verify;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;

import com.ams.entity.UserEntity;
import com.ams.repository.UserDAO;
@SpringBootTest
class UserServiceImplTest {

	@Autowired
	UserServiceImpl userSImpl;
	
	@MockBean
	UserDAO userRepo;
	
	@Test
	void testadd() {
		UserEntity user=createusertemp();
		
		Mockito.when(userRepo.save(user)).thenReturn(user);
		assertThat(user.getUserId()).isEqualTo(userSImpl.add(user));
	}
	
	@Test
	void testdelete() {
		UserEntity user=createusertemp();
		userSImpl.delete(user.getUserId());
		//Mockito.when(userRepo.deleteById(user.getUserId())).thenReturn(true);
		//assertThat(user).isEqualTo(userSImpl.add(user));
		verify(userRepo,times(1)).deleteById(user.getUserId());
	}
	
	
	
	@Test
	void testFindByName() throws Exception{
		UserEntity user=createusertemp();
		Mockito.when(userRepo.findByFirstName(user.getFirstName())).thenReturn(user);
		assertThat(user).isEqualTo(userSImpl.findByFirstName(user.getFirstName()));
		
	}
	
	@Test
	void testFindById() throws Exception{
		UserEntity user=createusertemp();
		Optional<UserEntity> optemp=Optional.of(user);
		Mockito.when(userRepo.findById(user.getUserId())).thenReturn(optemp);
		assertThat(user).isEqualTo(userSImpl.findById(user.getUserId()));
		
	}
	
	@Test
	void testupdate() throws Exception{
		UserEntity user=createusertemp();
		Optional<UserEntity> optemp=Optional.of(user);
		Mockito.when(userRepo.findById(user.getUserId())).thenReturn(optemp);
		Mockito.when(userRepo.save(user)).thenReturn(user);
		user.setFirstName("tester");
		userSImpl.update(user);
		assertThat(user).isEqualTo(userSImpl.findById(user.getUserId()));
	}
	
	
	@Test
	void testlist() {
		UserEntity user= createusertemp();
		List<UserEntity> lit=new ArrayList<UserEntity>();
		lit.add(user);
		Mockito.when(userRepo.findAll()).thenReturn(lit);
		assertThat(lit).isEqualTo(userSImpl.userlist());
	}
	
	
	UserEntity createusertemp(){
		UserEntity user=new UserEntity();
		user.setDob(LocalDate.now());
		user.setFirstName("test");
		user.setLastName("one");
		user.setMobileNo("777777777");
		user.setPassword("pass");
		user.setProfilePic("hellopic");
		user.setRoleType(1);
		return user;
	}

}
