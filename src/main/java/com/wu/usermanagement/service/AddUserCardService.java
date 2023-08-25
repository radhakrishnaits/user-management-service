package com.wu.usermanagement.service;

import java.util.List;
import java.util.Locale;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.wu.usermanagement.common.ApplicationException;
import com.wu.usermanagement.common.Constants;
import com.wu.usermanagement.entity.UserCards;
import com.wu.usermanagement.entity.Users;
import com.wu.usermanagement.model.AddUserCardRequest;
import com.wu.usermanagement.model.AddUserCardResponse;
import com.wu.usermanagement.model.Message;
import com.wu.usermanagement.repository.UserardRepository;
import com.wu.usermanagement.repository.UsersRepository;

/**
 * The Class AddUserCardService.
 */
@Service
public class AddUserCardService extends CommonService {

	/** The card repository. */
	@Autowired
	private UserardRepository cardRepository;
	
	/** The users repository. */
	@Autowired
	private UsersRepository usersRepository;
	
	/** The add card response. */
	private AddUserCardResponse addCardResponse;

	/** The message source. */
	@Autowired
	private MessageSource messageSource;

	/**
	 * Adds the user card.
	 *
	 * @param userName the user name
	 * @param addUserCardRequest the add user card request
	 * @return the adds the user card response
	 */
	public AddUserCardResponse addUserCard(String userName, AddUserCardRequest addUserCardRequest) {

		Users user = usersRepository.getUserByUserName(userName)
				.orElseThrow(() -> new ApplicationException(Constants.USER_NOT_FOUND.getStrValue(), userName));
		List<UserCards> userCards = cardRepository.getUserCards(user.getUserId());
		List<UserCards> userCardsCheck = userCards.stream()
				.filter(card -> card.getCardNumber() == addUserCardRequest.getCardNumber())
				.collect(Collectors.toList());
		if (userCardsCheck != null && userCardsCheck.size() > 0) {
			throw new ApplicationException(Constants.USER_CARD_ALREADY_EXISTS.getStrValue(),
					addUserCardRequest.getCardNumber().toString());
		} else {
			UserCards userCard = new UserCards();
			userCard.setCardNumber(addUserCardRequest.getCardNumber());
			userCard.setCardExpiry(addUserCardRequest.getCardExpiry());
			userCard.setNameOnCard(addUserCardRequest.getNameOnCard());
			userCard.setStatus(Constants.ACTIVE_STATUS.getStrValue());
			userCard.setUserId(user.getUserId());
			userCard.setUsers(user);
			cardRepository.save(userCard);
		}
		return createResponse();
	}

	/**
	 * Creates the response.
	 *
	 * @return the adds the user card response
	 */
	public AddUserCardResponse createResponse() {
		addCardResponse = new AddUserCardResponse();
		addCardResponse.setStatus(HttpStatus.OK.value());
		addCardResponse.setMessage(new Message(Constants.SUCCESS.getStrValue(),
				messageSource.getMessage(Constants.USER_CARD_ADDED_SUCCESS.getStrValue(), null, Locale.ENGLISH)));
		return addCardResponse;
	}
}