package com.cart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cart.dto.Unitmaster;
import com.cart.repo.UnitmasterRepo;



@Service
@Transactional
public class UnitmasterService {

	@Autowired
	private UnitmasterRepo unitmasterRepo;
	
	public List<Unitmaster> listAll() {
		return unitmasterRepo.findAll();
	}

	public void save(Unitmaster meeting) {
		unitmasterRepo.save(meeting);
	}

	public Unitmaster get(long id) {
		return unitmasterRepo.findById(id).get();
	} 
	
	public void delete(long id) {
		unitmasterRepo.deleteById(id);
	}
	
}
