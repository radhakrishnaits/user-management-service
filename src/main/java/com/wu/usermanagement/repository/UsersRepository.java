package com.wu.usermanagement.repository;

import com.wu.usermanagement.entity.Users;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

/**
 * The Interface UsersRepository.
 */
public interface UsersRepository extends JpaRepository<Users,Long>{
	
	/**
	 * Gets the all users.
	 *
	 * @return the all users
	 */
	@Query("FROM Users")
	public List<Users>  getAllUsers();

	/**
	 * Gets the user by user name.
	 *
	 * @param userName the user name
	 * @return the user by user name
	 */
	@Query("FROM Users u WHERE u.email=:userName")
	public Optional<Users> getUserByUserName(@Param("userName") String  userName);

}
