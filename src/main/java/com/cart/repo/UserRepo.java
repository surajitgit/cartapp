package com.cart.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cart.dto.User;

public interface UserRepo extends JpaRepository<User, Long> {

	public User findByUserid(String userid);
}