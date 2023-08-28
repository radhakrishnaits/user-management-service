package com.wu.usermanagement.service;

import java.util.Date;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.wu.usermanagement.common.ApplicationException;
import com.wu.usermanagement.common.Constants;
import com.wu.usermanagement.entity.Beneficiary;
import com.wu.usermanagement.entity.Users;
import com.wu.usermanagement.model.DeleteBeneficiaryResponse;
import com.wu.usermanagement.model.Message;
import com.wu.usermanagement.repository.BeneficiaryRepository;
import com.wu.usermanagement.repository.UsersRepository;

/**
 * The Class AddUserBeneficiaryService.
 */
@Service
public class DeleteUserBeneficiaryService extends CommonService {

	/** The beneficiary repository. */
	@Autowired
	private BeneficiaryRepository beneficiaryRepository;

	/** The users repository. */
	@Autowired
	private UsersRepository usersRepository;

	/** The beneficiary response. */
	DeleteBeneficiaryResponse beneficiaryResponse;
	
	/** The beneficiary. */
	private Beneficiary beneficiary;
	
	/** The message source. */
	@Autowired
	private MessageSource messageSource;

	/**
	 * Adds the user beneficiary.
	 *
	 * @param userName the user name
	 * @param nickName the nick name
	 * @return the adds the beneficiary response
	 */
	public DeleteBeneficiaryResponse deleteUserBeneficiary(String userName, String nickName) {
		
		Users user = usersRepository.getUserByUserName(userName)
				.orElseThrow(() -> new ApplicationException(Constants.USER_NOT_FOUND.getStrValue(), userName));
		beneficiary = beneficiaryRepository.getUserBeneficiaryByNickName(user.getUserId(),nickName);
		if (beneficiary == null) {
			throw new ApplicationException(Constants.USER_BENE_NOT_FOUND.getStrValue(), "nickName");
		} 
		beneficiary.setStatus(Constants.INACTIVE_STATUS.getStrValue());
		beneficiary.setModifiedBy("SYSTEM");
		beneficiary.setModifiedOn(new Date().toString());
		beneficiary = beneficiaryRepository.save(beneficiary);
		return createResponse();
	}

	/**
	 * Creates the response.
	 *
	 * @return the adds the beneficiary response
	 */
	public DeleteBeneficiaryResponse createResponse() {
		beneficiaryResponse = new DeleteBeneficiaryResponse();
	
		beneficiaryResponse.setStatus(HttpStatus.NO_CONTENT.value());
		beneficiaryResponse.setMessage(new Message(Constants.SUCCESS.getStrValue(),
				messageSource.getMessage(Constants.USER_DELETE_BENEFICIARY_SUCCES.getStrValue(), null, Locale.ENGLISH)));
		return beneficiaryResponse;
	}

}
