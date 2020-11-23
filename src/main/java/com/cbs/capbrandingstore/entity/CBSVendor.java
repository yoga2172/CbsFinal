package com.cbs.capbrandingstore.entity;

/** This is an entity class for CBSVendor with getters, setters and constructor
 * 
 * @author AbhiRam's
 *
 */



import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CBS_VENDOR_INFO")
public class CBSVendor  {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="vendor_id")
private int vendorId;
	@Column(name="vendor_name",nullable = false)
private String  vendorName;
	@Column(name="vendor_phone",nullable = false)
private long vendorPhone;
	@Column(name="vendor_email",nullable = false)
private String vendorEmail;
	@Column(name="vendor_location",nullable = false)
private String vendorLocation;
public int getVendorId() {
	return vendorId;
}
public void setVendorId(int vendorId) {
	this.vendorId = vendorId;
}
public String getVendorName() {
	return vendorName;
}
public void setVendorName(String vendorName) {
	this.vendorName = vendorName;
}
public void setVendorPhone(long vendorPhone) {
	this.vendorPhone = vendorPhone;
}
public long getVendorPhone() {
	return vendorPhone;
}
public String getVendorEmail() {
	return vendorEmail;
}
public void setVendorEmail(String vendorEmail) {
	this.vendorEmail = vendorEmail;
}
public String getVendorLocation() {
	return vendorLocation;
}
public void setVendorLocation(String vendorLocation) {
	this.vendorLocation = vendorLocation;
}

public CBSVendor() {
	super();
}

}

