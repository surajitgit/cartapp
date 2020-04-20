package com.cart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cart.dto.Txnrecord;
import com.cart.repo.TxnrecordRepo;



@Service
@Transactional
public class TxnrecordService {

	@Autowired
	private TxnrecordRepo txnrecordRepo;
	
	public List<Txnrecord> listAll() {
		return txnrecordRepo.findAll();
	}

	public void save(Txnrecord meeting) {
		txnrecordRepo.save(meeting);
	}

	public Txnrecord get(long id) {
		return txnrecordRepo.findById(id).get();
	} 
	
	public void delete(long id) {
		txnrecordRepo.deleteById(id);
	}
	
}
