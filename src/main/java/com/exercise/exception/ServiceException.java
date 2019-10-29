/**
 * 
 */
package com.exercise.exception;

import com.exercise.model.AccountResponse;

/**
 * @author Z749313
 *
 */
public class ServiceException extends Exception {

	/**
	 * 
	 */
	private static final long serialVersionUID = -1471316145457581739L;
	
	private final AccountResponse error;

	public ServiceException(AccountResponse error) {
		super();
		this.error = error;
	}

	/**
	 * @return the error
	 */
	public AccountResponse getError() {
		return error;
	}
}
