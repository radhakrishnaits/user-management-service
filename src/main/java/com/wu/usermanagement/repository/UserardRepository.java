package com.wu.usermanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wu.usermanagement.entity.UserCards;

@Repository
public interface UserardRepository extends JpaRepository<UserCards, Long> {

	@Query("FROM UserCards b WHERE b.userId=:userId AND b.status='Y' ")
	public List<UserCards> getUserCards(@Param("userId") Long userId);

}
