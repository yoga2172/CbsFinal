package com.cbs.capbrandingstore.entity;


/** This is an entity class for Payment module with getters, setters
 * 
 * @author Yoga's
 *
 */

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="PAYMENT_INFO")
public class Payment {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="emp_id",nullable=false)
	private Integer empId;
	@Column(name="Product_id",nullable=false)
	private Integer productId;
	@Column(name="product_name",nullable=false)
	private String productName;
	@Column(name="product_Category",nullable=false)
	private String productCategory;
	@Column(name="emp_location",nullable=false)
	private String empLocation;
	@Column(name="vendor_Location",nullable=false)
	private String vendorLocation;
	
	public Integer getEmpId() {
		return empId;
	}
	public void setEmpId(Integer empId) {
		this.empId = empId;
	}
	public Integer getProductId() {
		return productId;
	}
	public void setProductId(Integer productId) {
		this.productId = productId;
	}
	public String getProductName() {
		return productName;
	}
	public void setProductName(String productName) {
		this.productName = productName;
	}
	public String getProductCategory() {
		return productCategory;
	}
	public void setProductCategory(String productCategory) {
		this.productCategory = productCategory;
	}
	public String getEmpLocation() {
		return empLocation;
	}
	public void setEmpLocation(String empLocation) {
		this.empLocation = empLocation;
	}
	public String getVendorLocation() {
		return vendorLocation;
	}
	public void setVendorLocation(String vendorLocation) {
		this.vendorLocation = vendorLocation;
	}
}
