package com.wu.usermanagement.model;

import com.wu.usermanagement.dto.UsersDto;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class ViewUserResponse extends BaseResponse{
	
	private UsersDto userDetails;
	
	
}
