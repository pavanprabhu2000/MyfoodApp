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

import com.clarivate.foodapp.dto.ResponseStructure;
import com.clarivate.foodapp.dto.FoodProduct;
import com.clarivate.foodapp.service.FoodProductService;

@RestController



public class FoodProductControl {
	
		@Autowired
		FoodProductService FoodProductService;
		
	
		
		@RequestMapping("/FoodProduct")
		public ResponseStructure<FoodProduct> saveFoodProduct(@RequestBody FoodProduct FoodProduct) {
			return FoodProductService.saveFoodProduct(FoodProduct);
			
		}
		@GetMapping("/FoodProduct")
		public ResponseStructure<List<FoodProduct>> listFoodProduct() {
			return FoodProductService.listFoodProduct();
			
		}
		@GetMapping("/FoodProduct/{id}")
		public ResponseStructure<FoodProduct> getFoodProductById(@PathVariable int id ) {
			return FoodProductService.getFoodProductById(id);
			
		}
		@DeleteMapping("/FoodProduct/{id}")
		public ResponseStructure<String> delFoodProduct(@PathVariable int id){
			return FoodProductService.delFoodProduct(id);
		}
		@PutMapping("/FoodProduct")
		public ResponseStructure<FoodProduct> updateFoodProduct(@RequestBody FoodProduct FoodProduct){
			return FoodProductService.updateFoodProduct(FoodProduct);
		}

		
	}



