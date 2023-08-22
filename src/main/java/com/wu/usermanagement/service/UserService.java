package com.wu.usermanagement.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wu.usermanagement.dto.UserDto;
import com.wu.usermanagement.entity.Users;
import com.wu.usermanagement.repository.UsersRepository;

@Service
public class UserService {
	
	@Autowired
	private UsersRepository usersRepository;

	public List<Users> findAll() {
		List<Users> users=usersRepository.findAll();
		
		/*
		 * List<UserDto> listUserDtos = users.stream() .map(usr -> new
		 * UserDto(usr.getUserId(), usr.getUserName())) .collect(Collectors.toList());
		 */
		return users;
	}

}
