package com.pink.screw.java.entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.ManyToMany;
import javax.persistence.JoinColumn;
import javax.persistence.JoinTable;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;

/**
 * @author pingvin
 *
 */
@Entity
@Table(name = "product")
public class Product implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Integer productID;

	@Column(columnDefinition = "CHAR(4)", nullable = false)
	@NotEmpty(message = "Please provide a Product Code")
	private String productCode;

	@Column(unique = true, nullable = false)
	@NotEmpty(message = "Please provide a name")
	@Size(min = 3, max = 30, message = "name betwin 3 and 30")
	private String name;

	private Integer quantity;

	@Column(precision = 8, scale = 2, length = 8)
	private Float price;
	

	

	public Product() {
		super();
	}

	public Product(@NotEmpty(message = "Please provide a Product Code") String productCode,
			@Size(min = 3, max = 30, message = "name betwin 3 and 30") @NotEmpty(message = "Please provide a name") String name,
			Integer quantity, Float price) {
		super();
		this.productCode = productCode;
		this.name = name;
		this.quantity = quantity;
		this.price = price;
	}

	public Integer getProductID() {
		return productID;
	}

	public void setProductID(Integer productID) {
		this.productID = productID;
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

	public Float getPrice() {
		return price;
	}

	public void setPrice(Float price) {
		this.price = price;
	}

}
