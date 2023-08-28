package com.wu.usermanagement.dto;


import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Getter
@Setter
public class TransactionsDto {

	private String txnId;
	private Long senderId;
	private Long receiverId;
	private String receiverFirstName;
	private String receiverLastName;
	private Double txnAmount;
	private String senderPaymentMethod;
	private Long senderCardNumber;
	private String senderCardExpiry;
	private String senderNameOnCard;
	private String receiverPaymentMethod;
	private Long receiverAccountNumber;
	private String receiverIban;
	private String txnType;
	private Double fxRate;
	private Double exchangeFee;
	private Double receiverPayOut;
	private String senderCurrency;
	private String receiverCurrency;
	private String receiverCountryIso;
	private Long mtcn;
	private String txnStatus;
	private String txnDate;
	private String thirdPartyRefId;
	private String createdBy;
	private String createdOn;
	private String modifiedBy;
	private String modifiedOn;
	private String settlementRefId;
	private String txnSettledOn;
	private String refundReffTxnId;
	private String remarks;

}
