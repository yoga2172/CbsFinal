package com.cbs.capbrandingstore.service;

/** This is an interface which defines CRUD methods for Product service
 * 
 * @author AbhiRam's
 *
 */


import java.util.List;

import com.cbs.capbrandingstore.entity.Product;
import com.cbs.capbrandingstore.exception.ResourceNotFoundException;


public interface IProductServices {
	 public List<Product> getAllProducts();
	 public Product saveProduct(Product product);
	 public Product updateProductById(Integer productId,Product product) throws ResourceNotFoundException;
	 public boolean deleteProduct(Integer productId) throws ResourceNotFoundException;
	 public Product getProductById(Integer productId) throws ResourceNotFoundException;
}

