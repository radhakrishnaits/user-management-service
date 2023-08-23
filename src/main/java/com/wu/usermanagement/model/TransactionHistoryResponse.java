package com.wu.usermanagement.model;

import java.util.List;

import com.wu.usermanagement.entity.Transactions;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class TransactionHistoryResponse extends BaseResponse{
	
	private List<Transactions> transactions;

}
