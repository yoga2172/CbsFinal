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

import com.cbs.capbrandingstore.controller.CartController;
import com.cbs.capbrandingstore.entity.Cart;
import com.cbs.capbrandingstore.service.CartServices;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/** The CartControllerTest class provides testing of CartController layer
 *   
 * @author Reshma's
 * 
 */

@RunWith(SpringRunner.class)
@WebMvcTest(value = CartController.class)
 class CartControllerTest {

	 @Autowired
	    private MockMvc mockMvc;

	    @MockBean
	    private CartServices cartservice; 
	@Test
	 void testCreateProduct() throws Exception{
	        String URI = "/api/v0/saveCart";
	        Cart cart = new Cart();
	        cart.setProductName("Water Bottle");
			cart.setProductPrice(1500);
			cart.setQuantity(2);
	        String jsonInput = this.converttoJson(cart);

	        Mockito.when(cartservice.saveProduct(Mockito.any(Cart.class))).thenReturn(cart);
	        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
	                .andReturn();
	        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	        String jsonOutput = mockHttpServletResponse.getContentAsString();
	        assertThat(jsonInput).isEqualTo(jsonOutput);
	        Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
	    }
	  

	@Test
	void testGetProductById() throws Exception {
		String URI= "/api/v0/getProductCart/{id}";
        Cart cart = new Cart();
        cart.setProductName("Sandals");
		cart.setProductPrice(100);
		cart.setQuantity(2);
        String jsonInput = this.converttoJson(cart);

        Mockito.when(cartservice.getProductById(Mockito.any())).thenReturn(cart);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI, 102).accept(MediaType.APPLICATION_JSON)).andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        String jsonOutput = mockHttpServletResponse.getContentAsString();

        assertThat(jsonInput).isEqualTo(jsonOutput);
	}

	@Test
	void testUpdateProduct() throws Exception {
		String URI = "/api/v0/updateCart/{id}";
        Cart cart = new Cart();
        cart.setProductName("Shoes");
		cart.setProductPrice(1000);
		cart.setQuantity(2);
        String jsonInput = this.converttoJson(cart);

        Mockito.when(cartservice.updateProductById(Mockito.any(),Mockito.any())).thenReturn(cart);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.put(URI,105).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        String jsonOutput = mockHttpServletResponse.getContentAsString();

        assertThat(jsonInput).isEqualTo(jsonOutput);
	}

	@Test
	void testDeleteProduct() throws Exception {
		String URI = "/api/v0/deleteCart/{id}";
        Cart cart = new Cart();
        cart.setProductId(105);
        cart.setProductName("Cooker");
		cart.setProductPrice(10000);
		cart.setQuantity(1);

        Mockito.when(cartservice.getProductById(Mockito.any())).thenReturn(cart);
        Mockito.when(cartservice.deleteProduct(Mockito.any())).thenReturn(true);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.delete(URI, 105).accept(MediaType.APPLICATION_JSON)).andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
//        Assert.assertNotEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
	}
	@Test
	void testGetAllProductsFromCart() throws Exception {
		String URI = "/api/v0/getAllProductsFromCart";
		  Cart cart = new Cart();
		  cart.setProductName("Sandals"); 
			cart.setProductPrice(100);
			cart.setQuantity(2);
	        
	        Cart cart1 = new Cart();
	        cart1.setProductName("Shoes");
			cart1.setProductPrice(1000);
			cart1.setQuantity(2);
	    	 List<Cart> cartList=new ArrayList<>();
	    	  cartList.add(cart);
	    	cartList.add(cart1);
	    	 
	    	String jsonInput = this.converttoJson(cartList);

	         Mockito.when(cartservice.getAllProducts()).thenReturn(cartList);
	         MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON)).andReturn();
	         MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	         String jsonOutput = mockHttpServletResponse.getContentAsString();

	         assertThat(jsonInput).isEqualTo(jsonOutput);
	     }
	private String converttoJson(Object cart) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(cart);
	}
}

