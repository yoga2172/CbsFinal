package com.cbs.capbrandingstore.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbs.capbrandingstore.entity.CBSEmployee;
import com.cbs.capbrandingstore.exception.ResourceNotFoundException;
import com.cbs.capbrandingstore.repository.CBSEmployeeRepository;

/** The CBSEmployeeService class provides access to repository methods to CRUD operations CBSEmployee details 
 * 
 * 
 * @author Reshma's
 *
 */
@Service

public class CBSEmployeeServices implements ICBSEmployeeServices {
 String e= "Employee not found for this id :: ";
	@Autowired 
	private CBSEmployeeRepository cbsemployeerepository;
	
	public CBSEmployee getEmployeeById(Integer empId) throws ResourceNotFoundException {
		return  cbsemployeerepository.findById(empId).orElseThrow(() -> new ResourceNotFoundException(e + empId));
		
	}
	 public boolean deleteEmployee(Integer empId) throws ResourceNotFoundException {
		 CBSEmployee employee = cbsemployeerepository.findById(empId)
					.orElseThrow(() -> new ResourceNotFoundException(e + empId));

		 cbsemployeerepository.delete(employee);
		boolean t=false;
		 if(null == employee){
	            t= true;
	        }
	        return t;
	}
	 public CBSEmployee updateEmployeeById(Integer empId,CBSEmployee employee) throws ResourceNotFoundException {
		 CBSEmployee emp = cbsemployeerepository.findById(empId)
				.orElseThrow(() -> new ResourceNotFoundException(e + empId));
		 emp.setEmpName(employee.getEmpName());
		 emp.setEmpPhone(employee.getEmpPhone());
		 emp.setEmpEmail(employee.getEmpEmail());
		 emp.setEmpLocation(employee.getEmpLocation());
	return cbsemployeerepository.save(emp);
		
		
	}
	 public List<CBSEmployee> getAllEmployees() {
			return cbsemployeerepository.findAll();
		}
		 
		 public CBSEmployee saveEmployee(CBSEmployee employee) {
			return  cbsemployeerepository.save(employee);
			  
			
		}
}
