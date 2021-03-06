package com.green.screw.java.controllers;

import java.util.List;

import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.green.screw.java.entities.ProductsEntity;
import com.green.screw.java.errors.ScrewNotFoundException;
import com.green.screw.java.repositories.ProductsRepository;

import org.springframework.data.domain.Page;

import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort.Direction;
import org.springframework.data.web.PageableDefault;
import org.springframework.hateoas.EntityModel;
import static org.springframework.hateoas.server.mvc.WebMvcLinkBuilder.*;

/**
 * 
 * @author pingvin
 *
 */
@RestController
@RequestMapping("/products")
public class ProductsController {

	private final ProductsRepository productsRepository;
	private static final String template = "No product with ID %s.";

	/**
	 * 
	 * @param productsRepository
	 */
	public ProductsController(ProductsRepository productsRepository) {
		this.productsRepository = productsRepository;
	}

	/**
	 * 
	 * @return
	 */
	List<ProductsEntity> all() {
		return productsRepository.findAll();
	}

	/**
	 * 
	 * @param pageable
	 * @return
	 */
	@GetMapping
	public Page<ProductsEntity> getAll(@PageableDefault(size = 50, page = 0, sort = {
			"productId" }, direction = Direction.ASC) Pageable pageable) {
		return productsRepository.findAll(pageable);
	}

	/**
	 * 
	 * @param newProducts
	 * @return
	 */
	@PostMapping("/")
	ProductsEntity newProducts(@RequestBody ProductsEntity newProducts) {
		return productsRepository.save(newProducts);
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	EntityModel<ProductsEntity> one(@PathVariable Long id) {
		ProductsEntity suppliersEntity = productsRepository.findById(id)
				.orElseThrow(() -> new ScrewNotFoundException(String.format(template, id)));

		return new EntityModel<>(suppliersEntity, linkTo(methodOn(ProductsController.class).one(id)).withSelfRel(),
				linkTo(methodOn(ProductsController.class).all()).withRel("suppliers"));
	}
	
	/**
	 * 
	 * @param pageable
	 * @param name
	 * @return
	 */
	@GetMapping("/name/{name}")
	Page<ProductsEntity> allByName(@PageableDefault(size = 50, page = 0, sort = {
	"productId" }, direction = Direction.ASC) Pageable pageable, @PathVariable String name) {
		return productsRepository.findByName(name, pageable);
	}
	
	/**
	 * 
	 * @param pageable
	 * @param name
	 * @return
	 */
	@GetMapping("/suppliers/name/{name}")
	Page<ProductsEntity> allBySupName(@PageableDefault(size = 50, page = 0, sort = {
	"productId" }, direction = Direction.ASC) Pageable pageable, @PathVariable String name) {
		return productsRepository.findByLikedSuppliers_NameStartingWithIgnoreCase(name, pageable);
	}

	/**
	 * 
	 * @param changeProduct
	 * @param id
	 * @return
	 */
	@PutMapping("/{id}")
	ProductsEntity replaceSupplier(@RequestBody ProductsEntity changeProduct, @PathVariable Long id) {

		return productsRepository.findById(id).map(product -> {
			product.setProductCode(changeProduct.getProductCode());
			product.setName(changeProduct.getName());
			product.setQuantity(changeProduct.getQuantity());
			product.setPrice(changeProduct.getPrice());
			return productsRepository.save(product);
		}).orElseGet(() -> {
			changeProduct.setProductId(id);
			return productsRepository.save(changeProduct);
		});
	}

	/**
	 * 
	 * @param id
	 */
	@DeleteMapping("/{id}")
	void deleteSupplier(@PathVariable Long id) {
		productsRepository.deleteById(id);
	}
}
