package com.cart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cart.dto.Txnunit;
import com.cart.repo.TxnunitRepo;



@Service
@Transactional
public class TxnunitService {

	@Autowired
	private TxnunitRepo txnunitRepo;
	
	public List<Txnunit> listAll() {
		return txnunitRepo.findAll();
	}

	public void save(Txnunit meeting) {
		txnunitRepo.save(meeting);
	}

	public Txnunit get(long id) {
		return txnunitRepo.findById(id).get();
	} 
	
	public void delete(long id) {
		txnunitRepo.deleteById(id);
	}
	
	public Txnunit getByItemid(int itemid) {
		return txnunitRepo.findByitemid(itemid);
	} 
	
}
