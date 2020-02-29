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

import com.green.screw.java.entities.SuppliersEntity;
import com.green.screw.java.errors.ScrewNotFoundException;
import com.green.screw.java.repositories.SupplierRepository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
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
@RequestMapping("/suppliers")
public class SupplierController {

	private final SupplierRepository supplierRepository;
	private final int MAX_PAGE_SIZE_SUPPLIER = 50;
	private static final String template = "No supplier with ID %s.";

	/**
	 * 
	 * @param supplierRepository
	 */
	public SupplierController(SupplierRepository supplierRepository) {
		this.supplierRepository = supplierRepository;
	}

	/**
	 * 
	 * @return
	 */
	List<SuppliersEntity> all() {
		return supplierRepository.findAll();
	}

	/**
	 * 
	 * @param pageable
	 * @return
	 */
	@GetMapping
	public Page<SuppliersEntity> getAll(@PageableDefault(size = 25, page = 0, sort = {
			"supplierId" }, direction = Direction.ASC) Pageable pageable) {
		int size;
		if (pageable.getPageSize() > MAX_PAGE_SIZE_SUPPLIER) {
			size = MAX_PAGE_SIZE_SUPPLIER;
		} else {
			size = pageable.getPageSize();
		}
		Pageable paging = PageRequest.of(pageable.getPageNumber(), size, pageable.getSort());
		return supplierRepository.findAll(paging);

	}

	/**
	 * 
	 * @param newSuppliers
	 * @return
	 */
	@PostMapping
	SuppliersEntity newEmployee(@RequestBody SuppliersEntity newSuppliers) {
		return supplierRepository.save(newSuppliers);
	}

	/**
	 * 
	 * @param id
	 * @return
	 */
	@GetMapping("/{id}")
	EntityModel<SuppliersEntity> one(@PathVariable Long id) {
		SuppliersEntity suppliersEntity = supplierRepository.findById(id)
				.orElseThrow(() -> new ScrewNotFoundException(String.format(template, id)));

		return new EntityModel<>(suppliersEntity, linkTo(methodOn(SupplierController.class).one(id)).withSelfRel(),
				linkTo(methodOn(SupplierController.class).all()).withRel("suppliers"));
	}

	/**
	 * 
	 * @param newSuppliers
	 * @param id
	 * @return
	 */
	@PutMapping("/{id}")
	SuppliersEntity replaceSupplier(@RequestBody SuppliersEntity newSuppliers, @PathVariable Long id) {

		return supplierRepository.findById(id).map(supplier -> {
			supplier.setName(newSuppliers.getName());
			supplier.setPhone(newSuppliers.getPhone());

			return supplierRepository.save(supplier);
		}).orElseGet(() -> {
			newSuppliers.setSupplierId(id);
			return supplierRepository.save(newSuppliers);
		});

	}

	/**
	 * 
	 * @param id
	 */
	@DeleteMapping("/{id}")
	void deleteSupplier(@PathVariable Long id) {
		supplierRepository.deleteById(id);
	}
}
