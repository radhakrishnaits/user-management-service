package com.wu.usermanagement.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignInResponse extends BaseResponse{
	
	private String userName;
	private String firstName;
	private String lastName;
}
