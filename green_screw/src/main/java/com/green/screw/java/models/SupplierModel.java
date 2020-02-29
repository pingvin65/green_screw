package com.green.screw.java.models;

public class SupplierModel {

	private long supplierId;
	private String name;
	private String phone;

	public SupplierModel() {
		super();
	}

	public SupplierModel(long supplierId, String name, String phone) {
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
