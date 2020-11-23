package com.cbs.capbrandingstore.controller;

/** This is a Controller class for Cart module 
 * 
 * @author Reshma's
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

import com.cbs.capbrandingstore.entity.Admin;
import com.cbs.capbrandingstore.entity.Cart;
import com.cbs.capbrandingstore.exception.ResourceNotFoundException;
import com.cbs.capbrandingstore.service.CartServices;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;

@Api(value="CartController",description="REST Apis related to Cart Entity!!!")
@RestController
@RequestMapping("/api/v0")
public class CartController { 
  
	@Autowired
	private CartServices cartservices;
	
	/** 
	 * 
	 *This method returns the list of products details in cart 
	 * 
	 * 
	 */
	@ApiOperation(value ="Get list of products from the cart",response=Cart.class)
	@GetMapping("/getAllProductsFromCart")
	public List<Cart> getAllProductsFromCart() {
		return cartservices.getAllProducts();
	}
	
	/** This method adds the product details 
	 * 
	 * @param Cart entity details
	 * 
	 * 
	 */
	@ApiOperation(value ="Adding a new product to cart",response=Cart.class)
	@PostMapping("/saveCart")
	public Cart createProduct( @RequestBody Cart cartproduct) {
		return cartservices.saveProduct(cartproduct);
	}  
	
	/** 
	 * 
	 *This method returns the list of product details in cart
	 * @param Cart - productId 
	 * 
	 */
	@ApiOperation(value ="Get product from the cart by id",response=Cart.class)
	@GetMapping("/getProductCart/{id}")
	public ResponseEntity<Cart> getProductById(@PathVariable(value = "id") Integer productId) throws ResourceNotFoundException {
		Cart cart = cartservices.getProductById(productId);
		return  ResponseEntity.ok(cart);
	}
	
	/** This method updates the product details 
	 * 
	 * @param Cart entity details and Cart - productId
	 * 
	 * 
	 */
	
	@ApiOperation(value ="Upadate product in the cart",response=Cart.class)
	@PutMapping("/updateCart/{id}")
	public ResponseEntity<Cart> updateProduct(@PathVariable(value = "id") Integer productId,
			 @RequestBody Cart product) throws ResourceNotFoundException {
		Cart companymanager = cartservices.updateProductById(productId, product);
		return  ResponseEntity.ok(companymanager);
	}

	
	/** This method deletes the product details 
	 * 
	 * @param Cart entity details and Cart - productId
	 * 
	 * 
	 */
	@ApiOperation(value ="Delete the product in the cart",response=Cart.class)
	@DeleteMapping("/deleteCart/{id}")	
	public boolean deleteCart(@PathVariable(value = "id") Integer productId)
			throws ResourceNotFoundException {
		cartservices.deleteProduct(productId);
		return true;
	
	}
}