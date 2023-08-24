package com.wu.usermanagement.service;

import java.util.Locale;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.wu.usermanagement.common.Constants;
import com.wu.usermanagement.model.Message;
import com.wu.usermanagement.model.SignOutRequest;
import com.wu.usermanagement.model.SignOutResponse;

import lombok.extern.slf4j.Slf4j;

/**
 * The Class UserService.
 */
@Service

/** The Constant log. */

/** The Constant log. */
@Slf4j
public class SignOutUserService extends CommonService {


	/** The message source. */
	@Autowired
    private MessageSource messageSource;



	/**
	 * Creates the response.
	 *
	 * @return the sign up response
	 */
	@Override
	public SignOutResponse createResponse() {

		SignOutResponse signOutResponse = new SignOutResponse();
		signOutResponse.setStatus(HttpStatus.OK.value());
		signOutResponse.setMessage(new Message(Constants.SUCCESS.getStrValue(),  messageSource.getMessage(Constants.USER_LOGOUT_SUCCES.getStrValue(),
                null, Locale.ENGLISH)));
		return signOutResponse;
	}

	public SignOutResponse userSignOut(@Valid SignOutRequest signOutRequest) {
		log.info("Sign out stared" + signOutRequest.getUsername());
		return createResponse();
	}
}
