package com.wu.usermanagement.service;

import com.wu.usermanagement.common.ApplicationException;
import com.wu.usermanagement.common.Constants;
import com.wu.usermanagement.dto.BeneficiaryDto;
import com.wu.usermanagement.entity.Beneficiary;
import com.wu.usermanagement.entity.Users;
import com.wu.usermanagement.model.*;
import com.wu.usermanagement.repository.BeneficiaryRepository;
import com.wu.usermanagement.repository.UsersRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

/**
 * The Class AddUserBeneficiaryService.
 */
@Service
public class AddUserBeneficiaryService extends CommonService {

	/** The beneficiary repository. */
	@Autowired
	private BeneficiaryRepository beneficiaryRepository;

	/** The users repository. */
	@Autowired
	private UsersRepository usersRepository;

	/** The beneficiary response. */
	AddBeneficiaryResponse beneficiaryResponse;
	
	/** The beneficiary. */
	Beneficiary beneficiary;
	
	/** The message source. */
	@Autowired
	private MessageSource messageSource;

	/**
	 * Adds the user beneficiary.
	 *
	 * @param userName the user name
	 * @param addBeneficiaryRequest the add beneficiary request
	 * @return the adds the beneficiary response
	 */
	public AddBeneficiaryResponse addUserBeneficiary(String userName, AddBeneficiaryRequest addBeneficiaryRequest) {
		if (addBeneficiaryRequest == null) {
			throw new ApplicationException("beneficiary.data.not.found", "userName");
		}
		Users user = usersRepository.getUserByUserName(userName.trim())
				.orElseThrow(() -> new ApplicationException(Constants.USER_NOT_FOUND.getStrValue(), userName));
		List<Beneficiary> beneficiaries = beneficiaryRepository.getBeneficiaryList(user.getUserId());
		List<Beneficiary> repoBeneficariesCheck = beneficiaries.stream()
				.filter(ben -> ben.getNickName().equalsIgnoreCase(addBeneficiaryRequest.getNickName()) )
				.collect(Collectors.toList());
		if (repoBeneficariesCheck != null && repoBeneficariesCheck.size() > 0) {
			throw new ApplicationException(Constants.USER_ADD_BENE_NICK_NAME_NOT_UNIQUE.getStrValue(), "nickName");
		}else {
			beneficiary = new Beneficiary();
			beneficiary.setBankAccountNumber(addBeneficiaryRequest.getBankAccountNumber());
			beneficiary.setIban(addBeneficiaryRequest.getIban());
			beneficiary.setUserId(user.getUserId());
			beneficiary.setStatus(Constants.ACTIVE_STATUS.getStrValue());
			beneficiary.setFirstName(addBeneficiaryRequest.getFirstName());
			beneficiary.setLastName(addBeneficiaryRequest.getLastName());
			beneficiary.setFirstName(addBeneficiaryRequest.getFirstName());
			beneficiary.setCountry(addBeneficiaryRequest.getCountry());
			beneficiary.setNickName(addBeneficiaryRequest.getNickName());
			beneficiary.setMobileNumber(addBeneficiaryRequest.getMobileNumber());
			beneficiary.setModifiedBy("SYSTEM");
			beneficiary.setModifiedOn(new Date().toString());
		}
		
		beneficiary = beneficiaryRepository.save(beneficiary);
		return createResponse();
	}

	/**
	 * Creates the response.
	 *
	 * @return the adds the beneficiary response
	 */
	public AddBeneficiaryResponse createResponse() {
		beneficiaryResponse = new AddBeneficiaryResponse();
		BeneficiaryDto beneficiaryDto = new BeneficiaryDto();
		beneficiaryDto.setFirstName(beneficiary.getFirstName());
		beneficiaryDto.setLastName(beneficiary.getLastName());
		beneficiaryDto.setCountry(beneficiary.getCountry());
		beneficiaryDto.setBankAccountNumber(beneficiary.getBankAccountNumber());
		beneficiaryDto.setIban(beneficiary.getIban());
		beneficiaryDto.setNickName(beneficiary.getNickName());
		beneficiaryDto.setMobileNumber(beneficiary.getMobileNumber());
		beneficiaryResponse.setBeneficiary(beneficiaryDto);
		beneficiaryResponse.setStatus(HttpStatus.OK.value());
		beneficiaryResponse.setMessage(new Message(Constants.SUCCESS.getStrValue(),
				messageSource.getMessage(Constants.USER_ADD_BENEFICIARY_SUCCES.getStrValue(), null, Locale.ENGLISH)));
		return beneficiaryResponse;
	}

}
