package com.budget.home.accessingdatarest;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.budget.home.dto.BudgetDTO;
import com.budget.home.dto.BudgetDTO2;
import com.budget.home.model.Budget;
import com.budget.home.model.Company;
import com.budget.home.model.Person;

//@RepositoryRestResource(collectionResourceRel = "budget2", path = "budget2")
public interface BudgetRepository2 extends PagingAndSortingRepository<Budget, Integer> {
	/*
	public static EntityManager entityManager = null;
	TypedQuery<Company> query = entityManager.createQuery("SELECT b.category FROM Budget b", Company.class);
	List<Company> resultList = query.getResultList();
	*/
//	@Query("SELECT new import com.budget.home.dto.BudgetDTO2(b.budget_id, b.amount, b.amount_e, b.category_id, b.company_id) form Budget b")
//	@Query("SELECT b FROM Budget b")
//	@Query("SELECT new import com.budget.home.dto.BudgetDTO2(b.amount, b.amount_e) from Budget b")
//	List<BudgetDTO2> fetchAllBudget();
	
	@Query(value = "SELECT * FROM budget WHERE company_id = ?1", nativeQuery = true)
	 List<Budget> findByCompanyID(Integer id);


}
