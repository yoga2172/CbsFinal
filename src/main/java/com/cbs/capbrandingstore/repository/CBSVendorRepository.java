package com.cbs.capbrandingstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cbs.capbrandingstore.entity.CBSVendor;


/** This is a repository class for CBSVendor module 
 * 
 * @author AbhiRam's
 *
 */

@Repository
public interface CBSVendorRepository extends JpaRepository<CBSVendor, Integer>  {

}
