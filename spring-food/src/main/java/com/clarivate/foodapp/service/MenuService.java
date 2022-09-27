package com.clarivate.foodapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.clarivate.foodapp.dao.MenuDao;
import com.clarivate.foodapp.dto.Menu;
import com.clarivate.foodapp.dto.ResponseStructure;


@Service
public class MenuService {
	@Autowired
	MenuDao menuDao;
	
	public ResponseStructure<Menu> saveMenu(Menu menu) {
		ResponseStructure<Menu> rp = new ResponseStructure<Menu>();
		Menu menu1 = menuDao.saveUser(menu);
		if (menu1 != null) {
			rp.setStatus(HttpStatus.CREATED.value());
			rp.setMsg("person added");
			rp.setData(menu1);
		} else {
			rp.setStatus(HttpStatus.NOT_FOUND.value());
			rp.setMsg("person data missing");
			rp.setData(menu1);

		}
		return rp;
	}

	public ResponseStructure<List<Menu>> listMenu() {
		ResponseStructure<List<Menu>> rp = new ResponseStructure<List<Menu>>();
		List<Menu> list = menuDao.listMenu();

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
	public ResponseStructure<Menu> getMenuById(int id) {
		ResponseStructure<Menu> rp = new ResponseStructure<Menu>();
		Menu u1 = menuDao.getMenuById(id);
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
	public ResponseStructure<String> delMenu(int id) {
		ResponseStructure<String> rp = new ResponseStructure<String>();
		String string = menuDao.delMenu(id);
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
	
	public ResponseStructure<Menu> updateMenu(Menu user) {
		ResponseStructure<Menu> rp = new ResponseStructure<Menu>();
		Menu u1 = menuDao.getMenuById(user.getId());
		if (u1==null) {
			rp.setStatus(HttpStatus.NOT_FOUND.value());
			rp.setMsg("person data missing");
			rp.setData(null);

		} else {
			rp.setStatus(HttpStatus.FOUND.value());
			rp.setMsg("user is present");
			rp.setData(menuDao.updateUser(user));

		}
		return rp;

	}

}
