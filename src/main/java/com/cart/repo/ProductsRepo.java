package com.cart.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.cart.dto.Products;

public interface ProductsRepo extends JpaRepository<Products, Long> {
	
	@Query(value = "SELECT po.id, po.name, um.price, tu.currunit, um.maxunit FROM products po JOIN unitmaster um ON po.id = um.id JOIN txnunit tu ON po.id=tu.itemid WHERE po.name='Laptop'", nativeQuery = true)
	public Object getAllProdRec();

}