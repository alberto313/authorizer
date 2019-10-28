/**
 * 
 */
package com.exercise.service;

import org.springframework.http.ResponseEntity;

import com.exercise.model.Account;
import com.exercise.model.AccountResponse;
import com.exercise.model.Transaction;

/**
 *
 */
public interface IBankService {

	/**
	 * @param body
	 * @return
	 */
	AccountResponse createAccount(Account body);
	
	/**
	 * @param body
	 * @return
	 */
	AccountResponse performTransaction(Transaction body);
	
}
