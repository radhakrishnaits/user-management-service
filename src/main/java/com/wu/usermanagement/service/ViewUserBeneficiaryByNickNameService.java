package com.wu.usermanagement.service;

import com.wu.usermanagement.common.ApplicationException;
import com.wu.usermanagement.common.Constants;
import com.wu.usermanagement.dto.BeneficiaryDto;
import com.wu.usermanagement.entity.Beneficiary;
import com.wu.usermanagement.entity.Users;
import com.wu.usermanagement.model.Message;
import com.wu.usermanagement.model.ViewUserBeneficiaryByNickNameResponse;
import com.wu.usermanagement.model.ViewUserBeneficiaryResponse;
import com.wu.usermanagement.repository.BeneficiaryRepository;
import com.wu.usermanagement.repository.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

/**
 * The Class AddUserBeneficiaryService.
 */
@Service
public class ViewUserBeneficiaryByNickNameService extends CommonService {

	/** The beneficiary repository. */
	@Autowired
	private BeneficiaryRepository beneficiaryRepository;

	/** The users repository. */
	@Autowired
	private UsersRepository usersRepository;

	/** The beneficiary response. */
	ViewUserBeneficiaryByNickNameResponse beneficiaryByNickNameResponse;
	
	/** The beneficiary. */
	Beneficiary beneficiary;
	
	/** The message source. */
	@Autowired
	private MessageSource messageSource;

	
	 /** The beneficiary dtos. */
 	private BeneficiaryDto beneficiaryDto;
	
	/**
	 * Adds the user beneficiary.
	 *
	 * @param userName the user name
	 * @return the adds the beneficiary response
	 */
	public ViewUserBeneficiaryByNickNameResponse viewUserBeneficiaryByNickName(String userName, String nickName) {
		
		Users user = usersRepository.getUserByUserName(userName)
				.orElseThrow(() -> new ApplicationException(Constants.USER_NOT_FOUND.getStrValue(), userName));
		beneficiary = beneficiaryRepository.getUserBeneficiaryByNickName(user.getUserId(), nickName);
		if(beneficiary==null) {
			throw new ApplicationException(Constants.NO_RECORDS_EXISTS.getStrValue(), userName);
		}
		beneficiaryDto=new BeneficiaryDto();
		beneficiaryDto.setNickName(beneficiary.getNickName());
		beneficiaryDto.setFirstName(beneficiary.getFirstName());
		beneficiaryDto.setLastName(beneficiary.getLastName());
		beneficiaryDto.setCountry(beneficiary.getCountry());
		beneficiaryDto.setBankAccountNumber(beneficiary.getBankAccountNumber());
		beneficiaryDto.setIban(beneficiary.getIban());
		
		return createResponse();
	}

	/**
	 * Creates the response.
	 *
	 * @return the adds the beneficiary response
	 */
	public ViewUserBeneficiaryByNickNameResponse createResponse() {
		beneficiaryByNickNameResponse = new ViewUserBeneficiaryByNickNameResponse();
		beneficiaryByNickNameResponse.setStatus(HttpStatus.OK.value());
		beneficiaryByNickNameResponse.setBeneficiary(beneficiaryDto);
		beneficiaryByNickNameResponse.setMessage(new Message(Constants.SUCCESS.getStrValue(),
				messageSource.getMessage(Constants.SUCCESS_MESSAGE.getStrValue(), null, Locale.ENGLISH)));
		return beneficiaryByNickNameResponse;
	}

}
