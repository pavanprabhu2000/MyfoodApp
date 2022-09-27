package com.clarivate.foodapp.service;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.clarivate.foodapp.dao.UserDao;
import com.clarivate.foodapp.dto.User;

@Service
public class UserService {

	UserDao userDao;
	
	public User saveUser(User user) {
		return userDao.saveUser(user);
	}
}
