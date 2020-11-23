package com.cbs.capbrandingstore.controller;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cbs.capbrandingstore.controller.CBSEmployeeController;
import com.cbs.capbrandingstore.entity.CBSEmployee;
import com.cbs.capbrandingstore.service.CBSEmployeeServices;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/** The CBSEmployeeControllerTest class provides testing of CBSEmployeeController layer
 *   
 * @author Reshma's
 * 
 */


@RunWith(SpringRunner.class)
@WebMvcTest(value = CBSEmployeeController.class)

 class CBSEmployeeControllerTest {
	 @Autowired
	    private MockMvc mockMvc;

	    @MockBean
	    private CBSEmployeeServices cbsemployeeservice; 
	@Test
	void testGetAllEmployees() throws Exception {
		String URI = "/api/v0/getAllEmployees";
		  CBSEmployee emp = new CBSEmployee();
		  emp.setEmpName("Reshma");
	      emp.setEmpPhone(987658943); 
	      emp.setEmpEmail("resh@gmail.com");
	      emp.setEmpLocation("Chennai");
	      CBSEmployee emp1 = new CBSEmployee();
	      emp1.setEmpName("Alla");
	      emp1.setEmpPhone(876965894); 
	      emp1.setEmpEmail("alla@gmail.com");
	      emp1.setEmpLocation("Bangalore");
	    	 List<CBSEmployee> empList=new ArrayList<>();
	    	  empList.add(emp);
	    	empList.add(emp1);
	    	 
	    	String jsonInput = this.converttoJson(empList);

	         Mockito.when(cbsemployeeservice.getAllEmployees()).thenReturn(empList);
	         MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON)).andReturn();
	         MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	         String jsonOutput = mockHttpServletResponse.getContentAsString();

	         assertThat(jsonInput).isEqualTo(jsonOutput);
	}

	@Test
	void testCreateEmployee() throws Exception {
		String URI = "/api/v0/saveEmployee";
		 CBSEmployee emp = new CBSEmployee();
		 emp.setEmpName("Rabia");
	      emp.setEmpPhone(879658943); 
	      emp.setEmpEmail("rabia@gmail.com");
	      emp.setEmpLocation("Chennai");
        String jsonInput = this.converttoJson(emp);

        Mockito.when(cbsemployeeservice.saveEmployee(Mockito.any(CBSEmployee.class))).thenReturn(emp);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        String jsonOutput = mockHttpServletResponse.getContentAsString();
        assertThat(jsonInput).isEqualTo(jsonOutput);
        Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
	}

	@Test
	void testGetEmployeeById() throws Exception {
		String URI= "/api/v0/getEmployee/{id}";
		 CBSEmployee emp = new CBSEmployee();
		 emp.setEmpName("Basha");
	      emp.setEmpPhone(998658943); 
	      emp.setEmpEmail("basha@gmail.com");
	      emp.setEmpLocation("Chennai");
        String jsonInput = this.converttoJson(emp);

        Mockito.when(cbsemployeeservice.getEmployeeById(Mockito.any())).thenReturn(emp);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI, 102).accept(MediaType.APPLICATION_JSON)).andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        String jsonOutput = mockHttpServletResponse.getContentAsString();

        assertThat(jsonInput).isEqualTo(jsonOutput);
	}

	@Test
	void testUpdateEmployee() throws Exception {
		String URI = "/api/v0/updateEmployee/{id}";
		CBSEmployee emp = new CBSEmployee();
		 emp.setEmpName("Aarna");
	      emp.setEmpPhone(768658943); 
	      emp.setEmpEmail("aarna@gmail.com");
	      emp.setEmpLocation("Chennai");
        String jsonInput = this.converttoJson(emp);

        Mockito.when(cbsemployeeservice.updateEmployeeById(Mockito.any(),Mockito.any())).thenReturn(emp);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.put(URI,105).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        String jsonOutput = mockHttpServletResponse.getContentAsString();

        assertThat(jsonInput).isEqualTo(jsonOutput);
	}
 
	@Test
	void testDeleteEmployee() throws Exception {
		String URI = "/api/v0/deleteEmployee/{id}";
		CBSEmployee emp = new CBSEmployee();
		emp.setEmpName("Ajantha");
	      emp.setEmpPhone(690658943); 
	      emp.setEmpEmail("ajantha@gmail.com");
	      emp.setEmpLocation("Chennai");

        Mockito.when(cbsemployeeservice.getEmployeeById(Mockito.any())).thenReturn(emp);
        Mockito.when(cbsemployeeservice.deleteEmployee(Mockito.any())).thenReturn(true);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.delete(URI, 105).accept(MediaType.APPLICATION_JSON)).andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());

       // Assert.assertNotEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
	}
	private String converttoJson(Object employee) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(employee);
	}
}