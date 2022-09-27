package com.clarivate.foodapp.dao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;


import com.clarivate.foodapp.repo.UserRepo;
import com.clarivate.foodapp.dto.User;
@Component
public class UserDao {
	@Autowired
	UserRepo userRepo;
	
	public User saveUser(User user) {
		return userRepo.save(user);
	}
	
}
