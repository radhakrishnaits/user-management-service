package com.wu.usermanagement.model;

import java.util.List;

import com.wu.usermanagement.dto.UserCardsDto;

import lombok.Getter;
import lombok.Setter;


/**
 * Gets the user cards.
 *
 * @return the user cards
 */
@Getter

/**
 * Sets the user cards.
 *
 * @param userCards the new user cards
 */
@Setter
public class ViewUserCardsResponse extends BaseResponse{

    /** The user cards. */
    private List<UserCardsDto> userCards;

}
