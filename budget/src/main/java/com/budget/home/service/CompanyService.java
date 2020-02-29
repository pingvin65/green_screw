package com.budget.home.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;

import com.budget.home.accessingdatarest.CompanyRepository;
import com.budget.home.iface.service.CompanyInterface;
import com.budget.home.model.Company;

public class CompanyService{
	

	private CompanyRepository companyRepository;


	public List<CompanyInterface> getName() {
		System.out.print(companyRepository.findAll());
		return companyRepository.getAllCompany();
	}

	public Iterable<Company> getAllCompany(){
		return companyRepository.findAll();
	}
}
