package com.cart.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cart.dto.Products;
import com.cart.repo.ProductsRepo;



@Service
@Transactional
public class ProductsService {

	@Autowired
	private ProductsRepo productsRepo;
	
	public List<Products> listAll() {
		return productsRepo.findAll();
	}

	public void save(Products meeting) {
		productsRepo.save(meeting);
	}

	public Products get(long id) {
		return productsRepo.findById(id).get();
	} 
	
	public void delete(long id) {
		productsRepo.deleteById(id);
	}

	public Object getAllProdRec() {
		return productsRepo.getAllProdRec();
	}
	
}
