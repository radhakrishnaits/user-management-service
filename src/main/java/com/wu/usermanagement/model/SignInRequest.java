package com.wu.usermanagement.model;

import lombok.*;

/**
 * Gets the password.
 *
 * @return the password
 */
@Getter

/**
 * Sets the password.
 *
 * @param password the new password
 */
@Setter

/**
 * Instantiates a new sign in request.
 */
@NoArgsConstructor

/**
 * Instantiates a new sign in request.
 *
 * @param username the username
 * @param password the password
 */
@AllArgsConstructor

/**
 * To string.
 *
 * @return the java.lang. string
 */
@ToString
public class SignInRequest {

    /** The username. */
    private String username;
    
    /** The password. */
    private String password;

}
