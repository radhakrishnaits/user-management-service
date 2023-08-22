package com.wu.usermanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import com.wu.usermanagement.entity.Transactions;
public interface TransactionsRepository extends JpaRepository<Transactions,Long>{
	
	@Query("FROM Transactions t WHERE t.senderId=:userId")
	public List<Transactions>  getAllTransactionByUserId( @Param("userId") Long userId);

}
