package com.cbs.capbrandingstore.service;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cbs.capbrandingstore.entity.CBSEmployee;
import com.cbs.capbrandingstore.repository.CBSEmployeeRepository;
import com.cbs.capbrandingstore.service.CBSEmployeeServices;

import org.mockito.Mockito;
import static org.assertj.core.api.Assertions.assertThat;

/** The CBSEmployeeServiceTest class provides testing of CBSEmployeeDetailsService layer
 *   
 * @author Reshma's
 * 
 */


@RunWith(SpringRunner.class)
@SpringBootTest
class CBSEmployeeServicesTest {

	@MockBean
	 private CBSEmployeeRepository employeeRepository;
	
	 @Autowired
	 private CBSEmployeeServices employeeServices;
	@Test
	void testGetEmployeeById() throws Exception {

		
		CBSEmployee emp = new CBSEmployee();
		emp.setEmpId(103);
		  emp.setEmpName("Ellora");
	      emp.setEmpPhone(690658943); 
	      emp.setEmpEmail("ellora@gmail.com");
	      emp.setEmpLocation("Chennai");
	     
	      System.out.println(employeeRepository.findById(100));
	      Assert.assertTrue(employeeRepository.findById(100).isEmpty());
	      
	}

	@Test
	void testDeleteEmployee() throws Exception {
		CBSEmployee emp = new CBSEmployee();
		  emp.setEmpName("Rabia");
	      emp.setEmpPhone(879658943); 
	      emp.setEmpEmail("rabia@gmail.com");
	      emp.setEmpLocation("Chennai");
	        
	      employeeRepository.deleteById(emp.getEmpId());
        System.out.println(employeeRepository.findById(100));
        Assert.assertTrue(employeeRepository.findById(100).isEmpty());
	}

	@Test
	void testUpdateEmployeeById() throws Exception {
		  
		CBSEmployee emp = new CBSEmployee();
		  emp.setEmpName("Rabia");
	      emp.setEmpPhone(879658943); 
	      emp.setEmpEmail("rabia@gmail.com");
	      emp.setEmpLocation("Chennai");
	         
	      employeeRepository.save(emp);
      System.out.println(employeeRepository.findById(100));
      Assert.assertTrue(employeeRepository.findById(100).isEmpty());
	}

	@Test
	void testGetAllEmployees() {
		CBSEmployee emp=new CBSEmployee();
		  emp.setEmpName("Ajantha");
	      emp.setEmpPhone(690658943); 
	      emp.setEmpEmail("ajantha@gmail.com");
	      emp.setEmpLocation("Chennai");
	        
	      CBSEmployee emp1=new CBSEmployee();
	      emp1.setEmpName("Alla");
	      emp1.setEmpPhone(876965894); 
	      emp1.setEmpEmail("alla@gmail.com");
	      emp1.setEmpLocation("Bangalore");
        List<CBSEmployee> empList = new ArrayList<>();
        empList.add(emp);
        empList.add(emp1);

        Mockito.when(employeeRepository.findAll()).thenReturn(empList);
        assertThat(employeeServices.getAllEmployees()).isEqualTo(empList);
	}

	@Test
	void testSaveEmployee() {
		
		CBSEmployee emp = new CBSEmployee();
		emp.setEmpId(100); 
		  emp.setEmpName("Reshma");
	      emp.setEmpPhone(879658943); 
	      emp.setEmpEmail("resh@gmail.com");
	      emp.setEmpLocation("Chennai");

        Mockito.when(employeeRepository.save(emp)).thenReturn(emp);
        assertThat(employeeServices.saveEmployee(emp)).isEqualTo(emp);
	}

}

