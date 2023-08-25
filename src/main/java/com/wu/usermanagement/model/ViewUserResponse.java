package com.wu.usermanagement.model;

import java.util.List;

import com.wu.usermanagement.dto.UserCardsDto;
import com.wu.usermanagement.dto.UsersDto;

import lombok.Getter;
import lombok.Setter;

/**
 * Gets the user card details.
 *
 * @return the user card details
 */
@Getter

/**
 * Sets the user card details.
 *
 * @param userCardDetails the new user card details
 */
@Setter
public class ViewUserResponse extends BaseResponse {

	/** The user details. */
	private UsersDto userDetails;
	
	/** The user card details. */
	private List<UserCardsDto> userCardDetails;

}
