package com.wu.usermanagement.service;

import java.util.Locale;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.wu.usermanagement.common.ApplicationException;
import com.wu.usermanagement.common.Constants;
import com.wu.usermanagement.entity.Users;
import com.wu.usermanagement.model.Message;
import com.wu.usermanagement.model.UpdateUserRequest;
import com.wu.usermanagement.model.UpdateUserResponse;
import com.wu.usermanagement.repository.UsersRepository;

@Service
public class UpdateUserService extends CommonService {
    @Autowired
    private UsersRepository usersRepository;
    @Autowired
    private MessageSource messageSource;
    private static final String EMAIL_REGEX = "^[A-Za-z0-9+_.-]+@(.+)$";
    private static final Pattern EMAIL_PATTERN = Pattern.compile(EMAIL_REGEX);

    public UpdateUserResponse updateUserInfo(String userName , UpdateUserRequest updateUserRequest) {
    	Users user = usersRepository.getUserByUserName(userName).orElseThrow(() -> new ApplicationException(Constants.USER_NOT_FOUND.getStrValue(), userName));
    	 user.setUserTitle(updateUserRequest.getUserTitle());
        user.setFirstName(updateUserRequest.getFirstName());
        user.setLastName(updateUserRequest.getLastName());
        user.setDob(updateUserRequest.getDob());
        user.setPassword(updateUserRequest.getPassword());
        user.setPhoneNumber(updateUserRequest.getPhoneNumber());
        user.setGender(updateUserRequest.getGender());
        user.setNationality(updateUserRequest.getNationality());
        user.setAddress1(updateUserRequest.getAddress1());
        user.setCity(updateUserRequest.getCity());
        user.setState(updateUserRequest.getState());
        user.setPin(updateUserRequest.getPin());
        user.setCountry(updateUserRequest.getCountry());
        user.setCountryBirth(updateUserRequest.getCountryBirth());
        user.setIdentificationType(updateUserRequest.getIdentificationType());
        user.setIdentificationNumber(updateUserRequest.getIdentificationNumber());
        user.setIssuingAuthority(updateUserRequest.getIssuingAuthority());
        usersRepository.save(user);
        return createResponse();
    }
    public static boolean isValidEmail(String email) {
        Matcher matcher = EMAIL_PATTERN.matcher(email);
        return matcher.matches();
    }
    @Override
    public UpdateUserResponse createResponse() {
        UpdateUserResponse updateUserResponse;
        updateUserResponse = new UpdateUserResponse();
        updateUserResponse.setStatus(HttpStatus.OK.value());
        updateUserResponse.setMessage(new Message(Constants.SUCCESS_MESSAGE.getStrValue(),  messageSource.getMessage(Constants.USER_MODIFIED.getStrValue(),
                null, Locale.ENGLISH)));
        return updateUserResponse;
    }
}
