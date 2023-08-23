package com.wu.usermanagement.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wu.usermanagement.entity.Users;
import com.wu.usermanagement.model.TransactionHistoryResponse;
import com.wu.usermanagement.service.TransactionsHistoryService;
import com.wu.usermanagement.service.UserService;

/**
 * The Class UserManagementController.
 */
@RestController
@RequestMapping("/user-management/v1")
public class UserManagementController {

	/** The user service. */
	@Autowired
	private UserService userService;

	/** The transactions service. */
	@Autowired
	private TransactionsHistoryService transactionsHistoryService;

	/**
	 * Gets the all users.
	 *
	 * @return the all users
	 */
	@GetMapping("/users")
	public List<Users> getAllUsers() {
		List<Users> users = userService.findAll();
		return users;
	}

	/**
	 * View transaction history.
	 *
	 * @param userName the user name
	 * @return the transaction history response
	 */
	@GetMapping("/users/{userName}/txnhistory")
	public TransactionHistoryResponse viewTransactionHistoryByUserName(@PathVariable String userName) {
		return transactionsHistoryService.viewTransactionHistoryByUserName(userName);
	}
}
