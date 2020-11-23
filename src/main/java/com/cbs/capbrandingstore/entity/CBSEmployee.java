package com.cbs.capbrandingstore.entity;

/** This is an entity class for CBSEmployee module with getters, setters and constructor
 * 
 * @author Reshma's
 *
 */


import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name="CBS_EMPLOYEE_INFO")
public class CBSEmployee  {
@Id
@GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name="emp_id")
private int empId;
	@Column(name="emp_name",nullable = false)
private String empName;
	@Column(name="emp_phone",nullable = false)
private long empPhone;
	@Column(name="emp_email",nullable = false)
private String empEmail;
	@Column(name="emp_location",nullable = false)
private String empLocation;
public int getEmpId() {
	return empId;
}
public void setEmpId(int empId) {
	this.empId = empId;
}
public String getEmpName() {
	return empName;
}
public void setEmpName(String empName) {
	this.empName = empName;
}
public void setEmpPhone(long empPhone) {
	this.empPhone = empPhone;
}
public long getEmpPhone() {
	return empPhone;
}
public String getEmpEmail() {
	return empEmail;
}
public void setEmpEmail(String empEmail) {
	this.empEmail = empEmail;
}
public String getEmpLocation() {
	return empLocation;
}
public void setEmpLocation(String empLocation) {
	this.empLocation = empLocation;
}

public CBSEmployee() {
	super();
}

}

