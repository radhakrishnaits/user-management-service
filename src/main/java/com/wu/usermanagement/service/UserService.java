package com.wu.usermanagement.service;

import java.util.List;
import java.util.Optional;

import com.wu.usermanagement.common.ApplicationException;
import com.wu.usermanagement.dto.UserDto;
import com.wu.usermanagement.model.Message;
import com.wu.usermanagement.model.SignUpResponse;
import com.wu.usermanagement.model.TransactionHistoryResponse;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.wu.usermanagement.entity.Users;
import com.wu.usermanagement.repository.UsersRepository;

@Service
@Slf4j
public class UserService extends CommonService {
	
	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	private ModelMapper modelMapper;

	private Users user;

	public List<Users> findAll() {
		List<Users> users=usersRepository.findAll();
		
		/*
		 * List<UserDto> listUserDtos = users.stream() .map(usr -> new
		 * UserDto(usr.getUserId(), usr.getUserName())) .collect(Collectors.toList());
		 */
		return users;
	}
	public SignUpResponse registerUser(UserDto userDto) {

		Users users = modelMapper.map(userDto, Users.class);

		Optional<Users> isUserPresent = usersRepository.findById(userDto.getUserId());

		if (isUserPresent.isPresent()) {
			throw new ApplicationException("duplicate user", "User already exists");
		} else {
			user = usersRepository.save(users);
		}

		log.info(" user " + userDto.getFirstName() + " successfully register into database ..");
		return createResponse();
	}

	@Override
	public SignUpResponse createResponse() {

		SignUpResponse signUpResponse=new SignUpResponse();
		signUpResponse.setUserDto(modelMapper.map(user,UserDto.class));
		signUpResponse.setStatus(HttpStatus.OK.name());
		signUpResponse.setMessage(new Message("200", "SUCCESS"));

		return signUpResponse;
	}



}
