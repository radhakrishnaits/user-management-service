package com.wu.usermanagement.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;

@Entity
@Table(name="user_cards")
@Getter
@Setter
public class Card {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="card_id")
    private int cardId;
    @Column(name = "user_id")
    private int userId;
    @Column(name="card_number")
    private Long cardNumber;
    @Column(name="card_expiry")
    private String cardExpiry;
    @Column(name="name_on_card")
    private String nameOnCard;
    @Column(name="status")
    private String status;
    @Column(name="modified_on")
    private String modifiedOn;
    @Column(name="modified_by")
    private String modifiedBy;
}