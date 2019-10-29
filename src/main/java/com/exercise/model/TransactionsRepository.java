/**
 * 
 */
package com.exercise.model;

import java.io.Serializable;
import java.util.List;

/**
 * Object that is like a repository to store all transactions made
 * over an account and it is stored in cache.
 */
public class TransactionsRepository implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = -3530391632644174554L;
	
	private final List<TransactionTransaction> transactions;

	public TransactionsRepository(List<TransactionTransaction> transactions) {
		this.transactions = transactions;
	}

	/**
	 * @return the transactions
	 */
	public List<TransactionTransaction> getTransactions() {
		return transactions;
	}
	
	
}
