package com.cbs.capbrandingstore.controller;

/** This is a Controller class for CBSVendor module 
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

import com.cbs.capbrandingstore.entity.CBSVendor;
import com.cbs.capbrandingstore.entity.Cart;
import com.cbs.capbrandingstore.exception.ResourceNotFoundException;
import com.cbs.capbrandingstore.service.CBSVendorServices;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(value="CBSVendorController",description="REST Apis related to Vendor Entity!!!")
@RestController
@RequestMapping("/api/v0")
public class CBSVendorController {

	@Autowired
	private CBSVendorServices cbsvendorservices;
	
	/** 
	 * 
	 *This method returns the list of vendor details  
	 * 
	 * 
	 */
	@ApiOperation(value ="Get list of vendors from  the system",response=Iterable.class)
	@GetMapping("/getAllVendors")
	public List<CBSVendor> getAllVendors() {
		return cbsvendorservices.getAllVendors();
	}
	
	/** This method adds the vendor details 
	 * 
	 * @param CBSVendor entity details 
	 * 
	 * 
	 */
	@ApiOperation(value ="Adding a new  vendor to the system",response=CBSVendor.class)
	@PostMapping("/saveVendor")
	public CBSVendor createVendor( @RequestBody CBSVendor vendor) {
		return cbsvendorservices.saveVendor(vendor);
	} 
	
	/** 
	 * 
	 *This method returns the list of vendor details  
	 * @param CBSVendor - vendorId
	 * 
	 */
	@ApiOperation(value ="Get  vendor by id from  the system",response=CBSVendor.class)
	@GetMapping("/getVendor/{id}")
	public ResponseEntity<CBSVendor> getVendorById(@PathVariable(value = "id") Integer vendorId) throws ResourceNotFoundException {
		CBSVendor cbsvendor = cbsvendorservices.getVendorById(vendorId);
		return  ResponseEntity.ok(cbsvendor);
	}
	
	/** This method updates the vendor details 
	 * 
	 * @param CBSVendor entity details and CBSVendor - vendorId
	 * 
	 * 
	 */
	@ApiOperation(value ="Updat vendors info in the system",response=CBSVendor.class)
	@PutMapping("/updateVendor/{id}")
	public ResponseEntity<CBSVendor> updateVendor(@PathVariable(value = "id") Integer vendorId,
			 @RequestBody CBSVendor vendor) throws ResourceNotFoundException {
		CBSVendor cbsvendor = cbsvendorservices.updateVendorById(vendorId,vendor);
		return  ResponseEntity.ok(cbsvendor);
	}

	/** This method deletes the vendor details 
	 * 
	 * @param CBSVendor entity details and CBSVendor - vendorId
	 * 
	 * 
	 */
	
	@ApiOperation(value ="Delete vendor by id from  the system",response=CBSVendor.class)
	@DeleteMapping("/deleteVendor/{id}")	
	public boolean deleteVendor(@PathVariable(value = "id") Integer vendorId)
			throws ResourceNotFoundException {
		cbsvendorservices.deleteVendor(vendorId);
		return true;
	}
}

