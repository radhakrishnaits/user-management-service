package com.wu.usermanagement.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

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
}
