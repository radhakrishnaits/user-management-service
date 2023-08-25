package com.wu.usermanagement.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.wu.usermanagement.entity.Beneficiary;

/**
 * The Interface BeneficiaryRepository.
 */
@Repository
public interface BeneficiaryRepository extends JpaRepository<Beneficiary, Long> {
	
	/**
	 * Gets the beneficiary list.
	 *
	 * @param userId the user id
	 * @return the beneficiary list
	 */
	@Query("FROM Beneficiary b WHERE b.userId=:userId AND b.status='Y' ")
	public List<Beneficiary> getBeneficiaryList(@Param("userId") Long userId);
	
	/**
	 * Gets the user beneficiary by nick name.
	 *
	 * @param userId the user id
	 * @param nickName the nick name
	 * @return the user beneficiary by nick name
	 */
	@Query("FROM Beneficiary b WHERE b.userId=:userId AND b.status='Y' AND b.nickName=:nickName")
	public Beneficiary getUserBeneficiaryByNickName(@Param("userId") Long userId,@Param("nickName") String nickName);
}
