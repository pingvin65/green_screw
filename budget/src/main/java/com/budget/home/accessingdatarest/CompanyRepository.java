package com.budget.home.accessingdatarest;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.budget.home.model.Category;
import com.budget.home.model.Company;
import com.budget.home.iface.service.CompanyInterface;

public interface  CompanyRepository extends JpaRepository<Company, Integer> {
	
	@Query("select c from Company c")
	List<CompanyInterface> getAllCompany();

}
