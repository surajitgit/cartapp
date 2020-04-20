package com.cart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cart.dto.User;
import com.cart.repo.UserRepo;



@Service
@Transactional
public class UserService {

	@Autowired
	private UserRepo userRepo;
	
	public List<User> listAll() {
		return userRepo.findAll();
	}

	public void save(User meeting) {
		userRepo.save(meeting);
	}

	public User get(long id) {
		return userRepo.findById(id).get();
	} 
	
	public void delete(long id) {
		userRepo.deleteById(id);
	}
	
	public User getByUserId(String username) {
		return userRepo.findByUserid(username);
	}
	
}
