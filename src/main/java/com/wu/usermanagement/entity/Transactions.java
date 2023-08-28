package com.wu.usermanagement.entity;


import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "transactions")
@Getter
@Setter
public class Transactions {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "txn_id")
	private String txnId;
	@Column(name = "sender_id")
	private Long senderId;
	@Column(name = "reciever_id")
	private Long receiverId;
	@Column(name = "txn_amount")
	private Double txnAmount;
	@Column(name = "sender_payment_method")
	private String senderPaymentMethod;
	@Column(name = "sender_card_number")
	private Long senderCardNumber;
	@Column(name = "sender_card_expiry")
	private String senderCardExpiry;
	@Column(name = "sender_name_on_card")
	private String senderNameOnCard;
	@Column(name = "receiver_payment_method")
	private String receiverPaymentMethod;
	@Column(name = "receiver_account_number")
	private Long receiverAccountNumber;
	@Column(name = "receiver_iban")
	private String receiverIban;
	@Column(name = "txn_type")
	private String txnType;
	@Column(name = "fx_rate")
	private Double fxRate;
	@Column(name = "exchange_fee")
	private Double exchangeFee;
	@Column(name = "receiver_pay_out")
	private Double receiverPayOut;
	@Column(name = "sender_currency")
	private String senderCurrency;
	@Column(name = "receiver_currency")
	private String receiverCurrency;
	@Column(name = "receiver_country_iso")
	private String receiverCountryIso;
	@Column(name = "mtcn")
	private Long mtcn;
	@Column(name = "txn_status")
	private String txnStatus;
	@Column(name = "txn_date")
	private String txnDate;
	@Column(name = "third_party_ref_id")
	private String thirdPartyRefId;
	@Column(name = "created_by")
	private String createdBy;
	@Column(name = "created_on")
	private String createdOn;
	@Column(name = "modified_by")
	private String modifiedBy;
	@Column(name = "modified_on")
	private String modifiedOn;
	@Column(name = "settlement_ref_id")
	private String settlementRefId;
	@Column(name = "txn_settled_on")
	private String txnSettledOn;
	@Column(name = "refund_reff_txn_id")
	private String refundReffTxnId;
	@Column(name = "remarks")
	private String remarks;

}
