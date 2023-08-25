package com.wu.usermanagement.dto;

import lombok.Getter;
import lombok.Setter;

/**
 * Sets the nick name.
 *
 * @param nickName the new nick name
 */
@Setter

/**
 * Gets the nick name.
 *
 * @return the nick name
 */
@Getter
public class BeneficiaryDto {
    
    /** The first name. */
    private String firstName;
    
    /** The last name. */
    private String lastName;
    
    /** The country. */
    private String country;
    
    /** The bank account number. */
    private int bankAccountNumber;
    
    /** The iban. */
    private String iban;
    
    /** The nick name. */
    private String nickName;
}
