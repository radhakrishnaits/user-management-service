package com.wu.usermanagementservice.service;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.ArgumentMatchers.anyLong;
import static org.mockito.ArgumentMatchers.anyString;
import static org.mockito.Mockito.verify;
import static org.mockito.Mockito.when;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.context.MessageSource;

import com.wu.usermanagement.common.ApplicationException;
import com.wu.usermanagement.entity.Beneficiary;
import com.wu.usermanagement.entity.Transactions;
import com.wu.usermanagement.entity.Users;
import com.wu.usermanagement.model.TransactionHistoryResponse;
import com.wu.usermanagement.repository.BeneficiaryRepository;
import com.wu.usermanagement.repository.TransactionsRepository;
import com.wu.usermanagement.repository.UsersRepository;
import com.wu.usermanagement.service.TransactionsHistoryService;
import com.wu.usermanagementservice.common.CommonBuilder;

@ExtendWith(MockitoExtension.class)
public class TransactionsServiceTest {

	@Mock
	private TransactionsRepository transactionsRepository;
	@Mock
	private UsersRepository usersRepository;

	@Mock
	private BeneficiaryRepository beneficiaryRepository;

	@Mock
	private MessageSource messageSource;

	@InjectMocks
	private TransactionsHistoryService transactionsHistoryService;

	@Test
	void verifyGetAllTransactionByUserId() {
		// Given
		Optional<Users> users = Optional.of(CommonBuilder.getUsers());
		Optional<Beneficiary> beneficiary = Optional.of(CommonBuilder.getUserBeneFiciary());
		List<Transactions> transactionsList = CommonBuilder.getTransactionsList();
		// When calling the mocked repository method
		when(usersRepository.getUserByUserName(anyString())).thenReturn(users);
		when(beneficiaryRepository.findById(anyLong())).thenReturn(beneficiary);
		when(transactionsRepository.getAllTransactionByUserId(anyLong())).thenReturn(transactionsList);
		TransactionHistoryResponse transactionHistoryResponse = transactionsHistoryService
				.viewTransactionHistoryByUserName(anyString());
		// Then
		assertEquals(transactionsList.size(), transactionHistoryResponse.getTransactions().size());
		verify(this.usersRepository).getUserByUserName("");
		verify(this.beneficiaryRepository).findById(1l);
		verify(this.transactionsRepository).getAllTransactionByUserId(1l);
	}

	@Test
	void verify_Empty_GetAllTransactionByUserId() {
		// Given
		Optional<Users> users = Optional.of(CommonBuilder.getUsers());
		List<Transactions> transactionsList = new ArrayList<>();
		// When calling the mocked repository method
		when(usersRepository.getUserByUserName(anyString())).thenReturn(users);
		when(transactionsRepository.getAllTransactionByUserId(any())).thenReturn(transactionsList);

		// Then
		assertThrows(ApplicationException.class, () -> {
			transactionsHistoryService.viewTransactionHistoryByUserName("");
		});
		verify(this.usersRepository).getUserByUserName("");
		verify(this.transactionsRepository).getAllTransactionByUserId(1l);
	}
	
	@Test
	void verify_Null_GetAllTransactionByUserId() {
		// Given
		Optional<Users> users = Optional.of(CommonBuilder.getUsers());
		// When calling the mocked repository method
		when(usersRepository.getUserByUserName(anyString())).thenReturn(users);
		when(transactionsRepository.getAllTransactionByUserId(any())).thenReturn(null);

		// Then
		assertThrows(ApplicationException.class, () -> {
			transactionsHistoryService.viewTransactionHistoryByUserName("");
		});
		verify(this.usersRepository).getUserByUserName("");
		verify(this.transactionsRepository).getAllTransactionByUserId(1l);
	}

}
