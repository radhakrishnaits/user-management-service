package com.wu.usermanagement.model;

import java.util.List;

import com.wu.usermanagement.dto.UserCardsDto;

import lombok.Getter;
import lombok.Setter;


@Getter
@Setter
public class SignUpRequest {
	private String userTitle;
	private String firstName;
	private String lastName;
	private String dob;
	private String email;
	private String password;
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
	private String wishToAddCard;
	private List<UserCardsDto> cardDetails;

}
