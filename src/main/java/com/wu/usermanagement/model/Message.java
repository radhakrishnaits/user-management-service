package com.wu.usermanagement.model;

import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class Message {
	private String code;
	private String description;
	public Message(String code, String description) {
		super();
		this.code = code;
		this.description = description;
	}

}
