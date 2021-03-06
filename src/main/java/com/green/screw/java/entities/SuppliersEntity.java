package com.green.screw.java.entities;

import java.util.Set;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import com.green.screw.java.validators.ContactNumberConstraint;

/**
 * 
 * @author pingvin
 *
 */
@Entity
@Table(name = "suppliers")
public class SuppliersEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long supplierId;

	@Column(unique = true, nullable = false)
	@NotEmpty(message = "Please provide a name")
	@Size(min = 3, max = 30, message = "name betwin 3 and 30")
	private String name;

	@ContactNumberConstraint
	@Column(columnDefinition = "VARCHAR(13)")
	private String phone;

	@ManyToMany(mappedBy = "likedSuppliers")
	Set<ProductsEntity> products;

	public SuppliersEntity() {
	}

	/**
	 * 
	 * @param name
	 * @param phone
	 * @param products
	 */
	public SuppliersEntity(
			@NotEmpty(message = "Please provide a name") @Size(min = 3, max = 30, message = "name betwin 3 and 30") String name,
			String phone, Set<ProductsEntity> products) {
		super();
		this.name = name;
		this.phone = phone;
		this.products = products;
	}

	/**
	 * 
	 * @param supplierId
	 * @param name
	 * @param phone
	 */
	public SuppliersEntity(long supplierId,
			@NotEmpty(message = "Please provide a name") @Size(min = 3, max = 30, message = "name betwin 3 and 30") String name,
			String phone) {
		super();
		this.supplierId = supplierId;
		this.name = name;
		this.phone = phone;
	}

	public long getSupplierId() {
		return supplierId;
	}

	public void setSupplierId(long supplierId) {
		this.supplierId = supplierId;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getPhone() {
		return phone;
	}

	public void setPhone(String phone) {
		this.phone = phone;
	}

}
