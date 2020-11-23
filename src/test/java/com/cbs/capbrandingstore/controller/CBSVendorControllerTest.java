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

import com.cbs.capbrandingstore.controller.CBSVendorController;
import com.cbs.capbrandingstore.entity.CBSVendor;
import com.cbs.capbrandingstore.service.CBSVendorServices;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/** The CBSVendorControllerTest class provides testing of CBSVendorController layer
 *   
 * @author AbhiRam's
 * 
 */


@RunWith(SpringRunner.class)
@WebMvcTest(value = CBSVendorController.class)

 class CBSVendorControllerTest {

	@Autowired
    private MockMvc mockMvc;

    @MockBean
    private CBSVendorServices cbsvendorservice; 
	@Test
	 void testGetAllProducts() throws Exception {
		String URI = "/api/v0/getAllVendors";
		  CBSVendor vendor = new CBSVendor();
		  vendor.setVendorId(1);
		  vendor.setVendorName("Abhi");
		  vendor.setVendorPhone(6789345);
		  vendor.setVendorEmail("abhi@gmail.com");
		  vendor.setVendorLocation("chennai");
	      CBSVendor vendor1 = new CBSVendor();
	      vendor1.setVendorId(2);
	      vendor1.setVendorName("Ram");
		  vendor1.setVendorPhone(5439345);
		  vendor1.setVendorEmail("ram@gmail.com");
		  vendor1.setVendorLocation("bangalore");
	    	 List<CBSVendor> empList=new ArrayList<>();
	    	  empList.add(vendor);
	    	empList.add(vendor1);
	    	 
	    	String jsonInput = this.converttoJson(empList);

	         Mockito.when(cbsvendorservice.getAllVendors()).thenReturn(empList);
	         MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON)).andReturn();
	         MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	         String jsonOutput = mockHttpServletResponse.getContentAsString();

	         assertThat(jsonInput).isEqualTo(jsonOutput);
	}

	@Test
	 void testCreateProduct() throws Exception {
		String URI = "/api/v0/saveVendor";
		 CBSVendor vendor = new CBSVendor();
		 vendor.setVendorName("Ram");
		  vendor.setVendorPhone(3456345);
		  vendor.setVendorEmail("ram@gmail.com");
		  vendor.setVendorLocation("chennai");
       String jsonInput = this.converttoJson(vendor);

       Mockito.when(cbsvendorservice.saveVendor(Mockito.any(CBSVendor.class))).thenReturn(vendor);
       MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
               .andReturn();
       MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
       String jsonOutput = mockHttpServletResponse.getContentAsString();
       assertThat(jsonInput).isEqualTo(jsonOutput);
       Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
	}

	@Test
	 void testGetProductById() throws Exception {
		String URI= "/api/v0/getVendor/{id}";
		 CBSVendor vendor = new CBSVendor();
		 vendor.setVendorName("AbhiRam");
		  vendor.setVendorPhone(8976345);
		  vendor.setVendorEmail("abhiram@gmail.com");
		  vendor.setVendorLocation("chennai");
       String jsonInput = this.converttoJson(vendor);

       Mockito.when(cbsvendorservice.getVendorById(Mockito.any())).thenReturn(vendor);
       MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI, 102).accept(MediaType.APPLICATION_JSON)).andReturn();
       MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
       String jsonOutput = mockHttpServletResponse.getContentAsString();

       assertThat(jsonInput).isEqualTo(jsonOutput);
	}

	@Test
	 void testUpdateProduct() throws Exception {
		String URI = "/api/v0/updateVendor/{id}";
		CBSVendor vendor = new CBSVendor();
		vendor.setVendorName("Abhir");
		  vendor.setVendorPhone(3466345);
		  vendor.setVendorEmail("abhirm@gmail.com");
		  vendor.setVendorLocation("chennai");
        String jsonInput = this.converttoJson(vendor);

        Mockito.when(cbsvendorservice.updateVendorById(Mockito.any(),Mockito.any())).thenReturn(vendor);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.put(URI,105).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        String jsonOutput = mockHttpServletResponse.getContentAsString();

        assertThat(jsonInput).isEqualTo(jsonOutput);
	}

	@Test
 void testDeleteProduct() throws Exception {
		String URI = "/api/v0/deleteVendor/{id}";
		CBSVendor vendor = new CBSVendor();
		vendor.setVendorName("Ramu");
		  vendor.setVendorPhone(8906345);
		  vendor.setVendorEmail("ramu@gmail.com");
		  vendor.setVendorLocation("chennai");

        Mockito.when(cbsvendorservice.getVendorById(Mockito.any())).thenReturn(vendor);
        Mockito.when(cbsvendorservice.deleteVendor(Mockito.any())).thenReturn(true);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.delete(URI, 105).accept(MediaType.APPLICATION_JSON)).andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
//        Assert.assertNotEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
	}
	private String converttoJson(Object vendor) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(vendor);
	}

}
