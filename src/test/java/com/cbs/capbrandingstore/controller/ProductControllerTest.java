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
import com.cbs.capbrandingstore.entity.Product;
import com.cbs.capbrandingstore.service.ProductServices;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/** The ProductControllerTest class provides testing of ProductController layer
 *   
 * @author AbhiRam's
 * 
 */


@RunWith(SpringRunner.class)
@WebMvcTest(value = ProductController.class)
 class ProductControllerTest {


	 @Autowired
	    private MockMvc mockMvc;

	    @MockBean
	    private ProductServices productservice; 
	    
	@Test
	void testGetAllProducts() throws Exception {
		String URI = "/api/v0/getAllProducts";
		 Product product = new Product();
		  product.setProductName("water bottle");
		  product.setProductCategory("stationery");
		  product.setProductPrice(100);
	      product.setQuantity(10);
	      Product product1 = new Product();
	      product1.setProductName("washing machine");
		  product1.setProductCategory("Electronics");
		  product1.setProductPrice(100000);
	      product1.setQuantity(100);
	    	 List<Product> productList=new ArrayList<>();
	    	  productList.add(product);
	    	productList.add(product1);
	    	 
	    	String jsonInput = this.converttoJson(productList);

	         Mockito.when(productservice.getAllProducts()).thenReturn(productList);
	         MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON)).andReturn();
	         MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	         String jsonOutput = mockHttpServletResponse.getContentAsString();

	         assertThat(jsonInput).isEqualTo(jsonOutput);
	}

	@Test
	void testCreateProduct() throws Exception {
		 String URI = "/api/v0/saveProduct";
		 Product product = new Product();
		  product.setProductName("shirt");
		  product.setProductCategory("apparel");
		  product.setProductPrice(1000);
	      product.setQuantity(10);
	        String jsonInput = this.converttoJson(product);

	        Mockito.when(productservice.saveProduct(Mockito.any(Product.class))).thenReturn(product);
	        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
	                .andReturn();
	        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	        String jsonOutput = mockHttpServletResponse.getContentAsString();
	        assertThat(jsonInput).isEqualTo(jsonOutput);
	        Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
	}

	@Test
	void testGetProductById() throws Exception {
		String URI= "/api/v0/getProduct/{id}";
		Product product = new Product();
		product.setProductId(1);  
		product.setProductName("kurthis");
		  product.setProductCategory("apparel");
		  product.setProductPrice(1000);
	      product.setQuantity(100);
        String jsonInput = this.converttoJson(product);

        Mockito.when(productservice.getProductById(Mockito.any())).thenReturn(product);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI, 102).accept(MediaType.APPLICATION_JSON)).andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        String jsonOutput = mockHttpServletResponse.getContentAsString();

        assertThat(jsonInput).isEqualTo(jsonOutput);
	}

	@Test
	void testUpdateProduct() throws Exception {
		String URI = "/api/v0/updateProduct/{id}";
		Product product = new Product();
		  product.setProductName("paijamas");
		  product.setProductCategory("apparel");
		  product.setProductPrice(2000);
	      product.setQuantity(100);
        String jsonInput = this.converttoJson(product);

        Mockito.when(productservice.updateProductById(Mockito.any(),Mockito.any())).thenReturn(product);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.put(URI,105).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        String jsonOutput = mockHttpServletResponse.getContentAsString();

        assertThat(jsonInput).isEqualTo(jsonOutput);
	}

	@Test
	void testDeleteProduct() throws Exception {
		String URI = "/api/v0/deleteProduct/{id}";
		Product product = new Product();
		  product.setProductName("Jeans");
		  product.setProductCategory("apparel");
		  product.setProductPrice(2000);
	      product.setQuantity(1000);

        Mockito.when(productservice.getProductById(Mockito.any())).thenReturn(product);
        Mockito.when(productservice.deleteProduct(Mockito.any())).thenReturn(true);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.delete(URI, 105).accept(MediaType.APPLICATION_JSON)).andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());

//        Assert.assertNotEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
	}
	private String converttoJson(Object product) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(product);
	}

}
