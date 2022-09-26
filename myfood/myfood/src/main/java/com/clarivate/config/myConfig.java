package com.clarivate.config;

import javax.sql.DataSource;

import org.springframework.beans.factory.annotation.Configurable;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.DriverManagerDataSource;

@Configurable
@ComponentScan(basePackages = "com.clarivate")
public class myConfig {
	
	@Bean
	public DataSource getDriverManagDataSource() {
		String url = "jdbc:mysql://localhost:3306/foodv1";
		String username = "root";
		String password = "root";

		return new DriverManagerDataSource(url, username, password);
	}

	@Bean
	public JdbcTemplate geJdbcTemplate() {
		return new JdbcTemplate(getDriverManagDataSource());
	}

}
