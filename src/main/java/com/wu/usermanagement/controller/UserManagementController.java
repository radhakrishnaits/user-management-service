package com.wu.usermanagement.controller;

import java.util.List;

import com.wu.usermanagement.dto.UserDto;
import com.wu.usermanagement.model.Message;
import com.wu.usermanagement.model.SignUpResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import com.wu.usermanagement.entity.Users;
import com.wu.usermanagement.model.TransactionHistoryResponse;
import com.wu.usermanagement.service.TransactionsService;
import com.wu.usermanagement.service.UserService;

import javax.validation.Valid;

@RestController
@RequestMapping("/user-management/v1")
@Slf4j
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

	@PostMapping("/signup")
	public SignUpResponse registerUser(@Valid @RequestBody UserDto signUpRequest) {

		log.debug("started user registration {}");
		return userService.registerUser(signUpRequest);
	}

	@GetMapping("/users/{userName}/txnhistory")
	public TransactionHistoryResponse viewTransactionHistory(@PathVariable String userName) {

		return transactionsService.getAllTransactionByUser(userName);

	}
}
