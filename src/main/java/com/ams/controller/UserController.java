package com.ams.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ams.entity.UserEntity;
import com.ams.service.UserServiceImpl;



@RestController
@RequestMapping(path="/api")
public class UserController {
	@Autowired
	UserServiceImpl userService;
	
	@GetMapping("/user")
	public ResponseEntity<String> info() {
		String msg = "This path has Following URI services : ";
		ResponseEntity<String> str1 = new ResponseEntity<String>(msg, HttpStatus.OK);
		return str1;
	}
	
	
	@RequestMapping(value="/user/add",method=RequestMethod.POST)
	public ResponseEntity<Long> add( @RequestBody UserEntity user) {
		System.out.println("you have neterd the add post method");
		long temp=userService.add(user);
		ResponseEntity<Long> res=new ResponseEntity<Long>(temp,HttpStatus.CREATED);
		return res;
	}
	
	@RequestMapping(value="/user/all",method=RequestMethod.GET)
	public ResponseEntity<List<UserEntity>> list() {
		List<UserEntity> userList=userService.userlist();
		ResponseEntity<List<UserEntity>> res=new ResponseEntity<List<UserEntity>>(userList,HttpStatus.OK);
		return res;
	}
	
	@RequestMapping(value="/user/delete/{userId}",method=RequestMethod.DELETE)
	public void delete (@PathVariable("userId") Long userId){
		userService.delete(userId);
	}
	
	@RequestMapping(value="/user/update",method=RequestMethod.PUT)
	public void update(@RequestBody UserEntity user) throws Exception{
		userService.update(user);
	}
	
	@RequestMapping(value="/user/byUserName/{name}",method=RequestMethod.GET)
	public ResponseEntity<UserEntity> getByName(@PathVariable("name") String name)throws Exception{
		UserEntity temp=userService.findByFirstName(name);
		ResponseEntity<UserEntity> res=new ResponseEntity<UserEntity>(temp,HttpStatus.ACCEPTED);
		return res;
	}
	
	@RequestMapping(value="/user/byId/{id}",method=RequestMethod.GET)
	public ResponseEntity<UserEntity> getById(@PathVariable("id") Long id)throws Exception{
		UserEntity temp=userService.findById(id);
		ResponseEntity<UserEntity> res=new ResponseEntity<UserEntity>(temp,HttpStatus.ACCEPTED);
		return res;
	}
	
	@RequestMapping(value="/user/authenticate",method=RequestMethod.GET)
	public ResponseEntity<Boolean> authenticate(@RequestBody String UserName){
		Boolean temp=userService.authenticate(UserName);
		ResponseEntity<Boolean> res=new ResponseEntity<Boolean>(temp,HttpStatus.ACCEPTED);
		return res;
			
	}
	
	@RequestMapping(value="/user/password",method=RequestMethod.GET)
	public ResponseEntity<Boolean> forgotPassword(@RequestBody String UserName){
		Boolean temp=userService.forgotPassword(UserName);
		ResponseEntity<Boolean> res=new ResponseEntity<Boolean>(temp,HttpStatus.ACCEPTED);
		return res;
			
	}
}
