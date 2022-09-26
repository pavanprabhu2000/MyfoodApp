package com.clarivate.entity.dao;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.stereotype.Component;

import com.clarivate.entity.dto.foodProduct;

@Component
public class MenuDao {
	@Autowired
	JdbcTemplate jdbcTemplate;
	
	public void viewTable() {
		jdbcTemplate.update("insert into product values(1,'Bmw','m3')");
	
	
	
	}
	
	

}
