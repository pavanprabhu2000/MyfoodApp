package com.clarivate.foodapp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clarivate.foodapp.dto.Menu;
import com.clarivate.foodapp.repo.MenuRepo;

@Repository
public class MenuDao {
	@Autowired
	MenuRepo menuRepo;
	
	public Menu saveUser(Menu menu) {
		return menuRepo.save(menu);
	}
	
	public  List<Menu> listMenu()
	{
		return menuRepo.findAll();
	}
	
	public Menu getMenuById(int id)
	{
	Optional<Menu> optional = menuRepo.findById(id);
	if(optional.isPresent())
	{
		return optional.get();
	}
	return null;
}
	
	public String delMenu(int id)
	{
	Optional<Menu> optional = menuRepo.findById(id);
	if(optional.isPresent())
	{
		menuRepo.delete(optional.get());
		return "user deleted";
	}
	else {
		return "invalid user";
	}
}
	public Menu updateUser(Menu menu) {
		return menuRepo.save(menu);
				
	}

}
