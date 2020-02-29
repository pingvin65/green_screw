package com.budget.home.accessingdatarest;

import org.springframework.data.jpa.repository.JpaRepository;

import com.budget.home.model.Category;

public interface CategoryRepository extends JpaRepository<Category, Integer>{

}
