package com.clarivate.foodapp.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.clarivate.foodapp.dto.User;

@Repository
public interface UserRepo extends JpaRepository<User, Integer> {

}
