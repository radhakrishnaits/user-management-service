package com.wu.usermanagement.model;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class UpdateUserRequest {
	private String userTitle;
	private String firstName;
	private String lastName;
	private String dob;
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

}
