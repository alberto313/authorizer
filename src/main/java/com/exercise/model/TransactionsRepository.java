/**
 * 
 */
package com.exercise.model;

import java.util.List;

/**
 * @author Alberto
 *
 */
public class TransactionsRepository {

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
