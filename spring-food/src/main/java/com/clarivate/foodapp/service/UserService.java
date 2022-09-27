package com.clarivate.foodapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.clarivate.foodapp.dao.UserDao;
import com.clarivate.foodapp.dto.ResponseStructure;
import com.clarivate.foodapp.dto.User;

@Service
public class UserService {
	@Autowired
	UserDao userDao;

	public ResponseStructure<User> saveUser(User user) {
		ResponseStructure<User> rp = new ResponseStructure<User>();
		User user1 = userDao.saveUser(user);
		if (user1 != null) {
			rp.setStatus(HttpStatus.CREATED.value());
			rp.setMsg("person added");
			rp.setData(user1);
		} else {
			rp.setStatus(HttpStatus.NOT_FOUND.value());
			rp.setMsg("person data missing");
			rp.setData(user1);

		}
		return rp;
	}

	public ResponseStructure<List<User>> listUser() {
		ResponseStructure<List<User>> rp = new ResponseStructure<List<User>>();
		List<User> list = userDao.listUser();

		if (list.isEmpty()) {
			rp.setStatus(HttpStatus.NOT_FOUND.value());
			rp.setMsg("person data missing");
			rp.setData(list);

		} else {
			rp.setStatus(HttpStatus.CREATED.value());
			rp.setMsg("person are");
			rp.setData(list);

		}
		return rp;

	}
	public ResponseStructure<User> getUserById(int id) {
		ResponseStructure<User> rp = new ResponseStructure<User>();
		User u1 = userDao.getUserById(id);
		if (u1==null) {
			rp.setStatus(HttpStatus.NOT_FOUND.value());
			rp.setMsg("person data missing");
			rp.setData(u1);

		} else {
			rp.setStatus(HttpStatus.CREATED.value());
			rp.setMsg("person is");
			rp.setData(u1);

		}
		return rp;

	}
	public ResponseStructure<String> delUser(int id) {
		ResponseStructure<String> rp = new ResponseStructure<String>();
		String string = userDao.delUser(id);
		if (string=="invalid user") {
			rp.setStatus(HttpStatus.NOT_FOUND.value());
			rp.setMsg("person data missing");
			rp.setData(string);

		} else {
			rp.setStatus(HttpStatus.CREATED.value());
			rp.setMsg("person is deleted");
			rp.setData(string);

		}
		return rp;

	}
	
	public ResponseStructure<User> updateUser(User user) {
		ResponseStructure<User> rp = new ResponseStructure<User>();
		User u1 = userDao.getUserById(user.getId());
		if (u1==null) {
			rp.setStatus(HttpStatus.NOT_FOUND.value());
			rp.setMsg("person data missing");
			rp.setData(null);

		} else {
			rp.setStatus(HttpStatus.FOUND.value());
			rp.setMsg("user is present");
			rp.setData(userDao.updateUser(user));

		}
		return rp;

	}

	
}
