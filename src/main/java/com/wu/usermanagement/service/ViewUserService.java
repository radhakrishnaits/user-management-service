package com.wu.usermanagement.service;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Locale;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.wu.usermanagement.common.ApplicationException;
import com.wu.usermanagement.common.Constants;
import com.wu.usermanagement.dto.UserCardsDto;
import com.wu.usermanagement.dto.UsersDto;
import com.wu.usermanagement.entity.UserCards;
import com.wu.usermanagement.entity.Users;
import com.wu.usermanagement.model.Message;
import com.wu.usermanagement.model.ViewUserResponse;
import com.wu.usermanagement.repository.UsersRepository;


/**
 * The Class ViewUserService.
 */
@Service
public class ViewUserService {

    /** The users repository. */
    @Autowired
    private UsersRepository usersRepository;
    
    /** The message source. */
    @Autowired
    private MessageSource messageSource;

    /** The view user response. */
    private  ViewUserResponse viewUserResponse;
    
    /**
     * Gets the user by username.
     *
     * @param userName the user name
     * @return the user by username
     */
    public ViewUserResponse getUserByUsername(String userName) {
    	 viewUserResponse = new ViewUserResponse();
    	Users user = usersRepository.getUserByUserName(userName).orElseThrow(() -> new ApplicationException(Constants.USER_NOT_FOUND.getStrValue(), userName));
        populateUserDeatsils(user);
        return createResponse();
    }

    /**
     * Populate user deatsils.
     *
     * @param user the user
     * @return the users dto
     */
    private void populateUserDeatsils(Users user) {
		UsersDto usersDto=new UsersDto();
		usersDto.setUserTitle(user.getUserTitle());
		usersDto.setFirstName(user.getFirstName());
		usersDto.setLastName(user.getLastName());
		usersDto.setDob(user.getDob());
		usersDto.setEmail(user.getEmail());
		usersDto.setPhoneNumber(user.getPhoneNumber());
		usersDto.setGender(user.getGender());
		usersDto.setNationality(user.getNationality());
		usersDto.setAddress1(user.getAddress1());
		usersDto.setCity(user.getCity());
		usersDto.setState(user.getState());
		usersDto.setCountry(user.getCountry());
		usersDto.setCountryBirth(user.getCountryBirth());
		usersDto.setNationality(user.getNationality());
		usersDto.setIdentificationType(user.getIdentificationType());
		usersDto.setIdentificationNumber(user.getIdentificationNumber());
		usersDto.setIssuingAuthority(user.getIssuingAuthority());
		usersDto.setPin(user.getPin());
		viewUserResponse.setUserDetails(usersDto);
		Set<UserCards> userCards=user.getCards();
		Iterator<UserCards> namesIterator = userCards.iterator();
		List<UserCardsDto> userCardsList=new ArrayList<>();
		while (namesIterator.hasNext()) {
			UserCardsDto userCardsDto = new UserCardsDto();
			UserCards userCard = namesIterator.next();
			if (userCard.getStatus().equalsIgnoreCase(Constants.ACTIVE_STATUS.getStrValue())) {
				userCardsDto.setCardNumber(userCard.getCardNumber());
				userCardsDto.setCardExpiry(userCard.getCardExpiry());
				userCardsDto.setNameOnCard(userCard.getNameOnCard());
			}
			userCardsList.add(userCardsDto);
		}
		viewUserResponse.setUserCardDetails(userCardsList);
	}

	/**
	 * Creates the response.
	 *
	 * @return the view user response
	 */
	public ViewUserResponse createResponse() {

       
        viewUserResponse.setStatus(HttpStatus.OK.value());
        viewUserResponse.setMessage(new Message(Constants.SUCCESS.name(),  messageSource.getMessage(Constants.SUCCESS_MESSAGE.getStrValue(),
                null, Locale.ENGLISH)));
       
        return viewUserResponse;
    }
}
