package com.clarivate.foodapp.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.clarivate.foodapp.dto.ResponseStructure;
import com.clarivate.foodapp.dto.User;
import com.clarivate.foodapp.service.UserService;

@RestController
public class UserControl {
	@Autowired
	UserService userService;
	
	
	@RequestMapping(value = "/hello")
	public String hello() {
		return "Hello world!!";
	}
	
	@RequestMapping("/user")
	public ResponseStructure<User> saveUser(@RequestBody User user) {
		return userService.saveUser(user);
		
	}
	@GetMapping("/user")
	public ResponseStructure<List<User>> listUser() {
		return userService.listUser();
		
	}
	@GetMapping("/user/{id}")
	public ResponseStructure<User> getUserById(@PathVariable int id ) {
		return userService.getUserById(id);
		
	}
	@DeleteMapping("/user/{id}")
	public ResponseStructure<String> delUser(@PathVariable int id){
		return userService.delUser(id);
	}
	@PutMapping("/user")
	public ResponseStructure<User> updateUser(@RequestBody User user){
		return userService.updateUser(user);
	}

	
}
