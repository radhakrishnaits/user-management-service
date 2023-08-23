package com.wu.usermanagement.service;

import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.wu.usermanagement.common.ApplicationException;
import com.wu.usermanagement.common.Constants;
import com.wu.usermanagement.entity.Transactions;
import com.wu.usermanagement.entity.Users;
import com.wu.usermanagement.model.Message;
import com.wu.usermanagement.model.TransactionHistoryResponse;
import com.wu.usermanagement.repository.TransactionsRepository;
import com.wu.usermanagement.repository.UsersRepository;

/**
 * The Class TransactionsService.
 */
@Service
public class TransactionsHistoryService extends CommonService{

	/** The user repository. */
	@Autowired
	private UsersRepository usersRepository;
	
	/** The transactions repository. */
	@Autowired
	private TransactionsRepository transactionsRepository;
	
	/** The transaction history response. */
	private TransactionHistoryResponse transactionHistoryResponse;
	
	/** The transactions. */
	private List<Transactions> transactions;
	
	/** The message source. */
	@Autowired
    private MessageSource messageSource;

	/**
	 * View transaction history by user name.
	 *
	 * @param userName the user name
	 * @return the transaction history response
	 */
	public TransactionHistoryResponse viewTransactionHistoryByUserName(String userName) {
		
		Users user=usersRepository.getUserByUserName(userName).orElseThrow(() -> new ApplicationException(Constants.USER_NOT_FOUND.getStrValue(), userName));
		transactions=transactionsRepository.getAllTransactionByUserId(user.getUserId());
		if(transactions!=null&&transactions.isEmpty()) {
	    	 throw new ApplicationException(Constants.NO_RECORDS_EXISTS.getStrValue(), userName);
	     }
		return createResponse();
	}
	

	
	/**
	 * Creates the response.
	 *
	 * @return the transaction history response
	 */
	@Override
	public TransactionHistoryResponse createResponse() {
		transactionHistoryResponse=new TransactionHistoryResponse();
		transactionHistoryResponse.setTransactions(transactions);
		transactionHistoryResponse.setStatus(HttpStatus.OK.value());
		transactionHistoryResponse.setMessage(new Message(Constants.SUCCESS.getStrValue(),  messageSource.getMessage(Constants.SUCCESS_MESSAGE.getStrValue(),
                null, Locale.ENGLISH)));
		return transactionHistoryResponse;
	}
}
