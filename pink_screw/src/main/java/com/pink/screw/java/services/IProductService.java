package com.pink.screw.java.services;

import com.pink.screw.java.entities.Product;

public interface IProductService {
	Iterable<Product> findPaginated(int pageNo, int pageSize);
}
