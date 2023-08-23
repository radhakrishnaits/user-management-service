package com.wu.usermanagement.service;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
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
	
	@Autowired
    private MessageSource messageSource;

	public TransactionHistoryResponse getAllTransactionByUser(String userName) {
		
		Users user=userRepository.getUserByUserName(userName);
		if(user!=null) {
			 transactions=transactionsRepository.getAllTransactionByUserId(user.getUserId());
		}else {
			throw new ApplicationException("user.not.found", userName);
		}
	     if(transactions!=null&&transactions.isEmpty()) {
	    	 throw new ApplicationException("records.not.exists", userName);
	     }
		
		return createResponse();
	}
	
	
	@Override
	public TransactionHistoryResponse createResponse() {
		transactionHistoryResponse=new TransactionHistoryResponse();
		transactionHistoryResponse.setTransactions(transactions);
		transactionHistoryResponse.setStatus(HttpStatus.OK.value());
		transactionHistoryResponse.setMessage(new Message("200",  messageSource.getMessage("api.success",
                null, Locale.ENGLISH)));
		return transactionHistoryResponse;
	}
}
