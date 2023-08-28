package com.wu.usermanagement.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Column;

/**
 * Gets the nick name.
 *
 * @return the nick name
 */
@Getter

/**
 * Sets the nick name.
 *
 * @param nickName the new nick name
 */
@Setter
public class AddBeneficiaryRequest extends BaseRequest{
	    
    	/** The first name. */
    	private String firstName;
	    
    	/** The last name. */
    	private String lastName;
	    
    	/** The country. */
    	private String country;
	    
    	/** The bank account number. */
    	private String bankAccountNumber;
	    
    	/** The iban. */
    	private String iban;
	    
    	/** The nick name. */
    	private String nickName;

		/** The mobile number. */
		private String mobileNumber;
}
