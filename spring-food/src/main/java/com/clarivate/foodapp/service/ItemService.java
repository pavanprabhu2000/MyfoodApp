package com.clarivate.foodapp.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.clarivate.foodapp.dao.ItemDao;
import com.clarivate.foodapp.dto.Item;
import com.clarivate.foodapp.dto.ResponseStructure;

@Service
public class ItemService {
	@Autowired
	ItemDao itemDao;
	

	public ResponseStructure<Item> saveItem(Item menu) {
		ResponseStructure<Item> rp = new ResponseStructure<Item>();
		Item menu1 = itemDao.saveItem(menu);
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

	public ResponseStructure<List<Item>> listItem() {
		ResponseStructure<List<Item>> rp = new ResponseStructure<List<Item>>();
		List<Item> list = itemDao.listItem();

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
	public ResponseStructure<Item> getItemById(int id) {
		ResponseStructure<Item> rp = new ResponseStructure<Item>();
		Item u1 = itemDao.getItemById(id);
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
	public ResponseStructure<String> delItem(int id) {
		ResponseStructure<String> rp = new ResponseStructure<String>();
		String string = itemDao.delItem(id);
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
	
	public ResponseStructure<Item> updateItem(Item item) {
		ResponseStructure<Item> rp = new ResponseStructure<Item>();
		Item u1 = itemDao.getItemById(item.getId());
		if (u1==null) {
			rp.setStatus(HttpStatus.NOT_FOUND.value());
			rp.setMsg("person data missing");
			rp.setData(null);

		} else {
			rp.setStatus(HttpStatus.FOUND.value());
			rp.setMsg("user is present");
			rp.setData(itemDao.updateUser(item));

		}
		return rp;

	}


}
