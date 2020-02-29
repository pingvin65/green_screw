package com.pink.screw.java.repository;

//import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.stereotype.Repository;

import com.pink.screw.java.entities.Product;

@Repository
@RepositoryRestResource(collectionResourceRel = "products", path = "products")
public interface ProductRepository  extends PagingAndSortingRepository<Product, Integer>{

}
