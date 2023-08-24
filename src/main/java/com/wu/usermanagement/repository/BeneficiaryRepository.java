package com.wu.usermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wu.usermanagement.entity.Beneficiary;

@Repository
public interface BeneficiaryRepository extends JpaRepository<Beneficiary, Long> {
}
