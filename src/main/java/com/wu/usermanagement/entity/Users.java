package com.wu.usermanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
public class Users {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "user_id")
	private long userId;

	@Column(name = "user_title")
	private String userTitle;
	
	@Column(name = "first_name")
	private String firstName;

	@Column(name = "last_name")
	private String lastName;
	
	
	@Column(name = "dob")
	private String  dob;
	
	@Column(name = "email")
	private String email;
	
	@Column(name = "password")
	private String password;
	
	@Column(name = "user_type")
	private String userType;
	
	@Column(name = "phone_number")
	private Long phoneNumber;
	
	@Column(name = "gender")
	private String gender;
	
	@Column(name = "nationality")
	private String nationality;
	
	@Column(name = "address1")
	private String address1;
	
	@Column(name = "city")
	private String city;
	
	@Column(name = "state")
	private String state;
	@Column(name = "pin")
	private Long pin;

	@Column(name = "country")
	private String country;
	
	@Column(name = "country_birth")
	private String countryBirth;
	
	@Column(name = "identification_type")
	private String identificationType;
	
	@Column(name = "identification_number")
	private String identificationNumber;
	
	@Column(name = "issuing_authority")
	private String issuingAuthority;
	
	@Column(name = "status")
	private String status;
	
	@Column(name = "created_on")
	private String  createdOn;
	
	@Column(name = "created_by")
	private String createdBy;
	
	@Column(name = "modified_on")
	private String  modifiedOn;
	
	@Column(name = "modified_by")
	private String modifiedBy;
	

}
