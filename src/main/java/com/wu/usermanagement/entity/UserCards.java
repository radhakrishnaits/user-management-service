package com.wu.usermanagement.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import lombok.Getter;
import lombok.Setter;

/**
 * The Class Card.
 */
/**
 * Gets the users.
 *
 * @return the users
 */
@Getter

/**
 * Sets the users.
 *
 * @param users the new users
 */
@Setter
@Entity
@Table(name = "user_cards")
public class UserCards {

	/** The card id. */
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "card_id")
	private int cardId;
	
	@Column(name = "user_id",insertable = false,updatable = false)
	private Long userId;

	/** The card number. */
	@Column(name = "card_number")
	private Long cardNumber;
	
	/** The card expiry. */
	@Column(name = "card_expiry")
	private String cardExpiry;
	
	/** The name on card. */
	@Column(name = "name_on_card")
	private String nameOnCard;
	
	/** The status. */
	@Column(name = "status")
	private String status;
	
	/** The modified on. */
	@Column(name = "modified_on")
	private String modifiedOn;
	
	/** The modified by. */
	@Column(name = "modified_by")
	private String modifiedBy;

	
	@ManyToOne
	@JoinColumn(name = "user_id", nullable = false)
	private Users users;
	
}