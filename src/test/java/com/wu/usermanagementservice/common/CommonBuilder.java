package com.wu.usermanagementservice.common;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import com.wu.usermanagement.entity.Beneficiary;
import com.wu.usermanagement.entity.Transactions;
import com.wu.usermanagement.entity.UserCards;
import com.wu.usermanagement.entity.Users;

public class CommonBuilder {

	public static Transactions getTransactions() {
		Transactions transactions = new Transactions();
		transactions.setTxnId("SM123234");
		transactions.setSenderId(1l);
		transactions.setReceiverId(1l);
		transactions.setMtcn(313213l);
		transactions.setTxnType("SendMoney");
		transactions.setCreatedBy("SYSTEM");
		transactions.setTxnStatus("TS");
		transactions.setCreatedOn(new Date().toString());
		return transactions;
	}

	public static List<Transactions> getTransactionsList() {
		List<Transactions> transactionsList = new ArrayList<>();
		transactionsList.add(getTransactions());
		return transactionsList;
	}

	public static Users getUsers() {
			Users users = new Users();
			users.setUserId(1l);
			users.setUserTitle("Mr.");
			users.setUserType("SUBSCRIBER");
			users.setStatus("Y");
			users.setAddress1("TPR ROAD");
			users.setCreatedBy("SYSTEM");
			users.setCreatedOn(new Date().toString());
			users.setCity("Bangalore");
			users.setCards(getUsersCardList());
			users.setCountry("USA");
			users.setCountryBirth("USA");
			users.setDob("20/08/1999");
			users.setEmail("abcd@abcd.com");
			users.setFirstName("Ram");
			users.setLastName("Kumar");
			users.setGender("Male");
			users.setIdentificationNumber("A12133");
			users.setIdentificationType("PASSPORT");
			users.setIssuingAuthority("Govt Of India");
			users.setNationality("Indian");
			users.setPassword("Passord");
			users.setPhoneNumber(98888888888l);
			users.setPin(636366l);
			users.setState("KA");
			users.setStatus("Y");
		return users;
	}

	public static UserCards getUsersCard() {
		UserCards userCard = new UserCards();
		userCard.setCardId(13234323);
		userCard.setCardNumber(4321432143214321l);
		userCard.setCardExpiry("08/2026");
		userCard.setStatus("Y");
		userCard.setNameOnCard("TPR RAO");
		userCard.setModifiedBy("SYSTEM");
		userCard.setModifiedOn(new Date().toString());
		userCard.setUserId(1l);
		return userCard;
	}

	public static Set<UserCards> getUsersCardList() {
		Set<UserCards> usersCards = new HashSet<>();
		usersCards.add(getUsersCard());
		return usersCards;
	}
	
	
	public static Beneficiary getUserBeneFiciary() {
		Beneficiary beneficiary = new Beneficiary();
		beneficiary.setBeneficiaryId(1l);
		beneficiary.setBankAccountNumber("4321432143214321");
		beneficiary.setCountry("IN");
		beneficiary.setFirstName("Raja");
		beneficiary.setLastName("Ram");
		beneficiary.setModifiedBy("SYSTEM");
		beneficiary.setModifiedOn(new Date().toString());
		beneficiary.setMobileNumber("98888887777");
		beneficiary.setNickName("RRR");
		beneficiary.setStatus("Y");
		beneficiary.setUserId(1l);
		beneficiary.setIban("IDFC334");
		return beneficiary;
	}

}
