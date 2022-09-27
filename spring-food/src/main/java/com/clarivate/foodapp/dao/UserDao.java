package com.clarivate.foodapp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;

import org.springframework.stereotype.Repository;

import com.clarivate.foodapp.repo.UserRepo;
import com.clarivate.foodapp.dto.User;
@Repository
public class UserDao {
	@Autowired
	UserRepo userRepo;
	
	public User saveUser(User user) {
		return userRepo.save(user);
	}
	
	public  List<User> listUser()
	{
		return userRepo.findAll();
	}
	
	public User getUserById(int id)
	{
	Optional<User> optional = userRepo.findById(id);
	if(optional.isPresent())
	{
		return optional.get();
	}
	return null;
}
	
	public String delUser(int id)
	{
	Optional<User> optional = userRepo.findById(id);
	if(optional.isPresent())
	{
		userRepo.delete(optional.get());
		return "user deleted";
	}
	else {
		return "invalid user";
	}
}
	public User updateUser(User user) {
		return userRepo.save(user);
				
	}
	
}