package com.wu.usermanagement.entity;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import javax.persistence.*;

/**
 * The Class Beneficiary.
 */
@Entity
@Table(name = "user_beneficiary")

/**
 * Sets the modified on.
 *
 * @param modifiedOn the new modified on
 */
@Setter

/**
 * Gets the modified on.
 *
 * @return the modified on
 */
@Getter

/**
 * Instantiates a new beneficiary.
 */
@NoArgsConstructor

/**
 * Instantiates a new beneficiary.
 *
 * @param beneficiaryId the beneficiary id
 * @param userId the user id
 * @param firstName the first name
 * @param lastName the last name
 * @param country the country
 * @param bankAccountNumber the bank account number
 * @param iban the iban
 * @param nickName the nick name
 * @param status the status
 * @param modifiedBy the modified by
 * @param modifiedOn the modified on
 */
@AllArgsConstructor
public class Beneficiary {
    
    /** The beneficiary id. */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "beneficiary_id")
    private Long beneficiaryId;
    
    /** The user id. */
    @Column(name = "user_id")
    private Long userId;
    
    /** The first name. */
    @Column(name = "first_name")
    private String firstName;
    
    /** The last name. */
    @Column(name = "last_name")
    private String lastName;
    
    /** The country. */
    @Column(name = "country")
    private String country;
    
    /** The bank account number. */
    @Column(name = "bank_account_number")
    private String bankAccountNumber;
    
    /** The iban. */
    @Column(name = "iban")
    private String iban;
    
    /** The nick name. */
    @Column(name = "nick_name")
    private String nickName;

    /** The mobile number. */
    @Column(name = "mobile_number")
    private String mobileNumber;
    
    /** The status. */
    @Column(name = "status")
    private String status;
    
    /** The modified by. */
    @Column(name = "modified_by")
    private String modifiedBy;
    
    /** The modified on. */
    @Column(name = "modified_on")
    private String modifiedOn;
}
