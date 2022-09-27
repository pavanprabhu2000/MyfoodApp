package com.clarivate.foodapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clarivate.foodapp.dto.Item;

public interface ItemRepo extends JpaRepository<Item, Integer>{

}
