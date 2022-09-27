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

import com.clarivate.foodapp.dto.Item;
import com.clarivate.foodapp.dto.ResponseStructure;
import com.clarivate.foodapp.service.ItemService;

@RestController
public class ItemControl {
	@Autowired
	ItemService itemService;

	@RequestMapping("/item")
	public ResponseStructure<Item> saveUser(@RequestBody Item item) {
		return itemService.saveItem(item);

	}

	@GetMapping("/item")
	public ResponseStructure<List<Item>> listUser() {
		return itemService.listItem();

	}

	@GetMapping("/item/{id}")
	public ResponseStructure<Item> getUserById(@PathVariable int id) {
		return itemService.getItemById(id);

	}

	@DeleteMapping("/item/{id}")
	public ResponseStructure<String> delUser(@PathVariable int id) {
		return itemService.delItem(id);
	}

	@PutMapping("/item")
	public ResponseStructure<Item> updateUser(@RequestBody Item item) {
		return itemService.updateItem(item);
	}
}
