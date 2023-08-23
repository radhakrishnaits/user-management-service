package com.wu.usermanagement.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.wu.usermanagement.common.ApplicationException;
import com.wu.usermanagement.entity.Transactions;
import com.wu.usermanagement.entity.Users;
import com.wu.usermanagement.model.Message;
import com.wu.usermanagement.model.TransactionHistoryResponse;
import com.wu.usermanagement.repository.TransactionsRepository;
import com.wu.usermanagement.repository.UsersRepository;

@Service
public class TransactionsService extends CommonService{

	@Autowired
	private UsersRepository userRepository;
	
	@Autowired
	private TransactionsRepository transactionsRepository;
	
	private TransactionHistoryResponse transactionHistoryResponse;
	
	private List<Transactions> transactions;

	public TransactionHistoryResponse getAllTransactionByUser(String userName) {
		
		Users user=userRepository.getUserByUserName(userName);
		if(user!=null) {
			 transactions=transactionsRepository.getAllTransactionByUserId(user.getUserId());
		}else {
			throw new ApplicationException("U123", "User Not Found");
		}
	     if(transactions!=null&&transactions.isEmpty()) {
	    	 throw new ApplicationException("T123", "No Records Exists");
	     }
		
		return createResponse();
	}
	
	
	@Override
	public TransactionHistoryResponse createResponse() {
		transactionHistoryResponse=new TransactionHistoryResponse();
		transactionHistoryResponse.setTransactions(transactions);
		transactionHistoryResponse.setStatus(HttpStatus.OK.name());
		transactionHistoryResponse.setMessage(new Message("200", "SUCCESS"));
		return transactionHistoryResponse;
	}
}
