package com.wu.usermanagement.repository;

import com.wu.usermanagement.entity.Beneficiary;
import com.wu.usermanagement.entity.Card;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {

}
