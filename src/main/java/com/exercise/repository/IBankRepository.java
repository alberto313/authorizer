/**
 * 
 */
package com.exercise.repository;

import com.exercise.model.AccountAccount;

/**
 * @author Alberto
 *
 */
public interface IBankRepository {

	/**
	 * Create a new account
	 * @param availableLimit Available limit in cash account
	 * @param activeCard Determines if cash account is either active or locked
	 * @return
	 */
	AccountAccount createAccount(int availableLimit, boolean activeCard);
}
