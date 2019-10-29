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
 * @author Z749313
 *
 */
@Component
public class BusinessRulerService {

	@Autowired
	private KieContainer kieContainer;
	
	public ArrayList<String> createNewAccountRules(AccountAccount account, ArrayList<String> violations) {
		KieSession kieSession = kieContainer.newKieSession();
		kieSession.setGlobal("violations", violations);
		kieSession.insert(account);
		kieSession.getAgenda().getAgendaGroup("account").setFocus();
		kieSession.fireAllRules();
		kieSession.dispose();
		return violations;
	}
	
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
