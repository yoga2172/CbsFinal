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

import com.cbs.capbrandingstore.entity.Product;
import com.cbs.capbrandingstore.repository.ProductRepository;

/** The ProductRepositoryTest class provides testing of ProductRepository layer
 *   
 * @author AbhiRam's
 * 
 */
@RunWith(SpringRunner.class)
@DataJpaTest
class ProductRepositoryTest {

	@Autowired
    private ProductRepository productrepository;

    @Autowired
    private TestEntityManager testEntityManager;
    @Test
     void testNewProduct() throws Exception{
        Product product = getProduct();
        Product saveInDb = testEntityManager.persist(product);
        Product getFromInDb = productrepository.findById(saveInDb.getProductId()).get();
        assertThat(getFromInDb).isEqualTo(saveInDb);
    }
	private Product getProduct() {
		Product product=new Product();
		 product.setProductName("Jeans");
		  product.setProductCategory("apparel");
		  product.setProductPrice(2000);
	      product.setQuantity(1000);
		return product;
	}
	@Test
     void testGetProductById() throws Exception{
        Product product = new Product();
        product.setProductName("Watch");
		  product.setProductCategory("Stationery");
		  product.setProductPrice(25000);
	      product.setQuantity(1000);
	
        Product saveInDb = testEntityManager.persist(product);

        Product getInDb = productrepository.findById(product.getProductId()).get();
        assertThat(getInDb).isEqualTo(saveInDb);
	}
	 @Test
	     void testGetAllProducts() throws Exception{
		 Product product = new Product();
		 product.setProductName("Watch");
		  product.setProductCategory("Stationery");
		  product.setProductPrice(25000);
	      product.setQuantity(1000);
	        
	      Product product1 = new Product();
	      product1.setProductName("HandBag");
		  product1.setProductCategory("Stationery");
		  product1.setProductPrice(25000);
	      product1.setQuantity(100);
	        testEntityManager.persist(product); 
	        testEntityManager.persist(product1);

	        List<Product> productList = (List<Product>) productrepository.findAll();

	        Assert.assertEquals(2, productList.size());
	    }
	 @Test
	     void testDeleteCartById() throws Exception{
		 Product product = new Product();
		 product.setProductName("Black Pen");
		  product.setProductCategory("Stationery");
		  product.setProductPrice(25);
	      product.setQuantity(1000);
	        
	      Product product1 = new Product();
	      product1.setProductName("Samsung s7");
		  product1.setProductCategory("Electronics");
		  product1.setProductPrice(250000);
	      product1.setQuantity(3000);

	        Product product2 = testEntityManager.persist(product);
	        testEntityManager.persist(product1);

	        testEntityManager.remove(product2);

	        List<Product> eprod = (List<Product>) productrepository.findAll();
	        Assert.assertEquals(1,eprod.size());

	    }
	 @Test
	   void testUpdateCart(){

		 Product product = new Product();
		 product.setProductName("Electric Cooker");
		  product.setProductCategory("Electronics");
		  product.setProductPrice(35000);
	      product.setQuantity(2000);
	        
	        testEntityManager.persist(product);

	        Product getFromDb = productrepository.findById(product.getProductId()).get();
	        getFromDb.setProductPrice(35000);
	        testEntityManager.persist(getFromDb);

	        assertThat(getFromDb.getProductPrice()).isEqualTo(35000);
	    }


}

