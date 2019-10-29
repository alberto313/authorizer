/**
 * 
 */
package com.exercise.service;

import java.util.ArrayList;
import java.util.List;

import org.kie.api.runtime.KieContainer;
import org.kie.api.runtime.KieSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.exercise.model.AccountAccount;
import com.exercise.model.TransactionTransaction;
import com.exercise.model.TransactionsRepository;

/**
 * This class execute business rules previously defined in a .drl file.</br>
 * The execution of this business rules is made by grouping business rules that
 * applies to certain scenarios.
 */
@Component
public class BusinessRulerService {

	@Autowired
	private KieContainer kieContainer;
	
	/**
	 * Execute business rules that creation account must complain before create it.
	 * @param account account information retrieved from cache if exists
	 * @param violations array to be returned as violations property of account object
	 * @return
	 */
	public ArrayList<String> createNewAccountRules(AccountAccount account, ArrayList<String> violations) {
		KieSession kieSession = kieContainer.newKieSession();
		kieSession.setGlobal("violations", violations);
		kieSession.insert(account);
		kieSession.getAgenda().getAgendaGroup("account").setFocus();
		kieSession.fireAllRules();
		kieSession.dispose();
		return violations;
	}
	
	/**
	 * Execute business rules that a transaction must complain before to be performed.
	 * @param account account information retrieved from cache if exists
	 * @param transaction transaction to be performed
	 * @param violations array to be returned as violations property of account object
	 * @param transactions transactions that has been made on the account and they are stored in cache
	 * @return
	 */
	public List<String> preConditionsTransactionRules(AccountAccount account, TransactionTransaction transaction, 
			List<String> violations, TransactionsRepository transactions) {
		KieSession kieSession = kieContainer.newKieSession();
		kieSession.setGlobal("violations", violations);
		kieSession.insert(account);
		kieSession.insert(transaction);
		kieSession.insert(transactions);
		kieSession.getAgenda().getAgendaGroup("transaction").setFocus();
		kieSession.fireAllRules();
		kieSession.dispose();
		return violations;
	}
}
