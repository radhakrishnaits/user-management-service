package com.wu.usermanagement.dto;

import javax.persistence.Column;

import lombok.Getter;
import lombok.Setter;

/**
 * The Class Users.
 */
/**
 * Gets the cards.
 *
 * @return the cards
 */
@Getter

/**
 * Sets the cards.
 *
 * @param cards the new cards
 */
@Setter
public class UsersDto {
	

	/** The user title. */
	private String userTitle;

	/** The first name. */
	private String firstName;

	/** The last name. */
	private String lastName;

	/** The dob. */
	private String dob;

	/** The email. */
	private String email;

	/** The phone number. */
	@Column(name = "phone_number")
	private Long phoneNumber;

	/** The gender. */
	private String gender;

	/** The nationality. */
	private String nationality;

	/** The address 1. */
	private String address1;

	/** The city. */
	private String city;

	/** The state. */
	private String state;
	
	/** The pin. */
	private Long pin;

	/** The country. */
	private String country;

	/** The country birth. */
	private String countryBirth;

	/** The identification type. */
	private String identificationType;

	/** The identification number. */
	private String identificationNumber;

	/** The issuing authority. */
	private String issuingAuthority;



}
