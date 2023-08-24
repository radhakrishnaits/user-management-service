package com.wu.usermanagement.service;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Optional;

import javax.validation.Valid;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.wu.usermanagement.common.ApplicationException;
import com.wu.usermanagement.common.Constants;
import com.wu.usermanagement.dto.CardDto;
import com.wu.usermanagement.entity.Card;
import com.wu.usermanagement.entity.Users;
import com.wu.usermanagement.model.Message;
import com.wu.usermanagement.model.SignUpRequest;
import com.wu.usermanagement.model.SignUpResponse;
import com.wu.usermanagement.repository.UsersRepository;

import lombok.extern.slf4j.Slf4j;

/**
 * The Class UserService.
 */
@Service

/** The Constant log. */

/** The Constant log. */
@Slf4j
public class SignUpUserService extends CommonService {

	/** The users repository. */
	@Autowired
	private UsersRepository usersRepository;

	/** The message source. */
	@Autowired
	private MessageSource messageSource;

	/** The model mapper. */
	@Autowired
	private ModelMapper modelMapper;

	public SignUpResponse registerUser(@Valid SignUpRequest signUpRequest) {

		Users users = modelMapper.map(signUpRequest, Users.class);
		users.setCreatedBy("SYSTEM");
		users.setCreatedOn(new Date().toString());
		users.setModifiedBy("SYSTEM");
		users.setModifiedOn(new Date().toString());
		Optional<Users> isUserPresent = usersRepository.getUserByUserName(signUpRequest.getEmail());
		if (isUserPresent.isPresent()) {
			throw new ApplicationException(Constants.DUPLICATE_USER.getStrValue(), signUpRequest.getEmail());
		} else {
			if(signUpRequest.isWishToAddCard()) {
				List<Card> cards=new ArrayList<>();
				for(CardDto cardDto:signUpRequest.getCard() ) {
					Card card=new Card();
					card.setCardNumber(cardDto.getCardNumber());
					card.setCardExpiry(cardDto.getCardExpiry());
					card.setNameOnCard(cardDto.getNameOnCard());
					cards.add(card);
				}
				users.setCards(cards);
			}
			users = usersRepository.save(users);
		}
		log.info(" user " + signUpRequest.getFirstName() + " successfully register into database ..");
		return createResponse();
	}

	/**
	 * Creates the response.
	 *
	 * @return the sign up response
	 */
	@Override
	public SignUpResponse createResponse() {

		SignUpResponse signUpResponse = new SignUpResponse();
		signUpResponse.setStatus(HttpStatus.CREATED.value());
		signUpResponse.setMessage(new Message(Constants.SUCCESS.getStrValue(),
				messageSource.getMessage(Constants.USER_REGISTER_SUCCES.getStrValue(), null, Locale.ENGLISH)));
		return signUpResponse;
	}
}
