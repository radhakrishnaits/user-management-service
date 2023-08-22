package com.wu.usermanagement.model;

import java.util.List;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class BaseResponse {
	protected String status;
	protected Message message;
    protected List<Errors> errors;
}
