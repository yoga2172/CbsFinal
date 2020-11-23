package com.cbs.capbrandingstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cbs.capbrandingstore.entity.Product;


/** This is a repository class for Product module 
 * 
 * @author AbhiRam's
 *
 */

@Repository
public interface ProductRepository extends JpaRepository<Product, Integer> {

}

