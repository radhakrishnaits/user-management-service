package com.wu.usermanagement.model;

import lombok.Getter;
import lombok.Setter;

/**
 * Gets the name on card.
 *
 * @return the name on card
 */
@Getter

/**
 * Sets the name on card.
 *
 * @param nameOnCard the new name on card
 */
@Setter
public class AddUserCardRequest extends BaseRequest{

	/** The card number. */
	private Long cardNumber;
	
	/** The card expiry. */
	private String cardExpiry;
	
	/** The name on card. */
	private String nameOnCard;
	
}