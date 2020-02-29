package com.budget.home.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

import org.hibernate.annotations.GenericGenerator;
import org.springframework.format.annotation.NumberFormat;

import com.fasterxml.jackson.annotation.JsonIgnore;

@Entity
@Table(name = "budget")
public class Budget implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO, generator = "native")
	@GenericGenerator(name = "native", strategy = "native")
	private Integer budget_id;

	@NumberFormat(pattern = "#,###,###.##")
	private double amount;

	@NumberFormat(pattern = "#,###,###.##")
	private double amount_e;


	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "company_id", nullable = false)
	private Company company;
	
	@JsonIgnore
	@ManyToOne
	@JoinColumn(name = "category_id", nullable = false)
	private Category category;

	public Budget() {
		super();
	}

	public Budget(Integer budget_id, double amount, double amount_e, Company company, Category category) {
		super();
		this.budget_id = budget_id;
		this.amount = amount;
		this.amount_e = amount_e;
		this.company = company;
		this.category = category;
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

	public Integer getBudget_id() {
		return budget_id;
	}

	public void setBudget_id(Integer budget_id) {
		this.budget_id = budget_id;
	}

	public Company getCompany() {
		return company;
	}

	public void setCompany(Company company) {
		this.company = company;
	}

	public Category getCategory() {
		return category;
	}

	public void setCategory(Category category) {
		this.category = category;
	}

}
