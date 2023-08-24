package com.wu.usermanagement.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.wu.usermanagement.entity.Card;

@Repository
public interface CardRepository extends JpaRepository<Card, Integer> {

}
