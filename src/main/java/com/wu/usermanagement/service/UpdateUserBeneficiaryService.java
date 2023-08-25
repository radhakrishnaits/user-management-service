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
public class UpdateUserBeneficiaryService extends CommonService {

	/** The beneficiary repository. */
	@Autowired
	private BeneficiaryRepository beneficiaryRepository;

	/** The users repository. */
	@Autowired
	private UsersRepository usersRepository;

	/** The beneficiary response. */
	UpdateBeneficiaryResponse beneficiaryResponse;
	
	/** The beneficiary. */
	Beneficiary beneficiary;
	
	/** The message source. */
	@Autowired
	private MessageSource messageSource;

	/**
	 * Adds the user beneficiary.
	 *
	 * @param userName the user name
	 * @param nickName the nick name
	 * @param updateBeneficiaryRequest the update beneficiary request
	 * @return the adds the beneficiary response
	 */
	public UpdateBeneficiaryResponse updateUserBeneficiary(String userName, String nickName,UpdateBeneficiaryRequest updateBeneficiaryRequest) {
		if (updateBeneficiaryRequest == null) {
			throw new ApplicationException("beneficiary.data.null", "userName");
		}
		Users user = usersRepository.getUserByUserName(userName)
				.orElseThrow(() -> new ApplicationException(Constants.USER_NOT_FOUND.getStrValue(), userName));
		List<Beneficiary> beneficiaries = beneficiaryRepository.getBeneficiaryList(user.getUserId());
		List<Beneficiary> repoBeneficariesCheck = beneficiaries.stream()
				.filter(ben -> ben.getNickName() == nickName)
				.collect(Collectors.toList());
		if (repoBeneficariesCheck != null && repoBeneficariesCheck.size() > 0) {
			beneficiary = repoBeneficariesCheck.get(0);
		} else {
			throw new ApplicationException(Constants.USER_BENE_NOT_FOUND.getStrValue(), "nickName");
		}
		beneficiary.setFirstName(updateBeneficiaryRequest.getFirstName());
		beneficiary.setLastName(updateBeneficiaryRequest.getLastName());
		beneficiary.setCountry(updateBeneficiaryRequest.getCountry());
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
	public UpdateBeneficiaryResponse createResponse() {
		beneficiaryResponse = new UpdateBeneficiaryResponse();
		BeneficiaryDto beneficiaryDto = new BeneficiaryDto();
		beneficiaryDto.setFirstName(beneficiary.getFirstName());
		beneficiaryDto.setLastName(beneficiary.getLastName());
		beneficiaryDto.setCountry(beneficiary.getCountry());
		beneficiaryResponse.setBeneficiaryDto(beneficiaryDto);
		beneficiaryResponse.setStatus(HttpStatus.OK.value());
		beneficiaryResponse.setMessage(new Message(Constants.SUCCESS.getStrValue(),
				messageSource.getMessage(Constants.USER_ADD_BENEFICIARY_SUCCES.getStrValue(), null, Locale.ENGLISH)));
		return beneficiaryResponse;
	}

}
