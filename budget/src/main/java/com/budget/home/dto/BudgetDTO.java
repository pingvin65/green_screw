package com.budget.home.dto;

import java.io.Serializable;



public class BudgetDTO implements Serializable{
	
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	private Integer budget_id;
	
	private double amount;

	private double amount_e;
	
	private String company_name;
	
	private String category_name;
	
	

	public BudgetDTO(Integer budget_id, double amount, double amount_e, String company_name, String category_name) {
		super();
		this.budget_id = budget_id;
		this.amount = amount;
		this.amount_e = amount_e;
		this.company_name = company_name;
		this.category_name = category_name;
	}
	
	

	public Integer getBudget_id() {
		return budget_id;
	}

	public void setBudget_id(Integer budget_id) {
		this.budget_id = budget_id;
	}

	public double getAmount() {
		return amount;
	}

	public void setAmount(double amount) {
		this.amount = amount;
	}

	public double getAmount_e() {
		return amount_e;
	}

	public void setAmount_e(double amount_e) {
		this.amount_e = amount_e;
	}

	public String getCompany_name() {
		return company_name;
	}

	public void setCompany_name(String company_name) {
		this.company_name = company_name;
	}

	public String getCategory_name() {
		return category_name;
	}

	public void setCategory_name(String category_name) {
		this.category_name = category_name;
	}
	
	
	
}
