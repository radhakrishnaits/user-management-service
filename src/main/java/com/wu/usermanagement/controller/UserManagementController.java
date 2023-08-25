package com.wu.usermanagement.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.wu.usermanagement.model.AddBeneficiaryRequest;
import com.wu.usermanagement.model.AddBeneficiaryResponse;
import com.wu.usermanagement.model.AddUserCardRequest;
import com.wu.usermanagement.model.AddUserCardResponse;
import com.wu.usermanagement.model.DeleteBeneficiaryResponse;
import com.wu.usermanagement.model.DeleteUserCardResponse;
import com.wu.usermanagement.model.SignInRequest;
import com.wu.usermanagement.model.SignInResponse;
import com.wu.usermanagement.model.SignOutRequest;
import com.wu.usermanagement.model.SignOutResponse;
import com.wu.usermanagement.model.SignUpRequest;
import com.wu.usermanagement.model.SignUpResponse;
import com.wu.usermanagement.model.TransactionHistoryResponse;
import com.wu.usermanagement.model.UpdateBeneficiaryRequest;
import com.wu.usermanagement.model.UpdateBeneficiaryResponse;
import com.wu.usermanagement.model.UpdateUserRequest;
import com.wu.usermanagement.model.UpdateUserResponse;
import com.wu.usermanagement.model.ViewUserBeneficiaryResponse;
import com.wu.usermanagement.model.ViewUserCardsResponse;
import com.wu.usermanagement.model.ViewUserResponse;
import com.wu.usermanagement.service.AddUserBeneficiaryService;
import com.wu.usermanagement.service.AddUserCardService;
import com.wu.usermanagement.service.DeleteUserBeneficiaryService;
import com.wu.usermanagement.service.DeleteUserCardService;
import com.wu.usermanagement.service.SignInUserService;
import com.wu.usermanagement.service.SignOutUserService;
import com.wu.usermanagement.service.SignUpUserService;
import com.wu.usermanagement.service.TransactionsHistoryService;
import com.wu.usermanagement.service.UpdateUserBeneficiaryService;
import com.wu.usermanagement.service.UpdateUserService;
import com.wu.usermanagement.service.ViewUserBeneficiaryService;
import com.wu.usermanagement.service.ViewUserCardsService;
import com.wu.usermanagement.service.ViewUserService;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;

/**
 * The Class UserManagementController.
 */
@Tag(name = "user-management", description = "user-management APIs")
@RestController
@RequestMapping("/user-management/v1")

/** The Constant log. */

/** The Constant log. */

/** The Constant log. */
@Slf4j
public class UserManagementController {

	/** The transactions service. */
	@Autowired
	private TransactionsHistoryService transactionsHistoryService;

	/** The sign in user service. */
	@Autowired
	private SignInUserService signInUserService;

	/** The sign out user service. */
	@Autowired
	private SignOutUserService signOutUserService;

	/** The sign up user service. */
	@Autowired
	private SignUpUserService signUpUserService;

	/** The view user service. */
	@Autowired
	private ViewUserService viewUserService;

	/** The update user service. */
	@Autowired
	private UpdateUserService updateUserService;

	/** The add user beneficiary service. */
	@Autowired
	private AddUserBeneficiaryService addUserBeneficiaryService;

	/** The user beneficiary service. */
	@Autowired
	private UpdateUserBeneficiaryService userBeneficiaryService;

	/** The delete user beneficiary service. */
	@Autowired
	private DeleteUserBeneficiaryService deleteUserBeneficiaryService;

	/** The view user beneficiary service. */
	@Autowired
	private ViewUserBeneficiaryService viewUserBeneficiaryService;

	/** The add user card service. */
	@Autowired
	private AddUserCardService addUserCardService;

	/** The delete user card service. */
	@Autowired
	private DeleteUserCardService deleteUserCardService;

	@Autowired
	private ViewUserCardsService viewUserCardsService;

