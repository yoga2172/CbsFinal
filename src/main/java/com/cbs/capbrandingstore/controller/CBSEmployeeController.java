package com.cbs.capbrandingstore.controller;


/** This is a Controller class for CBSEmployee module 
 * 
 * @author Reshma's
 *
 */

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cbs.capbrandingstore.entity.CBSEmployee;
import com.cbs.capbrandingstore.entity.Cart;
import com.cbs.capbrandingstore.exception.ResourceNotFoundException;
import com.cbs.capbrandingstore.service.CBSEmployeeServices;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;


@Api(value="CBSEmployeeController",description="REST Apis related to Employee Entity!!!")
@RestController
@RequestMapping("/api/v0") 
public class CBSEmployeeController {

	@Autowired 
	private CBSEmployeeServices cbsemployeeservices;
	
	/** 
	 * 
	 *This method returns the list of employee details  
	 * 
	 * 
	 */
	@ApiOperation(value ="Get list of Employee in the System",response=CBSEmployee.class)
	@GetMapping("/getAllEmployees")
	public List<CBSEmployee> getAllEmployees() {
		return cbsemployeeservices.getAllEmployees();
	}
	
	
	/** This method adds the employee details 
	 * 
	 * @param CBSEmployee entity details
	 * 
	 * 
	 */
	@ApiOperation(value ="Creating the new Employee in the system",response=CBSEmployee.class)
	@PostMapping("/saveEmployee") 
	public CBSEmployee createEmployee( @RequestBody CBSEmployee employee) {
		return cbsemployeeservices.saveEmployee(employee);
	} 
	
	
	/** 
	 * 
	 *This method returns the list of employee details  
	 * @param CBSEmployee - empId
	 * 
	 */
	@ApiOperation(value ="Get employee info by id in the system",response=CBSEmployee.class)
	@GetMapping("/getEmployee/{id}")
	public ResponseEntity<CBSEmployee> getEmployeeById(@PathVariable(value = "id") Integer empId) throws ResourceNotFoundException {
		CBSEmployee cbsemp = cbsemployeeservices.getEmployeeById(empId);
		return  ResponseEntity.ok(cbsemp);
	}
	
	/** This method updates the employee details 
	 * 
	 * @param CBSEmployee entity details and CBSEmployee - empId
	 * 
	 * 
	 */
	
	@ApiOperation(value ="Update employee info by id in the system",response=CBSEmployee.class)
	@PutMapping("/updateEmployee/{id}")
	public ResponseEntity<CBSEmployee> updateEmployee(@PathVariable(value = "id") Integer empId,
			 @RequestBody CBSEmployee employee) throws ResourceNotFoundException {
		CBSEmployee cbsemp = cbsemployeeservices.updateEmployeeById(empId,employee);
		return  ResponseEntity.ok(cbsemp);
	}

	
	/** This method udeletes the employee details 
	 * 
	 * @param CBSEmployee entity details and CBSEmployee - empId
	 * 
	 * 
	 */
	@ApiOperation(value ="Delete employee info by id in the system",response=CBSEmployee.class)
	@DeleteMapping("/deleteEmployee/{id}")	
	public boolean deleteEmployee(@PathVariable(value = "id") Integer empId)
			throws ResourceNotFoundException {
		cbsemployeeservices.deleteEmployee(empId);
		return true;
	
	}
}
