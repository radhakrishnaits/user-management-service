package com.wu.usermanagement.entity;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * The Class Users.
 */
@Entity
@Table(name = "users")

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
public class Users {
	
	/** The user id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "user_id")
	private long userId;

	/** The user title. */
	@Column(name = "user_title")
	private String userTitle;

	/** The first name. */
	@Column(name = "first_name")
	private String firstName;

	/** The last name. */
	@Column(name = "last_name")
	private String lastName;

	/** The dob. */
	@Column(name = "dob")
	private String dob;

	/** The email. */
	@Column(name = "email")
	private String email;

	/** The password. */
	@Column(name = "password")
	private String password;

	/** The user type. */
	@Column(name = "user_type")
	private String userType;

	/** The phone number. */
	@Column(name = "phone_number")
	private Long phoneNumber;

	/** The gender. */
	@Column(name = "gender")
	private String gender;

	/** The nationality. */
	@Column(name = "nationality")
	private String nationality;

	/** The address 1. */
	@Column(name = "address1")
	private String address1;

	/** The city. */
	@Column(name = "city")
	private String city;

	/** The state. */
	@Column(name = "state")
	private String state;
	
	/** The pin. */
	@Column(name = "pin")
	private Long pin;

	/** The country. */
	@Column(name = "country")
	private String country;

	/** The country birth. */
	@Column(name = "country_birth")
	private String countryBirth;

	/** The identification type. */
	@Column(name = "identification_type")
	private String identificationType;

	/** The identification number. */
	@Column(name = "identification_number")
	private String identificationNumber;

	/** The issuing authority. */
	@Column(name = "issuing_authority")
	private String issuingAuthority;

	/** The status. */
	@Column(name = "status")
	private String status;

	/** The created on. */
	@Column(name = "created_on")
	private String createdOn;

	/** The created by. */
	@Column(name = "created_by")
	private String createdBy;

	/** The modified on. */
	@Column(name = "modified_on")
	private String modifiedOn;

	/** The modified by. */
	@Column(name = "modified_by")
	private String modifiedBy;

	/** The cards. */
	//@OneToMany(fetch = FetchType.LAZY, cascade = CascadeType.ALL,mappedBy = "users")
	//private Set<Card> cards;
	
	@OneToMany(targetEntity = Card.class, fetch = FetchType.LAZY, cascade = CascadeType.ALL)
   @JoinColumn(name = "user_id")
	private Set<Card> cards;
	
	

}
