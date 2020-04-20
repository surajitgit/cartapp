package com.cart.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cart.dto.Txnunit;

public interface TxnunitRepo extends JpaRepository<Txnunit, Long> {

	public Txnunit findByitemid(int itemid);

}