package com.wu.usermanagement.dto;

import java.util.Date;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserDto {

	private long userId;
	private String userTitle;
	private String firstName;
	private String lastName;
	private String dob;
	private String email;
	private String password;
	private String userType;
	private Long phoneNumber;
	private String gender;
	private String nationality;
	private String address1;
	private String city;
	private String state;
	private Long pin;
	private String country;
	private String countryBirth;
	private String identificationType;
	private String identificationNumber;
	private String issuingAuthority;
	private String status;
	private Date createdOn;
	private String createdBy;
	private Date modifiedOn;
	private String modifiedBy;
	public UserDto(long userId, String userTitle, String firstName, String lastName, String dob, String email,
			String userType, Long phoneNumber, String gender, String nationality, String address1, String city,
			String state, Long pin, String country, String countryBirth, String identificationType,
			String identificationNumber, String issuingAuthority, String status) {
		super();
		this.userId = userId;
		this.userTitle = userTitle;
		this.firstName = firstName;
		this.lastName = lastName;
		this.dob = dob;
		this.email = email;
		this.userType = userType;
		this.phoneNumber = phoneNumber;
		this.gender = gender;
		this.nationality = nationality;
		this.address1 = address1;
		this.city = city;
		this.state = state;
		this.pin = pin;
		this.country = country;
		this.countryBirth = countryBirth;
		this.identificationType = identificationType;
		this.identificationNumber = identificationNumber;
		this.issuingAuthority = issuingAuthority;
		this.status = status;
	}
	
	
	
	

}
