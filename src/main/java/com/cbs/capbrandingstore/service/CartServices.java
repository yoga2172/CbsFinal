package com.cbs.capbrandingstore.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbs.capbrandingstore.entity.Cart;
import com.cbs.capbrandingstore.exception.ResourceNotFoundException;
import com.cbs.capbrandingstore.repository.CartRepository;


/** The CartService class provides access to repository methods to CRUD operations Cart details 
 * 
 * 
 * @author Reshma's
 *
 */

@Service
public class CartServices implements ICartServices {
	
	@Autowired
	private CartRepository cartrepository;
	
	public Cart getProductById(Integer productId)
			throws ResourceNotFoundException {
		return cartrepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :" + productId));
		 
	}
	  
	
	 public boolean deleteProduct(Integer productId)
				throws ResourceNotFoundException {
		 Cart cart = cartrepository.findById(productId)
					.orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + productId));

		 cartrepository.delete(cart);
		 boolean t=false;
		 if(null == cart){
	            t= true;
	        }
	        return t;
	}
	 
	 public Cart updateProductById(Integer productId,Cart product) throws ResourceNotFoundException {
		 Cart cart = cartrepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + productId));
		 cart.setProductName(product.getProductName());
		 cart.setProductPrice(product.getProductPrice());
		 cart.setQuantity(product.getQuantity());
	return cartrepository.save(cart);
		 
		
	}
	 public List<Cart> getAllProducts() {  
			return cartrepository.findAll();
		}
		 
		 public Cart saveProduct(Cart product) {
			return  cartrepository.save(product);
			  
			
		}

}

