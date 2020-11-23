package com.cbs.capbrandingstore.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbs.capbrandingstore.entity.Product;
import com.cbs.capbrandingstore.exception.ResourceNotFoundException;
import com.cbs.capbrandingstore.repository.ProductRepository;

/** The ProductService class provides access to repository methods to CRUD operations Product details 
 * 
 * 
 * @author AbhiRam's
 *
 */

@Service
public class ProductServices implements IProductServices {
	String p="Product not found for this id :: ";
	
	@Autowired
	private ProductRepository productrepository;
	
	public Product getProductById(Integer productId)
			throws ResourceNotFoundException {
		return productrepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException(p + productId));
		
	}
	
	
	 public boolean deleteProduct(Integer productId)
				throws ResourceNotFoundException {
		 Product product = productrepository.findById(productId)
					.orElseThrow(() -> new ResourceNotFoundException(p + productId));

		 productrepository.delete(product);
		 boolean t=false;
		 if(null == product){
	            t= true;
	        }
	        return t;
	}
	 
	 public Product updateProductById(Integer productId,Product product) throws ResourceNotFoundException {
		 Product prod = productrepository.findById(productId)
				.orElseThrow(() -> new ResourceNotFoundException(p + productId));
		 prod.setProductName(product.getProductName());
		 prod.setProductPrice(product.getProductPrice());
		 prod.setQuantity(product.getQuantity());
		return productrepository.save(product);
		
		
	}
	 public List<Product> getAllProducts() {
			return productrepository.findAll();
		}
		 
		 public Product saveProduct(Product product) {
			return  productrepository.save(product);
			  
			
		}

}
