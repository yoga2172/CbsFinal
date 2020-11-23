package com.cbs.capbrandingstore.repository;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.cbs.capbrandingstore.entity.CBSEmployee;
import com.cbs.capbrandingstore.repository.CBSEmployeeRepository;

/** The CBSEmployeeRepositoryTest class provides testing of CBSEmployeeRepository layer
 *   
 * @author Reshma's
 * 
 */

@RunWith(SpringRunner.class)
@DataJpaTest
 class CBSEmployeeRepositoryTest {

	@Autowired
    private CBSEmployeeRepository employeerepository;

    @Autowired
    private TestEntityManager testEntityManager;
    @Test
     void testNewEmployee() throws Exception{
    	CBSEmployee emp = getCBSEmployee();
    	CBSEmployee saveInDb = testEntityManager.persist(emp);
    	CBSEmployee getFromInDb = employeerepository.findById(saveInDb.getEmpId()).get();
        assertThat(getFromInDb).isEqualTo(saveInDb);
    }
	private CBSEmployee getCBSEmployee() {
		CBSEmployee emp=new CBSEmployee();
		  emp.setEmpName("Aarna");
	      emp.setEmpPhone(768658943); 
	      emp.setEmpEmail("aarna@gmail.com");
	      emp.setEmpLocation("Chennai");
		return emp;
	}
	@Test
    void testGetEmployeeById() throws Exception{
		CBSEmployee emp=new CBSEmployee();
		 emp.setEmpName("Reshma");
	      emp.setEmpPhone(896658943); 
	      emp.setEmpEmail("resh@gmail.com");
	      emp.setEmpLocation("Chennai");
       CBSEmployee saveInDb = testEntityManager.persist(emp);
       CBSEmployee getInDb = employeerepository.findById(emp.getEmpId()).get();
        assertThat(getInDb).isEqualTo(saveInDb);
	}
	 @Test
	    void testGetAllEmployees() throws Exception{
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
	        testEntityManager.persist(emp); 
	        testEntityManager.persist(emp1);
	        List<CBSEmployee> empList = (List<CBSEmployee>) employeerepository.findAll();

	        Assert.assertEquals(2, empList.size());
	    }
	 @Test
	     void testDeleteEmployeeById() throws Exception{
		 CBSEmployee emp=new CBSEmployee();
		 emp.setEmpName("Rabia");
	      emp.setEmpPhone(879658943); 
	      emp.setEmpEmail("rabia@gmail.com");
	      emp.setEmpLocation("Chennai");
	        

	      CBSEmployee emp1=new CBSEmployee();
	        emp1.setEmpName("Basha");
		      emp1.setEmpPhone(998658943); 
		      emp1.setEmpEmail("rabia@gmail.com");
		      emp1.setEmpLocation("Chennai");
	        

			CBSEmployee emp2 = testEntityManager.persist(emp);
	        testEntityManager.persist(emp1);
	        testEntityManager.remove(emp2);

	        List<CBSEmployee> cbsemp = (List<CBSEmployee>) employeerepository.findAll();
	        Assert.assertEquals(1,cbsemp.size());

	    }
	 @Test
	     void testUpdateEmployee(){

		 CBSEmployee emp=new CBSEmployee();
		 emp.setEmpName("Ellora");
	      emp.setEmpPhone(690658943); 
	      emp.setEmpEmail("ellora@gmail.com");
	      emp.setEmpLocation("Chennai");
	        
	        testEntityManager.persist(emp);

	        CBSEmployee getFromDb = employeerepository.findById(emp.getEmpId()).get();
	        getFromDb.setEmpPhone(999658943); 
	        testEntityManager.persist(getFromDb);

	        assertThat(getFromDb.getEmpPhone()).isEqualTo(999658943);
	    }


}
