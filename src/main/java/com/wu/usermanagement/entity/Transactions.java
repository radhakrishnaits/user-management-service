package com.wu.usermanagement.entity;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

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
	private Long recieverId;
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
	@Column(name = "reciiver_payment_method")
	private String recieverPaymentMethod;
	@Column(name = "reciever_account_number")
	private Long recieverAccountNumber;
	@Column(name = "reciever_iban")
	private String recieverIban;
	@Column(name = "txn_type")
	private String txnType;
	@Column(name = "fx_rate")
	private Double fxRate;
	@Column(name = "exchange_fee")
	private Double exchangeFee;
	@Column(name = "reciever_pay_out")
	private Double recieverPayOut;
	@Column(name = "sender_currency")
	private String senderCurrency;
	@Column(name = "reciever_currency")
	private String recieverCurrency;
	@Column(name = "reciever_country_iso")
	private String recieverCountryIso;
	@Column(name = "mtcn")
	private Long mtcn;
	@Column(name = "txn_status")
	private String txnStatus;
	@Column(name = "txn_date")
	private Date txnDate;
	@Column(name = "third_party_ref_id")
	private String thirdPartyRefId;
	@Column(name = "created_by")
	private String createdBy;
	@Column(name = "created_on")
	private Date createdOn;
	@Column(name = "modified_by")
	private String modifiedBy;
	@Column(name = "modified_on")
	private Date modifiedOn;
	@Column(name = "settlement_ref_id")
	private String settlementRefId;
	@Column(name = "txn_settled_on")
	private Date txnSettledOn;
	@Column(name = "refund_reff_txn_id")
	private String refundReffTxnId;
	@Column(name = "remarks")
	private String remarks;

}
