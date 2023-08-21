package com.wu.usermanagement.dto;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;


@Getter
@Setter
@ToString
public class UserDto {
	private long userId;
	private String userName;
	public UserDto(long userId, String userName) {
		super();
		this.userId = userId;
		this.userName = userName;
	}

	

}
