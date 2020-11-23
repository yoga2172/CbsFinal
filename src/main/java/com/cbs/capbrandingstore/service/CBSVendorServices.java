package com.cbs.capbrandingstore.service;


/** The CBSVendorService class provides access to repository methods to CRUD operations CBSVendor details 
 * 
 * 
 * @author AbhiRam's
 *
 */


import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbs.capbrandingstore.entity.CBSVendor;
import com.cbs.capbrandingstore.exception.ResourceNotFoundException;
import com.cbs.capbrandingstore.repository.CBSVendorRepository;


@Service

public class CBSVendorServices implements ICBSVendorServices {

	@Autowired 
	private CBSVendorRepository cbsvendorrepository;
	
	public CBSVendor getVendorById(Integer vendorId) throws ResourceNotFoundException {
		return cbsvendorrepository.findById(vendorId)
				.orElseThrow(() -> new ResourceNotFoundException("Vendor not found for this id :: " + vendorId));
		
	}
	 public boolean deleteVendor(Integer vendorId) throws ResourceNotFoundException {
		 CBSVendor vendor = cbsvendorrepository.findById(vendorId)
					.orElseThrow(() -> new ResourceNotFoundException("Vendor not found for this id :: " + vendorId));

		 cbsvendorrepository.delete(vendor);
		 boolean t=false;
		 if(null == vendor){
	            t= true;
	        }
	        return t;
	}
	 public CBSVendor updateVendorById(Integer vendorId,CBSVendor vendor) throws ResourceNotFoundException {
		 CBSVendor vend = cbsvendorrepository.findById(vendorId)
				.orElseThrow(() -> new ResourceNotFoundException("Product not found for this id :: " + vendorId));
		 vend.setVendorName(vendor.getVendorName());
		 vend.setVendorPhone(vendor.getVendorPhone());
		 vend.setVendorEmail(vendor.getVendorEmail());
		 vend.setVendorLocation(vendor.getVendorLocation());
	return cbsvendorrepository.save(vendor);
		
		}
	 public List<CBSVendor> getAllVendors() {
			return cbsvendorrepository.findAll();
		}
		 
		 public CBSVendor saveVendor(CBSVendor vendor) {
			return  cbsvendorrepository.save(vendor);
			  
			
		}
}

