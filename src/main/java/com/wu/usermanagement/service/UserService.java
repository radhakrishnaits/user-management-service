package com.wu.usermanagement.service;

import java.util.List;
import java.util.Optional;

import com.wu.usermanagement.common.ApplicationException;
import com.wu.usermanagement.common.Constants;
import com.wu.usermanagement.dto.SignInDto;
import com.wu.usermanagement.dto.UserDto;
import com.wu.usermanagement.model.Message;
import com.wu.usermanagement.model.SignInResponse;
import com.wu.usermanagement.model.SignUpResponse;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import com.wu.usermanagement.entity.Users;
import com.wu.usermanagement.repository.UsersRepository;

import javax.print.DocFlavor;

@Service
@Slf4j
public class UserService extends CommonService{

	private String DUPLICATE_USER="user.duplicate";
	
	@Autowired
	private UsersRepository usersRepository;

	@Autowired
	private ModelMapper modelMapper;

	private Users user;


	public SignUpResponse registerUser(UserDto userDto) {

		Users users = modelMapper.map(userDto, Users.class);

		Optional<Users> isUserPresent = usersRepository.findById(userDto.getUserId());

		if (isUserPresent.isPresent()) {
			throw new ApplicationException(DUPLICATE_USER,userDto.getEmail());
		} else {
			user = usersRepository.save(users);
		}

		log.info(" user " + userDto.getFirstName() + " successfully register into database ..");
		return createResponse();
	}


	public SignInResponse userSignIn(SignInDto signInDto) {

		SignInResponse signInResponse= new SignInResponse();
		Users users = modelMapper.map(signInDto, Users.class);
        log.info("user Name"+signInDto.getUsername());
		Optional<Users> userByUserName = usersRepository.getUserByUserName(signInDto.getUsername());
        log.debug("user sign in started {}..");
		if(signInDto.getUsername().equalsIgnoreCase(user.getEmail()) &&
				signInDto.getPassword().equals(user.getPassword())) {
			log.debug("user login success ..");
			signInResponse.setMessage(new Message("200", "SUCCESS"));
			signInResponse.setStatus(200);

		} else {
			throw new ApplicationException("Invalid user name and password", "please register and try again");
		}

		log.info(" user " + signInDto.getUsername() + " validated successfully");
		return signInResponse;
	}

	public List<Users> findAll() {
		List<Users> users=usersRepository.findAll();
		
		/*
		 * List<UserDto> listUserDtos = users.stream() .map(usr -> new
		 * UserDto(usr.getUserId(), usr.getUserName())) .collect(Collectors.toList());
		 */
		return users;
	}


	public Users updateUserInfo(Long userId ,Users user) {
		Users userToUpdate = usersRepository.findById(userId).orElse(null);
		if(userToUpdate != null)
		{
			userToUpdate.setFirstName(user.getFirstName());
			userToUpdate.setLastName(user.getLastName());
			userToUpdate.setAddress1(user.getAddress1());
			userToUpdate.setCity(user.getCity());
			userToUpdate.setPassword(user.getPassword());
			usersRepository.save(userToUpdate);
		}
		return userToUpdate;
	}
	public Optional<Users> getUserByUsername(String username) {
		return usersRepository.getUserByUserName(username);
	}

	@Override
	public SignUpResponse createResponse() {

		SignUpResponse signUpResponse=new SignUpResponse();
		signUpResponse.setUserDto(modelMapper.map(user,UserDto.class));
		signUpResponse.setStatus(200);
		signUpResponse.setMessage(new Message("200", "SUCCESS"));

		return signUpResponse;
	}
}
