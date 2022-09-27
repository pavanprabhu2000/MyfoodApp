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
import com.clarivate.foodapp.dto.FoodOrder;
import com.clarivate.foodapp.service.FoodOrderService;

@RestController

	public class FoodOrderControl {
		@Autowired
		FoodOrderService FoodOrderService;
		
			
		@RequestMapping("/foodorder")
		public ResponseStructure<FoodOrder> saveFoodOrder(@RequestBody FoodOrder FoodOrder) {
			return FoodOrderService.saveFoodOrder(FoodOrder);
			
		}
		@GetMapping("/foodorder")
		public ResponseStructure<List<FoodOrder>> listFoodOrder() {
			return FoodOrderService.listFoodOrder();
			
		}
		@GetMapping("/foodorder/{id}")
		public ResponseStructure<FoodOrder> getFoodOrderById(@PathVariable int id ) {
			return FoodOrderService.getFoodOrderById(id);
			
		}
		@DeleteMapping("/foodorder/{id}")
		public ResponseStructure<String> delFoodOrder(@PathVariable int id){
			return FoodOrderService.delFoodOrder(id);
		}
		@PutMapping("/foodorder")
		public ResponseStructure<FoodOrder> updateFoodOrder(@RequestBody FoodOrder FoodOrder){
			return FoodOrderService.updateFoodOrder(FoodOrder);
		}

		
	}



