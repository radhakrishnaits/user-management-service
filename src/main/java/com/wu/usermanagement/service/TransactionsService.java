package com.wu.usermanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wu.usermanagement.entity.Transactions;
import com.wu.usermanagement.entity.Users;
import com.wu.usermanagement.repository.TransactionsRepository;
import com.wu.usermanagement.repository.UsersRepository;

@Service
public class TransactionsService {

	@Autowired
	private UsersRepository userRepository;
	
	@Autowired
	private TransactionsRepository transactionsRepository;

	public List<Transactions> getAllTransactionByUser(String userName) {
		
		Users user=userRepository.getUserByUserName(userName);
		
	    List<Transactions> transactions=transactionsRepository.getAllTransactionByUserId(user.getUserId());
		
		return transactions;
	}
}
