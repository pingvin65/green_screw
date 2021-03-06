package com.green.screw.java.entities;

import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.ManyToMany;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

import net.minidev.json.JSONObject;

/**
 * 
 * @author pingvin
 *
 */
@Entity
@Table(name = "products")
public class ProductsEntity {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long productId;

	@Column(columnDefinition = "CHAR(8)", nullable = false, unique = true)
	@NotEmpty(message = "Please provide a Product Code")

	private String productCode;

	@Column(nullable = false)
	@NotEmpty(message = "Please provide a name")
	@Size(min = 3, max = 50, message = "name betwin 3 and 50")
	private String name;

	@Column()
	private Integer quantity;

	@Column(precision = 8, scale = 2, length = 8)
	private float price;

	/**
	 * 
	 */
	@ManyToMany(cascade = CascadeType.ALL)
	@JoinTable(name = "products_suppliers", joinColumns = @JoinColumn(name = "product_id"), inverseJoinColumns = @JoinColumn(name = "supplier_id"))
	Set<SuppliersEntity> likedSuppliers;

	/**
	 * 
	 */
	public ProductsEntity() {
	}

	/**
	 * 
	 * @param productCode
	 * @param name
	 * @param quantity
	 * @param price
	 * @param likedSuppliers
	 */
	public ProductsEntity(@NotEmpty(message = "Please provide a Product Code") String productCode,
			@NotEmpty(message = "Please provide a name") @Size(min = 3, max = 50, message = "name betwin 3 and 50") String name,
			Integer quantity, float price, Set<SuppliersEntity> likedSuppliers) {
		this.productCode = productCode;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
		this.likedSuppliers = likedSuppliers;
	}

	public long getProductId() {
		return productId;
	}

	public void setProductId(long productId) {
		this.productId = productId;
	}

	public String getProductCode() {
		return productCode;
	}

	public void setProductCode(String productCode) {
		this.productCode = productCode;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public Integer getQuantity() {
		return quantity;
	}

	public void setQuantity(Integer quantity) {
		this.quantity = quantity;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public Set<SuppliersEntity> getLikedSuppliers() {
		return likedSuppliers;
	}

	public void setLikedSuppliers(Set<SuppliersEntity> likedSuppliers) {
		this.likedSuppliers = likedSuppliers;
	}

	public JSONObject get() {
		JSONObject jo = new JSONObject();
		jo.put("name", "jon doe");
		jo.put("age", "22");
		jo.put("city", "chicago");
		return null;

	}

}
