package com.pink.screw.java.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.pink.screw.java.entities.Product;
import com.pink.screw.java.repository.ProductRepository;

@Service
public class ProductService implements IProductService {
	
	@Autowired
	private ProductRepository productRepository;

	@Override
	public Iterable<Product> findPaginated(int pageNo, int pageSize) {
		Pageable paging = PageRequest.of(pageNo, pageSize);
        Page<Product> pagedResult = productRepository.findAll(paging);
		return pagedResult.toList();
	}

}
