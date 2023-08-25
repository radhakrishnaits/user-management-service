package com.wu.usermanagement.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.wu.usermanagement.common.ApplicationException;
import com.wu.usermanagement.common.Constants;
import com.wu.usermanagement.dto.UserCardsDto;
import com.wu.usermanagement.entity.UserCards;
import com.wu.usermanagement.entity.Users;
import com.wu.usermanagement.model.Message;
import com.wu.usermanagement.model.ViewUserCardsResponse;
import com.wu.usermanagement.repository.UserCardsRepository;
import com.wu.usermanagement.repository.UsersRepository;

/**
 * The Class AddUserBeneficiaryService.
 */
@Service
public class ViewUserCardsService extends CommonService {

	/** The users repository. */
	@Autowired
	private UsersRepository usersRepository;

	/** The message source. */
	@Autowired
	private MessageSource messageSource;

	/** The user cards repository. */
	@Autowired
	private UserCardsRepository userCardsRepository;
	
	/** The user cards dtos. */
	private List<UserCardsDto> userCardsDtos;

	/** The view user cards response. */
	private ViewUserCardsResponse viewUserCardsResponse;

	/**
	 * Adds the user beneficiary.
	 *
	 * @param userName the user name
	 * @return the adds the beneficiary response
	 */
	public ViewUserCardsResponse viewUserCards(String userName) {

		Users user = usersRepository.getUserByUserName(userName)
				.orElseThrow(() -> new ApplicationException(Constants.USER_NOT_FOUND.getStrValue(), userName));
		List<UserCards> userCards = userCardsRepository.getUserCards(user.getUserId());
		if (userCards == null) {
			throw new ApplicationException(Constants.NO_RECORDS_EXISTS.getStrValue(), userName);
		}
		userCardsDtos = new ArrayList<>();

		for (UserCards userCard : userCards) {
			UserCardsDto userCardsDto = new UserCardsDto();
			userCardsDto.setCardNumber(userCard.getCardNumber());
			userCardsDto.setCardExpiry(userCard.getCardExpiry());
			userCardsDto.setNameOnCard(userCard.getNameOnCard());

			userCardsDtos.add(userCardsDto);
		}

		return createResponse();
	}

	/**
	 * Creates the response.
	 *
	 * @return the adds the beneficiary response
	 */
	public ViewUserCardsResponse createResponse() {
		viewUserCardsResponse = new ViewUserCardsResponse();
		viewUserCardsResponse.setStatus(HttpStatus.OK.value());
		viewUserCardsResponse.setUserCards(userCardsDtos);
		viewUserCardsResponse.setMessage(new Message(Constants.SUCCESS.getStrValue(),
				messageSource.getMessage(Constants.SUCCESS_MESSAGE.getStrValue(), null, Locale.ENGLISH)));
		return viewUserCardsResponse;
	}

}
