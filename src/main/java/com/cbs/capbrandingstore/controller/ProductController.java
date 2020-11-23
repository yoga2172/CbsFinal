package com.cbs.capbrandingstore.controller;


/** This is a Controller class for Product module 
 * 
 * @author AbhiRam's
 *
 */


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cbs.capbrandingstore.entity.Product;
import com.cbs.capbrandingstore.exception.ResourceNotFoundException;
import com.cbs.capbrandingstore.service.ProductServices;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="ProductController",description="REST Apis related to Product Entity!!!")
@RestController
@RequestMapping("/api/v0")
public class ProductController {
 
	@Autowired
	private ProductServices productservices;
	
	/** 
	 * 
	 *This method returns the list of products details  
	 * 
	 * 
	 */
	@ApiOperation(value ="Get list of Products from  the system",response=Iterable.class)
	@GetMapping("/getAllProducts")
	public List<Product> getAllProducts() {
		return productservices.getAllProducts();
	}
	
	/** This method adds the product details 
	 * 
	 * @param Product entity details
	 * 
	 * 
	 */
	@ApiOperation(value ="Adding a Products to the system",response=Product.class)
	@PostMapping("/saveProduct")
	public Product createProduct( @RequestBody Product product) {
		return productservices.saveProduct(product);
	} 
	
	/** 
	 * 
	 *This method returns the list of product details
	 * @param Product - productId 
	 * 
	 */
	@ApiOperation(value ="Get Product by id from the system",response=Product.class)
	@GetMapping("/getProduct/{id}")
	public ResponseEntity<Product> getProductById(@PathVariable(value = "id") Integer productId) throws ResourceNotFoundException {
		Product product = productservices.getProductById(productId);
		return  ResponseEntity.ok(product);
	}
	
	/** This method updates the product details 
	 * 
	 * @param Product entity details and Product - productId
	 * 
	 * 
	 */
	@ApiOperation(value ="Update a Product info in the system",response=Product.class)
	@PutMapping("/updateProduct/{id}")
	public ResponseEntity<Product> updateProduct(@PathVariable(value = "id") Integer productId,
			 @RequestBody Product product) throws ResourceNotFoundException {
		Product companymanager = productservices.updateProductById(productId, product);
		return  ResponseEntity.ok(companymanager);
	}

	
	/** This method deletes the product details 
	 * 
	 * @param Product entity details and Product - productId
	 * 
	 * 
	 */
	@ApiOperation(value ="Deleting a Product by id from the system",response=Product.class)
	@DeleteMapping("/deleteProduct/{id}")	
	public boolean deleteProduct(@PathVariable(value = "id") Integer productId)
			throws ResourceNotFoundException {
		productservices.deleteProduct(productId);
		return true;
	
	}
}

