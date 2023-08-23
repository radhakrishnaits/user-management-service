package com.wu.usermanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wu.usermanagement.entity.Users;
import com.wu.usermanagement.model.TransactionHistoryResponse;
import com.wu.usermanagement.service.TransactionsService;
import com.wu.usermanagement.service.UserService;

@RestController
@RequestMapping("/user-management/v1")
public class UserManagementController {

	@Autowired
	private UserService userService;

	@Autowired
	private TransactionsService transactionsService;

	@GetMapping("/users")
	public List<Users> getAllUsers() {
		List<Users> users = userService.findAll();
		return users;
	}

	@GetMapping("/users/{userName}/txnhistory")
	public TransactionHistoryResponse viewTransactionHistory(@PathVariable String userName) {

		return transactionsService.getAllTransactionByUser(userName);

	}
}
