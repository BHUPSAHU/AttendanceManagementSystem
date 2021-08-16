package com.ams.controller;

import java.time.LocalDateTime;
import java.util.List;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.validation.FieldError;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.ams.entity.UserEntity;
import com.ams.exception.ErrorDetails;
import com.ams.service.UserServiceImpl;

/**
 * @author Anjan
 *
 */
//mark class as controller

@RestController
@RequestMapping(path = "/api")
public class UserController {

	// @Autowire the UserService class
	@Autowired
	UserServiceImpl userService;

	@GetMapping("/user")
	public ResponseEntity<String> info() {
		String msg = "This path has Following URI services : ";
		ResponseEntity<String> str1 = new ResponseEntity<String>(msg, HttpStatus.OK);
		return str1;
	}

	// creating post mapping that adds to DB
	@SuppressWarnings({ "unchecked", "rawtypes" })
	@RequestMapping(value = "/user/add", method = RequestMethod.POST)
	public ResponseEntity<Long> add(@Valid @RequestBody UserEntity user, BindingResult result) {
		if (result.hasErrors()) {
			ErrorDetails errorDetails = new ErrorDetails(LocalDateTime.now(), result.getFieldErrors().stream()
					.map(FieldError::getDefaultMessage).collect(Collectors.toList()).toString(),
					"ConstraintViolationException");
			return new ResponseEntity(errorDetails, HttpStatus.BAD_REQUEST);
		}
		long temp = userService.add(user);
		ResponseEntity<Long> res = new ResponseEntity<Long>(temp, HttpStatus.CREATED);
		return res;
	}

	// fetch all users through Get mapping
	@RequestMapping(value = "/user/all", method = RequestMethod.GET)
	public ResponseEntity<List<UserEntity>> list() {
		List<UserEntity> userList = userService.userlist();
		ResponseEntity<List<UserEntity>> res = new ResponseEntity<List<UserEntity>>(userList, HttpStatus.OK);
		return res;
	}

	// creating delete mapping that deletes on DB
	@RequestMapping(value = "/user/delete/{userId}", method = RequestMethod.DELETE)
	public void delete(@PathVariable("userId") Long userId) {
		userService.delete(userId);
	}

	// creating put mapping that update to DB
	@RequestMapping(value = "/user/update", method = RequestMethod.PUT)
	public void update(@RequestBody UserEntity user) throws Exception {
		userService.update(user);
	}

	// creating get mapping through Name
	@RequestMapping(value = "/user/byUserName/{name}", method = RequestMethod.GET)
	public ResponseEntity<UserEntity> getByName(@PathVariable("name") String name) throws Exception {
		UserEntity temp = userService.findByFirstName(name);
		ResponseEntity<UserEntity> res = new ResponseEntity<UserEntity>(temp, HttpStatus.ACCEPTED);
		return res;
	}

	// creating get mapping through Id
	@RequestMapping(value = "/user/byId/{id}", method = RequestMethod.GET)
	public ResponseEntity<UserEntity> getById(@PathVariable("id") Long id) throws Exception {
		UserEntity temp = userService.findById(id);
		ResponseEntity<UserEntity> res = new ResponseEntity<UserEntity>(temp, HttpStatus.ACCEPTED);
		return res;
	}

	// creating get mapping for Authentication
	@RequestMapping(value = "/user/authenticate", method = RequestMethod.GET)
	public ResponseEntity<Boolean> authenticate(@RequestBody String userName) {
		Boolean temp = userService.authenticate(userName);
		ResponseEntity<Boolean> res = new ResponseEntity<Boolean>(temp, HttpStatus.ACCEPTED);
		return res;

	}

	// creating get mapping for forgot password
	@RequestMapping(value = "/user/password", method = RequestMethod.GET)
	public ResponseEntity<Boolean> forgotPassword(@RequestBody String userName) {
		Boolean temp = userService.forgotPassword(userName);
		ResponseEntity<Boolean> res = new ResponseEntity<Boolean>(temp, HttpStatus.ACCEPTED);
		return res;

	}
}
