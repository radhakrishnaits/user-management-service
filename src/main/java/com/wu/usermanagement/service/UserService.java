package com.wu.usermanagement.service;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.wu.usermanagement.dto.UserDto;
import com.wu.usermanagement.entity.User;
import com.wu.usermanagement.repository.UserRepository;

@Service
public class UserService {
	
	@Autowired
	private UserRepository userRepository;

	public List<UserDto> findAll() {
		List<User> users=userRepository.findAll();
		
		 List<UserDto> listUserDtos = users.stream()
                 .map(usr -> new UserDto(usr.getUserId(), usr.getUserName()))
                 .collect(Collectors.toList());
		
		return listUserDtos;
	}

}
