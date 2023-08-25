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
import com.wu.usermanagement.model.DeleteUserCardResponse;
import com.wu.usermanagement.model.Message;
import com.wu.usermanagement.repository.UserardRepository;
import com.wu.usermanagement.repository.UsersRepository;

/**
 * The Class AddUserCardService.
 */
@Service
public class DeleteUserCardService extends CommonService {

	/** The card repository. */
	@Autowired
	private UserardRepository cardRepository;
	
	/** The users repository. */
	@Autowired
	private UsersRepository usersRepository;
	
	/** The add card response. */
	private DeleteUserCardResponse deleteCardResponse;

	/** The message source. */
	@Autowired
	private MessageSource messageSource;

	/**
	 * Adds the user card.
	 *
	 * @param userName the user name
	 * @param cardNumber the card number
	 * @return the adds the user card response
	 */
	public DeleteUserCardResponse deleteUserCard(String userName, Long cardNumber) {

		Users user = usersRepository.getUserByUserName(userName)
				.orElseThrow(() -> new ApplicationException(Constants.USER_NOT_FOUND.getStrValue(), userName));
		List<UserCards> userCards = cardRepository.getUserCards(user.getUserId());
		List<UserCards> userCardsCheck = userCards.stream()
				.filter(card -> card.getCardNumber() == cardNumber)
				.collect(Collectors.toList());
		
		if (userCardsCheck != null && userCardsCheck.size() > 0) {
			UserCards userCard=userCardsCheck.get(0);userCard.setStatus(Constants.INACTIVE_STATUS.getStrValue());
			cardRepository.save(userCard);
			
		} else {
			throw new ApplicationException(Constants.CARD_NOT_FOUND_MESSAGE.getStrValue(),
					cardNumber.toString());
		}
		return createResponse();
	}

	/**
	 * Creates the response.
	 *
	 * @return the adds the user card response
	 */
	public DeleteUserCardResponse createResponse() {
		deleteCardResponse = new DeleteUserCardResponse();
		deleteCardResponse.setStatus(HttpStatus.NO_CONTENT.value());
		deleteCardResponse.setMessage(new Message(Constants.SUCCESS.getStrValue(),
				messageSource.getMessage(Constants.USER_CARD_DELETED_SUCCESS.getStrValue(), null, Locale.ENGLISH)));
		return deleteCardResponse;
	}
}