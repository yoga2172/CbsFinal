package com.cbs.capbrandingstore.service;


/** This is an interface which defines CRUD methods for CBSEmployee service
 * 
 * @author Reshma's
 *
 */

import java.util.List;

import com.cbs.capbrandingstore.entity.CBSEmployee;
import com.cbs.capbrandingstore.exception.ResourceNotFoundException;


public interface ICBSEmployeeServices {
	 public List<CBSEmployee> getAllEmployees();
	 public CBSEmployee getEmployeeById(Integer empId) throws ResourceNotFoundException;
	 public boolean deleteEmployee(Integer empId) throws ResourceNotFoundException;
	 public CBSEmployee updateEmployeeById(Integer empId,CBSEmployee employee) throws ResourceNotFoundException;
	 public CBSEmployee saveEmployee(CBSEmployee employee);
}

