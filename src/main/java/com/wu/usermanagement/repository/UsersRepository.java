package com.wu.usermanagement.repository;

import com.wu.usermanagement.entity.Users;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
public interface UsersRepository extends JpaRepository<Users,Long>{
	
	@Query("FROM Users")
	public List<Users>  getAllUsers();

	@Query("FROM Users u WHERE u.email=:userName")
	public Users getUserByUserName(@Param("userName") String  userName);

}
