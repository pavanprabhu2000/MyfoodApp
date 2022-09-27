package com.clarivate.foodapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clarivate.foodapp.dto.FoodOrder;

public interface FoodOrderRepo extends JpaRepository<FoodOrder, Integer>{

}
