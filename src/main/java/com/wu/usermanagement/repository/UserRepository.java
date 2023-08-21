package com.wu.usermanagement.repository;

import com.wu.usermanagement.entity.User;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
public interface UserRepository extends JpaRepository<User,Long>{
	
	@Query("FROM User")
	public List<User>  getAllUsers();

}
