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

import com.cbs.capbrandingstore.entity.Product;
import com.cbs.capbrandingstore.repository.ProductRepository;
import org.mockito.Mockito;
import static org.assertj.core.api.Assertions.assertThat;


/** The ProductServiceTest class provides testing of ProductDetailsService layer
 *   
 * @author AbhiRam's
 * 
 */

@RunWith(SpringRunner.class)
@SpringBootTest

class ProductServicesTest {

	@MockBean
	 private ProductRepository productrepository;
	
	 @Autowired
	 private ProductServices productservice;
	@Test
	void testGetProductById() {
		 Product product = new Product();
		 product.setProductName("Jeans");
		  product.setProductCategory("apparel");
		  product.setProductPrice(2000);
	      product.setQuantity(1000);
			System.out.println(productrepository.findById(100));
		      Assert.assertTrue(productrepository.findById(100).isEmpty());
	}

	@Test
	void testDeleteProduct() {
		Product product = new Product();
		 product.setProductName("Sarees");
		  product.setProductCategory("apparel");
		  product.setProductPrice(12000);
	      product.setQuantity(1000);
	      productrepository.deleteById(product.getProductId());
        System.out.println(productrepository.findById(100));
        Assert.assertTrue(productrepository.findById(100).isEmpty());
	}

	@Test
	void testUpdateProductById() {
		Product product = new Product();
		 product.setProductName("Sarees");
		  product.setProductCategory("apparel");
		  product.setProductPrice(12000);
	      product.setQuantity(1000);
		productrepository.save(product);
	      System.out.println(productrepository.findById(100));
	      Assert.assertTrue(productrepository.findById(100).isEmpty());
	}

	@Test
	void testGetAllProducts() {
		Product product = new Product();
		 product.setProductName("Pen");
		  product.setProductCategory("Stationery");
		  product.setProductPrice(12);
	      product.setQuantity(1000);

	      Product product1 = new Product();
			 product1.setProductName("Cello Tape");
			  product1.setProductCategory("Stationery");
			  product1.setProductPrice(5);
		      product1.setQuantity(10000);

        List<Product> productList = new ArrayList<>();
        productList.add(product);
        productList.add(product1);

        Mockito.when(productrepository.findAll()).thenReturn(productList);
        assertThat(productservice.getAllProducts()).isEqualTo(productList);
	}

	@Test
	void testSaveProduct() {
		Product product = new Product();
		 product.setProductName("Penpencil");
		  product.setProductCategory("Stationery");
		  product.setProductPrice(10);
	      product.setQuantity(1000);
		 Mockito.when(productrepository.save(product)).thenReturn(product);
	        assertThat(productservice.saveProduct(product)).isEqualTo(product);
	}

}
