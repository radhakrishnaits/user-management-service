package com.wu.usermanagement.model;

import lombok.Getter;
import lombok.Setter;

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
    	private Integer bankAccountNumber;
	    
    	/** The iban. */
    	private String iban;
	    
    	/** The nick name. */
    	private String nickName;

}
