package com.wu.usermanagement.model;

import com.wu.usermanagement.dto.UserDto;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
public class SignUpResponse extends BaseResponse{
    private UserDto userDto;
}
