package com.clarivate.foodapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clarivate.foodapp.dto.FoodProduct;

public interface FoodProductRepo extends JpaRepository<FoodProduct, Integer>{

}
