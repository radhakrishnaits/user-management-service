package com.wu.usermanagement.service;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.wu.usermanagement.common.ApplicationException;
import com.wu.usermanagement.common.Constants;
import com.wu.usermanagement.dto.UsersDto;
import com.wu.usermanagement.entity.Users;
import com.wu.usermanagement.model.Message;
import com.wu.usermanagement.model.ViewUserResponse;
import com.wu.usermanagement.repository.UsersRepository;


@Service
public class ViewUserService {

    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private MessageSource messageSource;

    private  ViewUserResponse viewUserResponse;
    public ViewUserResponse getUserByUsername(String userName) {
    	 viewUserResponse = new ViewUserResponse();
    	Users user = usersRepository.getUserByUserName(userName).orElseThrow(() -> new ApplicationException(Constants.USER_NOT_FOUND.getStrValue(), userName));
        UsersDto usersDto=populateUserDeatsils(user);
        viewUserResponse.setUserDetails(usersDto);
        return createResponse();
    }

    private UsersDto populateUserDeatsils(Users user) {
		UsersDto usersDto=new UsersDto();
		usersDto.setUserTitle(user.getUserTitle());
		usersDto.setFirstName(user.getFirstName());
		usersDto.setLastName(user.getLastName());
		usersDto.setDob(user.getDob());
		usersDto.setEmail(user.getEmail());
		usersDto.setPhoneNumber(user.getPhoneNumber());
		usersDto.setGender(user.getGender());
		usersDto.setNationality(user.getNationality());
		usersDto.setAddress1(user.getAddress1());
		usersDto.setCity(user.getCity());
		usersDto.setState(user.getState());
		usersDto.setCountry(user.getCountry());
		usersDto.setCountryBirth(user.getCountryBirth());
		usersDto.setNationality(user.getNationality());
		usersDto.setIdentificationType(user.getIdentificationType());
		usersDto.setIdentificationNumber(user.getIdentificationNumber());
		usersDto.setIssuingAuthority(user.getIssuingAuthority());
		return usersDto;
	}

	public ViewUserResponse createResponse() {

       
        viewUserResponse.setStatus(HttpStatus.OK.value());
        viewUserResponse.setMessage(new Message(Constants.SUCCESS.name(),  messageSource.getMessage(Constants.SUCCESS_MESSAGE.getStrValue(),
                null, Locale.ENGLISH)));
       
        return viewUserResponse;
    }
}
