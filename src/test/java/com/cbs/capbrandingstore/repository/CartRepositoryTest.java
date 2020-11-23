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

import com.cbs.capbrandingstore.entity.Cart;
import com.cbs.capbrandingstore.repository.CartRepository;

/** The CartRepositoryTest class provides testing of CartRepository layer
 *   
 * @author Reshma's
 * 
 */

@RunWith(SpringRunner.class)
@DataJpaTest
class CartRepositoryTest {
	@Autowired
    private CartRepository cartrepository;

    @Autowired
    private TestEntityManager testEntityManager;
    @Test
     void testNewCart() throws Exception{
        Cart cart = getCart();
        Cart saveInDb = testEntityManager.persist(cart);
        Cart getFromInDb = cartrepository.findById(saveInDb.getProductId()).get();
        assertThat(getFromInDb).isEqualTo(saveInDb);
    }
	private Cart getCart() {
		Cart ecart=new Cart();
		ecart.setProductName("Kurthis");
		ecart.setProductPrice(1000);
		ecart.setQuantity(1);
		return ecart;
	}
	@Test
     void testGetProductById() throws Exception{
        Cart cart = new Cart();
        cart.setProductName("Water Bottle");
		cart.setProductPrice(1500);
	
        Cart saveInDb = testEntityManager.persist(cart);

        Cart getInDb = cartrepository.findById(cart.getProductId()).get();
        assertThat(getInDb).isEqualTo(saveInDb);
	}
	 @Test
	     void testGetAllProducts() throws Exception{
		 Cart cart = new Cart();
		 cart.setProductName("Sandals");
			cart.setProductPrice(100);
			cart.setQuantity(2);
	        
	        Cart ecart = new Cart();
	        ecart.setProductName("Shoes");
			ecart.setProductPrice(1000);
			ecart.setQuantity(2);
	        testEntityManager.persist(cart); 
	        testEntityManager.persist(ecart);

	        List<Cart> cartList = (List<Cart>) cartrepository.findAll();

	        Assert.assertEquals(2, cartList.size());
	    }
	 @Test
	     void testDeleteCartById() throws Exception{
		 Cart cart = new Cart();
		    cart.setProductName("Samsung");
			cart.setProductPrice(60000);
			cart.setQuantity(1);
	        

	        Cart cart1 = new Cart();
	        cart1.setProductName("Nokia");
			cart1.setProductPrice(40000);
			cart1.setQuantity(1);
	        

	        Cart cart2 = testEntityManager.persist(cart);
	        testEntityManager.persist(cart1);

	        testEntityManager.remove(cart2);

	        List<Cart> ecart = (List<Cart>) cartrepository.findAll();
	        Assert.assertEquals(1,ecart.size());

	    }
	 @Test
	     void testUpdateCart(){

		 Cart cart = new Cart();
		 cart.setProductName("Shirt");
			cart.setProductPrice(1600);
			cart.setQuantity(1);
	        
	        testEntityManager.persist(cart);

	        Cart getFromDb = cartrepository.findById(cart.getProductId()).get();
	        getFromDb.setProductPrice(1500);
	        testEntityManager.persist(getFromDb);

	        assertThat(getFromDb.getProductPrice()).isEqualTo(1500);
	    }


}
