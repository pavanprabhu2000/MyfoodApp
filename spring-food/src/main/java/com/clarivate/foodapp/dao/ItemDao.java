package com.clarivate.foodapp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.clarivate.foodapp.dto.Item;

import com.clarivate.foodapp.repo.ItemRepo;
@Repository
public class ItemDao {
	@Autowired
	
	ItemRepo itemRepo;
	

	public Item saveItem(Item item) {
		return itemRepo.save(item);
	}
	
	public  List<Item> listItem()
	{
		return itemRepo.findAll();
	}
	
	public Item getItemById(int id)
	{
	Optional<Item> optional = itemRepo.findById(id);
	if(optional.isPresent())
	{
		return optional.get();
	}
	return null;
}
	
	public String delItem(int id)
	{
	Optional<Item> optional = itemRepo.findById(id);
	if(optional.isPresent())
	{
		itemRepo.delete(optional.get());
		return "user deleted";
	}
	else {
		return "invalid user";
	}
}
	public Item updateUser(Item item) {
		return itemRepo.save(item);
				
	}

}
