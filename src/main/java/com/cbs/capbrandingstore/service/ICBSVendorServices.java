package com.cbs.capbrandingstore.service;


/** This is an interface which defines CRUD methods for CBSVendor service
 * 
 * @author AbhiRam's
 *
 */

import java.util.List;

import com.cbs.capbrandingstore.entity.CBSVendor;
import com.cbs.capbrandingstore.exception.ResourceNotFoundException;


public interface ICBSVendorServices {
	 public List<CBSVendor> getAllVendors();
	 public CBSVendor getVendorById(Integer vendorId) throws ResourceNotFoundException;
	 public boolean deleteVendor(Integer vendorId) throws ResourceNotFoundException;
	 public CBSVendor updateVendorById(Integer vendorId,CBSVendor vendor) throws ResourceNotFoundException;
	 public CBSVendor saveVendor(CBSVendor vendor);
}

