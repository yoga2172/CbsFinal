package com.cbs.capbrandingstore.entity;

/** This is an entity class for Admin module with getters, setters 
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
@Table(name="ADMIN_INFO")
public class Admin {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name="Admin_Id",nullable=false)
private Integer adminId;
	@Column(name="Admin_Name",nullable=false)
private String adminName;
	@Column(name="Admin_Phone",nullable=false)
private long adminPhone;
	@Column(name="Admin_Email",nullable=false)
private String adminEmail;

public Integer getAdminId() {
	return adminId;
}
public void setAdminId(Integer adminId) {
	this.adminId = adminId;
}
public String getAdminName() {
	return adminName;
}
public void setAdminName(String adminName) {
	this.adminName = adminName;
}
public long getAdminPhone() {
	return adminPhone;
}
public void setAdminPhone(long adminPhone) {
	this.adminPhone = adminPhone;
}
public String getAdminEmail() {
	return adminEmail;
}
public void setAdminEmail(String adminEmail) {
	this.adminEmail = adminEmail;
}

}
