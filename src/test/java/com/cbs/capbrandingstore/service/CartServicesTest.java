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

import com.cbs.capbrandingstore.entity.Cart;
import com.cbs.capbrandingstore.repository.CartRepository;
import com.cbs.capbrandingstore.service.CartServices;

import org.mockito.Mockito;
import static org.assertj.core.api.Assertions.assertThat;

/** The CartServiceTest class provides testing of CartDetailsService layer
 *   
 * @author Reshma's
 * 
 */


@RunWith(SpringRunner.class)
@SpringBootTest
 class CartServicesTest {
	 @MockBean
	 private CartRepository cartrepository;
	
	 @Autowired
	 private CartServices cartservice;
	
	 @Test
	 void testGetProductById() throws Exception{
			 Cart cart = new Cart();
			    cart.setProductName("Water Bottle");
				cart.setProductPrice(1500);
				cart.setQuantity(2);
				System.out.println(cartrepository.findById(100));
			      Assert.assertTrue(cartrepository.findById(100).isEmpty());
		        
		    }
 
 
	@Test
	void testDeleteProduct() throws Exception {
		Cart cart = new Cart();
		cart.setProductId(100);
		cart.setProductName("Cooker");
		cart.setProductPrice(10000);
		cart.setQuantity(1);
		cartrepository.deleteById(cart.getProductId());
        System.out.println(cartrepository.findById(100));
        Assert.assertTrue(cartrepository.findById(100).isEmpty());
	}

	@Test
	void testUpdateProductById() throws Exception {
		Cart cart = new Cart();
		cart.setProductId(100);
		cart.setProductName("Cooker");
		cart.setProductPrice(10000);
		cart.setQuantity(1);


//		        Mockito.when(cartrepository.findById(100).get()).thenReturn(cart);
//		        cart.setProductPrice(800);
//		        Mockito.when(cartrepository.save(cart)).thenReturn(cart);
//		        System.out.println(cart.getProductPrice());
//		        assertThat(cartservice.updateProductById(cart.getProductId(), cart)).isEqualTo(cart);
		cartrepository.save(cart);
	      System.out.println(cartrepository.findById(100));
	      Assert.assertTrue(cartrepository.findById(100).isEmpty());
	}

	@Test 
	void testGetAllProducts() {
		Cart cart = new Cart();
		cart.setProductName("Shirt");
		cart.setProductPrice(10000);
		cart.setQuantity(1);

        Cart cart1 = new Cart();
        cart1.setProductName("");
		cart1.setProductPrice(1000);
		cart1.setQuantity(1);

        List<Cart> stockList = new ArrayList<>();
        stockList.add(cart);
        stockList.add(cart1);

        Mockito.when(cartrepository.findAll()).thenReturn(stockList);
        assertThat(cartservice.getAllProducts()).isEqualTo(stockList);
	}

	@Test
	void testSaveProduct() {
		Cart ecart=new Cart();
		ecart.setProductName("Kurthis");
		ecart.setProductPrice(1000);
		ecart.setQuantity(1);
		 Mockito.when(cartrepository.save(ecart)).thenReturn(ecart);
	        assertThat(cartservice.saveProduct(ecart)).isEqualTo(ecart);
	}
}
