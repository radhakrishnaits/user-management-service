package com.wu.usermanagement.service;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.wu.usermanagement.common.ApplicationException;
import com.wu.usermanagement.common.BadCredentialException;
import com.wu.usermanagement.common.Constants;
import com.wu.usermanagement.entity.Users;
import com.wu.usermanagement.model.Message;
import com.wu.usermanagement.model.SignInRequest;
import com.wu.usermanagement.model.SignInResponse;
import com.wu.usermanagement.repository.UsersRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * The Class UserService.
 */
@Service

/** The Constant log. */

/** The Constant log. */
@Slf4j
public class SignInUserService extends CommonService {

	/** The users repository. */
	@Autowired
	private UsersRepository usersRepository;

	/** The message source. */
	@Autowired
    private MessageSource messageSource;
	
	private Users user;

	/**
	 * User sign in.
	 *
	 * @param signInRequest the sign in
	 * @return the sign in response
	 */
	public SignInResponse userSignIn(SignInRequest signInRequest) {

	
		log.info("user Name" + signInRequest.getUsername());
		user=usersRepository.getUserByUserName(signInRequest.getUsername()).orElseThrow(() -> new ApplicationException(Constants.USER_NOT_FOUND.getStrValue(), signInRequest.getUsername()));
		log.debug("user sign in started {}..");
		if (!(signInRequest.getUsername().equalsIgnoreCase(user.getEmail())
				&& signInRequest.getPassword().equals(user.getPassword()))) {
			throw new BadCredentialException(Constants.USER_LOGIN_FAIL.getStrValue(), "");

		} 

		log.info(" user " + signInRequest.getUsername() + " validated successfully");
		return createResponse();
	}

	/**
	 * Creates the response.
	 *
	 * @return the sign up response
	 */
	@Override
	public SignInResponse createResponse() {

		SignInResponse signInResponse = new SignInResponse();
		signInResponse.setStatus(HttpStatus.OK.value());
		signInResponse.setMessage(new Message(Constants.SUCCESS.getStrValue(),  messageSource.getMessage(Constants.USER_LOGIN_SUCCES.getStrValue(),
                null, Locale.ENGLISH)));
		signInResponse.setUserName(user.getEmail());
		signInResponse.setFirstName(user.getFirstName());
		signInResponse.setLastName(user.getLastName());
		return signInResponse;
	}
}
