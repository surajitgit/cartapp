package com.cart.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.cart.dto.Txnrecord;

public interface TxnrecordRepo extends JpaRepository<Txnrecord, Long> {

}