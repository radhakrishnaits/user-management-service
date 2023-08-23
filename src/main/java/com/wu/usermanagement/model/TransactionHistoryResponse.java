package com.wu.usermanagement.model;

import java.util.List;

import com.wu.usermanagement.entity.Transactions;

import lombok.Getter;
import lombok.Setter;

/**
 * Gets the transactions.
 *
 * @return the transactions
 */
@Getter

/**
 * Sets the transactions.
 *
 * @param transactions the new transactions
 */
@Setter
public class TransactionHistoryResponse extends BaseResponse{
	
	/** The transactions. */
	private List<Transactions> transactions;

}
