package com.wu.usermanagement.controller;

import java.util.List;

import com.wu.usermanagement.dto.SignInDto;
import com.wu.usermanagement.dto.UserDto;
import com.wu.usermanagement.model.SignInResponse;
import com.wu.usermanagement.model.SignUpResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.wu.usermanagement.entity.Users;
import com.wu.usermanagement.model.TransactionHistoryResponse;
import com.wu.usermanagement.service.TransactionsHistoryService;
import com.wu.usermanagement.service.UserService;

import javax.validation.Valid;

/**
 * The Class UserManagementController.
 */
@RestController
@RequestMapping("/user-management/v1")
@Slf4j
public class UserManagementController {

	/** The user service. */
	@Autowired
	private UserService userService;

	/** The transactions service. */
	@Autowired
	private TransactionsHistoryService transactionsHistoryService;

	/**
	 * Register users.
	 *
	 * @return the user
	 */
	@PostMapping("/signup")
	public SignUpResponse registerUser(@Valid @RequestBody UserDto signUpRequest) {

		log.debug("started user SignIn {}");
		return userService.registerUser(signUpRequest);
	}


	/**
	 * Login user.
	 *
	 * @return based on input it will return success or failure response
	 */
	@PostMapping("/signin")
	public SignInResponse signInUser(@Valid @RequestBody SignInDto signInDto) {

		log.debug("started user registration {}");
		return userService.userSignIn(signInDto);
	}

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
