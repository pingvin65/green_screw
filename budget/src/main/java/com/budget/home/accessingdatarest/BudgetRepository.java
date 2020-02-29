package com.budget.home.accessingdatarest;

import java.util.List;

import org.springframework.boot.autoconfigure.data.web.SpringDataWebProperties.Pageable;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.budget.home.dto.BudgetDTO;
import com.budget.home.model.Budget;
import com.budget.home.model.Person;

//@RepositoryRestResource(collectionResourceRel = "budget", path = "budget")
public interface BudgetRepository extends PagingAndSortingRepository<Budget, Integer> {

	/*
	@Query("SELECT new com.budget.home.dto.BudgetDTO(b.budget_id, b.amount, b.amount_e, com.name, cat.name) "
			+ "FROM budget as b, category as cat, company as com "
			+ "WHERE b.category_id = cat.category_id and b.company_id = com.company_id")
	List<BudgetDTO> findByLastName(@Param("name") String name);
	*/
	/*
	@Query("SELECT new com.budget.home.dto.BudgetDTO(b.budget_id, b.amount, b.amount_e, com.name, cat.name) "
	+ "from Budget b inner join Company com on b.company_id = com.company_id "
	+ "inner join Category cat on b.category_id = cat.category_id")
	List<BudgetDTO> fetchBudgetComCatDataInnerJoin();
	*/



}
