package com.wu.usermanagement.dto;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

import javax.validation.constraints.Email;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;


@Getter
@Setter
@NoArgsConstructor
@ToString
public class UserDto {
    @NotNull
	private long userId;
	@NotNull
	private String userTitle;
	@NotNull
	private String firstName;
	@NotNull
	private String lastName;
	@NotNull
	private String dob;
	@NotNull
	@Email
	private String email;
	@NotNull
	@NotEmpty

	private String password;
	private String userType;
	@NotNull
	@Not
	private Long phoneNumber;
	@NotNull
	private String gender;
	@NotNull
	private String nationality;
	@NotNull
	private String address1;
	@NotNull
	private String city;
	@NotNull
	private String state;
	@NotNull
	private Long pin;
	@NotNull
	private String country;
	@NotNull
	private String countryBirth;
	@NotNull
	private String identificationType;
	@NotNull
	private String identificationNumber;
	@NotNull
	private String issuingAuthority;
	@NotNull
	private String status;
	private String createdOn;
	private String createdBy;
	private String modifiedOn;
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
