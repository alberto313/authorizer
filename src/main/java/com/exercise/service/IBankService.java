/**
 * 
 */
package com.exercise.service;

import com.exercise.model.Account;
import com.exercise.model.AccountResponse;
import com.exercise.model.Transaction;

/**
 * Bank service interface
 */
public interface IBankService {

	/**
	 * Create a new account with provided information and then
	 * store it in a in-memory cache
	 * @param body
	 * @return
	 */
	AccountResponse createAccount(Account body);
	
	/**
	 * Process transaction over the account previously created.</br>
	 * Retrieve the account, previously created, from cache and then validate some business
	 * rules and perform or not the transaction.
	 * @param body
	 * @return
	 */
	AccountResponse performTransaction(Transaction body);
	
}
