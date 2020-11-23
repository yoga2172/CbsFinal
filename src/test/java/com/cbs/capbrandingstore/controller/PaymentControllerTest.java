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
import com.cbs.capbrandingstore.entity.Payment;
import com.cbs.capbrandingstore.service.PaymentServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/** The PaymentControllerTest class provides testing of PaymentController layer
 *   
 * @author Yoga's
 * 
 */


@RunWith(SpringRunner.class)
@WebMvcTest(value = PaymentController.class)
class PaymentControllerTest {

	 @Autowired
	    private MockMvc mockMvc;

	    @MockBean
	    private PaymentServiceImpl paymentservice; 
	@Test
	void testGetAllpayments() throws Exception {
		String URI = "/api/v0/Payment";
		 Payment pay = new Payment();
		  pay.setEmpLocation("chennai");
		  pay.setProductCategory("apparel");
		  pay.setProductName("kurthis");
		  pay.setVendorLocation("delhi");
		  Payment pay1 = new Payment();
		  pay1.setEmpLocation("Bangalore");
		  pay1.setProductCategory("apparel");
		  pay1.setProductName("paijamas");
		  pay1.setVendorLocation("delhi");
	    	 List<Payment> payList=new ArrayList<>();
	    	 payList.add(pay);
	    	 payList.add(pay1);
	    	 
	    	String jsonInput = this.converttoJson(payList);

	         Mockito.when(paymentservice.getAllpayments()).thenReturn(payList);
	         MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON)).andReturn();
	         MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	         String jsonOutput = mockHttpServletResponse.getContentAsString();

	         assertThat(jsonInput).isEqualTo(jsonOutput);
	}

	private String converttoJson(Object payment) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(payment);
	}

	@Test
	void testGetpaymentById() throws Exception {
		String URI= "/api/v0/Payment/{id}";
		Payment pay = new Payment();
		  pay.setEmpLocation("chennai");
		  pay.setProductCategory("Electronics");
		  pay.setProductName("electric cooker");
		  pay.setVendorLocation("bangalore");
       String jsonInput = this.converttoJson(pay);

       Mockito.when(paymentservice.getpaymentById(Mockito.any())).thenReturn(pay);
       MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI, 102).accept(MediaType.APPLICATION_JSON)).andReturn();
       MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
       String jsonOutput = mockHttpServletResponse.getContentAsString();

       assertThat(jsonInput).isEqualTo(jsonOutput);
	}

	@Test
	void testCreatepayment() throws Exception {
		String URI = "/api/v0/Payment"; 
		Payment pay = new Payment();
		  pay.setEmpLocation("delhi");
		  pay.setProductCategory("Electronics");
		  pay.setProductName("samsung");
		  pay.setVendorLocation("bangalore");
       String jsonInput = this.converttoJson(pay);

       Mockito.when(paymentservice.createpayment(Mockito.any(Payment.class))).thenReturn(pay);
       MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
               .andReturn();
       MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
       String jsonOutput = mockHttpServletResponse.getContentAsString();
       assertThat(jsonInput).isEqualTo(jsonOutput);
       Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
	}

	@Test
	void testUpdatepayment() throws Exception {
		String URI = "/api/v0/Payment/{id}";
		Payment pay = new Payment();
		  pay.setEmpLocation("Andhra");
		  pay.setProductCategory("Stationery");
		  pay.setProductName("pen");
		  pay.setVendorLocation("delhi");
        String jsonInput = this.converttoJson(pay);

        Mockito.when(paymentservice.updatepayment(Mockito.any(),Mockito.any())).thenReturn(pay);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.put(URI,105).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        String jsonOutput = mockHttpServletResponse.getContentAsString();

        assertThat(jsonInput).isEqualTo(jsonOutput);
	}

	@Test
	void testDeletepayment() throws Exception {
		String URI = "/api/v0/Payment/{id}";
		Payment pay = new Payment();
		  pay.setEmpLocation("Andhra");
		  pay.setProductCategory("Stationery");
		  pay.setProductName("penpencil");
		  pay.setVendorLocation("chennai");

       Mockito.when(paymentservice.getpaymentById(Mockito.any())).thenReturn(pay);
       Mockito.when(paymentservice.deletepayment(Mockito.any())).thenReturn(true);
       MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.delete(URI, 105).accept(MediaType.APPLICATION_JSON)).andReturn();
       MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();

       Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
	}

}
