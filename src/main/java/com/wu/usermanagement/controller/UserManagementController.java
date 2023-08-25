package com.wu.usermanagement.controller;

import javax.validation.Valid;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wu.usermanagement.model.SignInRequest;
import com.wu.usermanagement.model.SignInResponse;
import com.wu.usermanagement.model.SignOutRequest;
import com.wu.usermanagement.model.SignOutResponse;
import com.wu.usermanagement.model.SignUpRequest;
import com.wu.usermanagement.model.SignUpResponse;
import com.wu.usermanagement.model.TransactionHistoryResponse;
import com.wu.usermanagement.service.SignInUserService;
import com.wu.usermanagement.service.SignOutUserService;
import com.wu.usermanagement.service.SignUpUserService;
import com.wu.usermanagement.service.TransactionsHistoryService;

import lombok.extern.slf4j.Slf4j;

/**
 * The Class UserManagementController.
 */
@Tag(name = "user-management", description = "user-management APIs")
@RestController
@RequestMapping("/user-management/v1")
@Slf4j
public class UserManagementController {


	/** The transactions service. */
	@Autowired
	private TransactionsHistoryService transactionsHistoryService;

	@Autowired
	private SignInUserService signInUserService;
	@Autowired
	private SignOutUserService signOutUserService;

	@Autowired
	private SignUpUserService signUpUserService;

	/**
	 * Login user.
	 *
	 * @return based on input it will return success or failure response
	 */
	@Operation(
			summary = "Sign in by user_Id",
			description = "sign in validation",
			tags = { "signInUser", "valid user get successful login" })
	@ApiResponses({
			@ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = SignInResponse.class), mediaType = "application/json") }),
			@ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
			@ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
	@PostMapping("/signin")
	public SignInResponse signInUser(@Valid @RequestBody SignInRequest signInRequest) {

		log.debug("started user registration {}");
		return signInUserService.userSignIn(signInRequest);
	}

	@Operation(
			summary = "user SignOut",
			description = "user SignOut",
			tags = { "user SignOut", "valid user successful signout" })
	@ApiResponses({
			@ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = SignOutResponse.class), mediaType = "application/json") }),
			@ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
			@ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
	@PostMapping("/signout")
	public SignOutResponse signOutUser(@Valid @RequestBody SignOutRequest signOutRequest) {

		log.debug("started user registration {}");
		return signOutUserService.userSignOut(signOutRequest);
	}

	/**
	 * Register users.
	 *
	 * @return the user
	 */
	@Operation(
			summary = "Register user",
			description = "Register user",
			tags = { "Register user", "valid user successful Registered" })
	@ApiResponses({
			@ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = SignUpResponse.class), mediaType = "application/json") }),
			@ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
			@ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
	@PostMapping("/signup")
	public SignUpResponse registerUser(@Valid @RequestBody SignUpRequest signUpRequest) {

		log.debug("started user SignIn {}");
		return signUpUserService.registerUser(signUpRequest);
	}

	

	/**
	 * View transaction history.
	 *
	 * @param userName the user name
	 * @return the transaction history response
	 */
	@Operation(
			summary = "viewTransactionHistoryByUserName",
			description = "viewTransactionHistoryByUserName",
			tags = { "viewTransactionHistoryByUserName", "viewTransactionHistoryByUserName" })
	@ApiResponses({
			@ApiResponse(responseCode = "200", content = { @Content(schema = @Schema(implementation = TransactionHistoryResponse.class), mediaType = "application/json") }),
			@ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
			@ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
	@GetMapping("/users/{userName}/txnhistory")
	public TransactionHistoryResponse viewTransactionHistoryByUserName(@PathVariable String userName) {
		log.debug("started viewTransactionHistoryByUserName {}");
		return transactionsHistoryService.viewTransactionHistoryByUserName(userName);
	}
}
