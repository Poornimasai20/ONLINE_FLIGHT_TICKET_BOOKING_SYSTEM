package com.airline.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.airline.model.User;
@Repository
public interface UserRepo extends JpaRepository<User, Integer> {
	User findByUserId(int userId);
}
