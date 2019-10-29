/**
 * 
 */
package com.exercise.facts;

/**
 * @author Z749313
 *
 */
public class TransactionFact {

	private boolean isExceededAmount;
	
	private boolean isActiveCard;

	/**
	 * @return the isExceededAmount
	 */
	public boolean isExceededAmount() {
		return isExceededAmount;
	}

	/**
	 * @param isExceededAmount the isExceededAmount to set
	 */
	public void setExceededAmount(boolean isExceededAmount) {
		this.isExceededAmount = isExceededAmount;
	}

	/**
	 * @return the isActiveCard
	 */
	public boolean isActiveCard() {
		return isActiveCard;
	}

	/**
	 * @param isActiveCard the isActiveCard to set
	 */
	public void setActiveCard(boolean isActiveCard) {
		this.isActiveCard = isActiveCard;
	}
}
