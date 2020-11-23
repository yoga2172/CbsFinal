package com.cbs.capbrandingstore.service;

/** This is an interface which defines CRUD methods for Cart service
 * 
 * @author Reshma's
 *
 */


import java.util.List;

import com.cbs.capbrandingstore.entity.Cart;
import com.cbs.capbrandingstore.exception.ResourceNotFoundException;


public interface ICartServices {
	 public List<Cart> getAllProducts();
	 public Cart saveProduct(Cart product);
	 public Cart updateProductById(Integer productId,Cart product) throws ResourceNotFoundException;
	 public boolean deleteProduct(Integer productId) throws ResourceNotFoundException;
	 public Cart getProductById(Integer productId) throws ResourceNotFoundException;
}