	/**
	 * Login user.
	 *
	 * @param signInRequest the sign in request
	 * @return based on input it will return success or failure response
	 */
	@Operation(summary = "Sign in by user_Id", description = "sign in validation", tags = { "signInUser",
			"valid user get successful login" })
	@ApiResponses({ @ApiResponse(responseCode = "200", content = {
			@Content(schema = @Schema(implementation = SignInResponse.class), mediaType = "application/json") }),
			@ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
			@ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
	@PostMapping("/signin")
	public SignInResponse signInUser(@Valid @RequestBody SignInRequest signInRequest) {

		log.debug("started user registration {}");
		return signInUserService.userSignIn(signInRequest);
	}

	/**
	 * Sign out user.
	 *
	 * @param signOutRequest the sign out request
	 * @return the sign out response
	 */
	@Operation(summary = "user SignOut", description = "user SignOut", tags = { "user SignOut",
			"valid user successful signout" })
	@ApiResponses({ @ApiResponse(responseCode = "200", content = {
			@Content(schema = @Schema(implementation = SignOutResponse.class), mediaType = "application/json") }),
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
	 * @param signUpRequest the sign up request
	 * @return the user
	 */
	@Operation(summary = "Register user", description = "Register user", tags = { "Register user",
			"valid user successful Registered" })
	@ApiResponses({ @ApiResponse(responseCode = "200", content = {
			@Content(schema = @Schema(implementation = SignUpResponse.class), mediaType = "application/json") }),
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
	@Operation(summary = "viewTransactionHistoryByUserName", description = "viewTransactionHistoryByUserName", tags = {
			"viewTransactionHistoryByUserName", "viewTransactionHistoryByUserName" })
	@ApiResponses({ @ApiResponse(responseCode = "200", content = {
			@Content(schema = @Schema(implementation = TransactionHistoryResponse.class), mediaType = "application/json") }),
			@ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
			@ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
	@GetMapping("/users/{userName}/txnhistory")
	public TransactionHistoryResponse viewTransactionHistoryByUserName(@PathVariable String userName) {
		log.debug("started viewTransactionHistoryByUserName {}");
		return transactionsHistoryService.viewTransactionHistoryByUserName(userName);
	}

	/**
	 * View user by user name.
	 *
	 * @param userName the user name
	 * @return the view user response
	 */
	@GetMapping("/users/{userName}")
	public ViewUserResponse viewUserByUserName(@PathVariable String userName) {
		log.debug("started viewUserByUserName {}");
		return viewUserService.getUserByUsername(userName);
	}

	/**
	 * Update user.
	 *
	 * @param userName          the user name
	 * @param updateUserRequest the update user request
	 * @return the update user response
	 */
	@PutMapping("/users/{userName}")
	public UpdateUserResponse updateUser(@PathVariable String userName,
			@RequestBody UpdateUserRequest updateUserRequest) {
		return updateUserService.updateUserInfo(userName, updateUserRequest);
	}

	/**
	 * Adds the user beneficiary.
	 *
	 * @param userName              the user name
	 * @param addBeneficiaryRequest the add beneficiary request
	 * @return the adds the beneficiary response
	 */
	@Operation(summary = "Create new Beneficiary", description = "Create new Beneficiary", tags = {
			"create new Beneficiary", "add new Beneficiary" })
	@ApiResponses({ @ApiResponse(responseCode = "200", content = {
			@Content(schema = @Schema(implementation = AddBeneficiaryResponse.class), mediaType = "application/json") }),
			@ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
			@ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
	@PostMapping("/users/{userName}/beneficiary")
	public AddBeneficiaryResponse addUserBeneficiary(@PathVariable String userName,
			@RequestBody AddBeneficiaryRequest addBeneficiaryRequest) {
		return addUserBeneficiaryService.addUserBeneficiary(userName, addBeneficiaryRequest);
	}

	/**
	 * Update user beneficiary.
	 *
	 * @param userName                 the user name
	 * @param nickName                 the nick name
	 * @param updateBeneficiaryRequest the update beneficiary request
	 * @return the update beneficiary response
	 */
	@Operation(summary = "update Beneficiary", description = "update Beneficiary", tags = { "update Beneficiary",
			"update Beneficiary" })
	@ApiResponses({ @ApiResponse(responseCode = "200", content = {
			@Content(schema = @Schema(implementation = AddBeneficiaryResponse.class), mediaType = "application/json") }),
			@ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
			@ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })

	@PutMapping("/users/{userName}/beneficiary/{nickName}")
	public UpdateBeneficiaryResponse updateUserBeneficiary(@PathVariable String userName, @PathVariable String nickName,
			@RequestBody UpdateBeneficiaryRequest updateBeneficiaryRequest) {
		return userBeneficiaryService.updateUserBeneficiary(userName, nickName, updateBeneficiaryRequest);
	}

	/**
	 * Delete user beneficiary.
	 *
	 * @param userName the user name
	 * @param nickName the nick name
	 * @return the delete beneficiary response
	 */
	@Operation(summary = "delete Beneficiary", description = "delete Beneficiary", tags = { "delete Beneficiary",
			"delete Beneficiary" })
	@ApiResponses({ @ApiResponse(responseCode = "200", content = {
			@Content(schema = @Schema(implementation = DeleteBeneficiaryResponse.class), mediaType = "application/json") }),
			@ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
			@ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
	@DeleteMapping("/users/{userName}/beneficiary/{nickName}")
	public DeleteBeneficiaryResponse deleteUserBeneficiary(@PathVariable String userName,
			@PathVariable String nickName) {
		return deleteUserBeneficiaryService.deleteUserBeneficiary(userName, nickName);
	}

	/**
	 * View user beneficiary response.
	 *
	 * @param userName the user name
	 * @return the view user beneficiary response
	 */
	@Operation(summary = "get All Beneficiary", description = "get All Beneficiary", tags = { "BeneficiaryList",
			"List out all Beneficiary data" })
	@ApiResponses({ @ApiResponse(responseCode = "200", content = {
			@Content(schema = @Schema(implementation = ViewUserBeneficiaryResponse.class), mediaType = "application/json") }),
			@ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
			@ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
	@GetMapping("/users/{userName}/beneficiary")
	public ViewUserBeneficiaryResponse viewUserBeneficiary(@PathVariable String userName) {
		return viewUserBeneficiaryService.viewUserBeneficiary(userName);
	}

	/**
	 * Adds the user card.
	 *
	 * @param userName           the user name
	 * @param addUserCardRequest the add user card request
	 * @return the adds the user card response
	 */
	@Operation(summary = "save card based on user wishlist", description = "save card based on user wishlist", tags = {
			"save Card details", "save card based on user wishlist" })
	@ApiResponses({ @ApiResponse(responseCode = "200", content = {
			@Content(schema = @Schema(implementation = AddUserCardResponse.class), mediaType = "application/json") }),
			@ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
			@ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })

	@PostMapping("/users/{userName}/cards")
	public AddUserCardResponse addUserCard(@PathVariable String userName,
			@RequestBody AddUserCardRequest addUserCardRequest) {
		return addUserCardService.addUserCard(userName, addUserCardRequest);
	}

	/**
	 * Delete user card.
	 *
	 * @param userName   the user name
	 * @param cardNumber the card number
	 * @return the delete user card response
	 */
	@Operation(summary = "delete card details", description = "delete card details", tags = { "delete card details",
			"delete card details" })
	@ApiResponses({
			@ApiResponse(responseCode = "200", content = {
					@Content(schema = @Schema(implementation = String.class), mediaType = "application/json") }),
			@ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
			@ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
	@DeleteMapping("/users/{userName}/cards")
	public DeleteUserCardResponse deleteUserCard(@PathVariable String userName, @PathVariable Long cardNumber) {
		return deleteUserCardService.deleteUserCard(userName, cardNumber);
	}

	@Operation(summary = "get All User Cards", description = "get All user cards", tags = { "getallusercard",
			"List out all user cards" })
	@ApiResponses({ @ApiResponse(responseCode = "200", content = {
			@Content(schema = @Schema(implementation = ViewUserBeneficiaryResponse.class), mediaType = "application/json") }),
			@ApiResponse(responseCode = "404", content = { @Content(schema = @Schema()) }),
			@ApiResponse(responseCode = "500", content = { @Content(schema = @Schema()) }) })
	@GetMapping("/users/{userName}/cards")
	public ViewUserCardsResponse viewUserCards(@PathVariable String userName) {
		return viewUserCardsService.viewUserCards(userName);
	}
}
