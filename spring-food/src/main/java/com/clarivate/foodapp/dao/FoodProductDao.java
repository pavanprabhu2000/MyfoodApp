package com.clarivate.foodapp.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Repository;

import com.clarivate.foodapp.dto.FoodProduct;
import com.clarivate.foodapp.repo.FoodProductRepo;

@Repository
public class FoodProductDao {

	FoodProductRepo foodProductRepo;

	public FoodProduct saveProduct(FoodProduct foodProduct) {
		return foodProductRepo.save(foodProduct);
	}

	public List<FoodProduct> getAllFoodProductsData() {
		return foodProductRepo.findAll();
	}

	public FoodProduct getByFoodProductId(int id) {
		Optional<FoodProduct> optional = foodProductRepo.findById(id);

		if (optional.isPresent())
			return optional.get();
		else
			return null;
	}
	
	public String deleteFoodProduct(int id) {
		Optional<FoodProduct> optional = foodProductRepo.findById(id);
		
		if(optional.isPresent()) {
			foodProductRepo.delete(optional.get());
			return "Food Product data "+ id +" has been deleted successfully";
		} else {
			return "Food Product with ID:"+ id +" doesn't exist";
		}
	}
	
	public FoodProduct updateFoodProduct(FoodProduct id) {
		
		return foodProductRepo.save(id);

}
}
