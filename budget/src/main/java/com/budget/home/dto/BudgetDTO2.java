package com.budget.home.dto;

import java.io.Serializable;

public class BudgetDTO2 {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;



	private final double amount;

	private final double amount_e;
	
	

	public BudgetDTO2(double amount, double amount_e) {
		super();
		this.amount = amount;
		this.amount_e = amount_e;
	}

	public double getAmount() {
		return amount;
	}

	public double getAmount_e() {
		return amount_e;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		long temp;
		temp = Double.doubleToLongBits(amount);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		temp = Double.doubleToLongBits(amount_e);
		result = prime * result + (int) (temp ^ (temp >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		BudgetDTO2 other = (BudgetDTO2) obj;
		if (Double.doubleToLongBits(amount) != Double.doubleToLongBits(other.amount))
			return false;
		if (Double.doubleToLongBits(amount_e) != Double.doubleToLongBits(other.amount_e))
			return false;
		return true;
	}







}
