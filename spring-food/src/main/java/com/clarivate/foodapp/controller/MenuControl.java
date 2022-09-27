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

import com.clarivate.foodapp.dto.Menu;
import com.clarivate.foodapp.dto.ResponseStructure;
import com.clarivate.foodapp.service.MenuService;

@RestController
public class MenuControl {
	@Autowired
	MenuService menuService;



	@RequestMapping("/menu")
	public ResponseStructure<Menu> saveMenu(@RequestBody Menu menu) {
		return menuService.saveMenu(menu);

	}

	@GetMapping("/menu")
	public ResponseStructure<List<Menu>> listMenu() {
		return menuService.listMenu();

	}

	@GetMapping("/menu/{id}")
	public ResponseStructure<Menu> getMenuById(@PathVariable int id) {
		return menuService.getMenuById(id);

	}

	@DeleteMapping("/menu/{id}")
	public ResponseStructure<String> delMenu(@PathVariable int id) {
		return menuService.delMenu(id);
	}

	@PutMapping("/menu")
	public ResponseStructure<Menu> updateMenu(@RequestBody Menu menu) {
		return menuService.updateMenu(menu);
	}

}
