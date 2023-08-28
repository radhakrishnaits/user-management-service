package com.wu.usermanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import com.wu.usermanagement.dto.TransactionsDto;
import com.wu.usermanagement.entity.Beneficiary;
import com.wu.usermanagement.repository.BeneficiaryRepository;
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

	@Autowired
	BeneficiaryRepository beneficiaryRepository;
	
	/** The transactions repository. */
	@Autowired
	private TransactionsRepository transactionsRepository;
	
	/** The transaction history response. */
	private TransactionHistoryResponse transactionHistoryResponse;
	
	/** The transactions. */
	private List<Transactions> transactions;

	private List<TransactionsDto> transactionsDtos;
	
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
		transactionsDtos = new ArrayList<>();
		for(Transactions transactions1 : transactions){
			TransactionsDto transactionsDto1 = new TransactionsDto();
			Beneficiary beneficiary = beneficiaryRepository.findById((long)transactions1.getReceiverId())
					.orElseThrow(()-> new ApplicationException(Constants.BENEFICIARY_DATA_NOT_FOUND.getStrValue(), null ));
			transactionsDto1.setTxnId(transactions1.getTxnId());
			transactionsDto1.setSenderId(transactions1.getSenderId());
			transactionsDto1.setReceiverId(transactions1.getReceiverId());
			transactionsDto1.setReceiverFirstName(beneficiary.getFirstName());
			transactionsDto1.setReceiverLastName(beneficiary.getLastName());
			transactionsDto1.setTxnAmount(transactions1.getTxnAmount());
			transactionsDto1.setSenderPaymentMethod(transactions1.getSenderPaymentMethod());
			transactionsDto1.setSenderCardNumber(transactions1.getSenderCardNumber());
			transactionsDto1.setSenderCardExpiry(transactions1.getSenderCardExpiry());
			transactionsDto1.setSenderNameOnCard(transactions1.getSenderNameOnCard());
			transactionsDto1.setReceiverPaymentMethod(transactions1.getReceiverPaymentMethod());
			transactionsDto1.setReceiverAccountNumber(transactions1.getReceiverAccountNumber());
			transactionsDto1.setReceiverIban(transactions1.getReceiverIban());
			transactionsDto1.setFxRate(transactions1.getFxRate());
			transactionsDto1.setExchangeFee(transactions1.getExchangeFee());
			transactionsDto1.setReceiverPayOut(transactions1.getReceiverPayOut());
			transactionsDto1.setSenderCurrency(transactions1.getSenderCurrency());
			transactionsDto1.setReceiverCurrency(transactions1.getReceiverCurrency());
			transactionsDto1.setReceiverCountryIso(transactions1.getReceiverCountryIso());
			transactionsDto1.setMtcn(transactions1.getMtcn());
			transactionsDto1.setTxnStatus(transactions1.getTxnStatus());
			transactionsDto1.setTxnDate(transactions1.getTxnDate());
			transactionsDto1.setThirdPartyRefId(transactions1.getThirdPartyRefId());
			transactionsDto1.setCreatedBy(transactions1.getCreatedBy());
			transactionsDto1.setCreatedOn(transactions1.getCreatedOn());
			transactionsDto1.setModifiedBy(transactions1.getModifiedBy());
			transactionsDto1.setModifiedOn(transactions1.getModifiedOn());
			transactionsDto1.setSettlementRefId(transactions1.getSettlementRefId());
			transactionsDto1.setTxnSettledOn(transactions1.getTxnSettledOn());
			transactionsDto1.setRefundReffTxnId(transactions1.getRefundReffTxnId());
			transactionsDto1.setRemarks(transactions1.getRemarks());

			transactionsDtos.add(transactionsDto1);
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
		transactionHistoryResponse.setTransactions(transactionsDtos);
		transactionHistoryResponse.setStatus(HttpStatus.OK.value());
		transactionHistoryResponse.setMessage(new Message(Constants.SUCCESS.getStrValue(),  messageSource.getMessage(Constants.SUCCESS_MESSAGE.getStrValue(),
                null, Locale.ENGLISH)));
		return transactionHistoryResponse;
	}
}
