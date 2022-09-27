package com.clarivate.foodapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.clarivate.foodapp.dto.Menu;

public interface MenuRepo extends JpaRepository<Menu, Integer>{

}
