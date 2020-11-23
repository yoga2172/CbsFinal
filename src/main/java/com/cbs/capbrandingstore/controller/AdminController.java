package com.cbs.capbrandingstore.controller;


/** This is a Controller class for Admin module 
 * 
 * @author Yoga's
 *
 */



import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
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
import com.cbs.capbrandingstore.exception.ResourceNotFoundException;
import com.cbs.capbrandingstore.service.AdminService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(value="AdminController",description="REST Apis related to Admin Entity!!!")
@RestController
@RequestMapping("/api/v0")
public class AdminController {
	@Autowired
	private AdminService adminService;
	private static final Logger log = LogManager.getLogger(AdminController.class);
	
	
	/** 
	 * 
	 *This method returns the list of admin details 
	 * 
	 * 
	 */
	
	@ApiOperation(value ="Get list of Admins in the System",response=Iterable.class)
	@GetMapping("/Admin")
	public List<Admin> getAlladmins() {
		log.info(getAlladmins());
		return adminService.getAlladmins();
	} 

	
	/** 
	 * 
	 *This method returns the list of admin details 
	 * @param Admin - adminId 
	 * 
	 */
	@ApiOperation(value ="Get Admin by id in the System",response=Admin.class)
	@GetMapping("/Admin/{id}")
	public ResponseEntity<Admin> getAdminById(@PathVariable(value = "id") Integer adminId) throws ResourceNotFoundException {
		Admin admin = adminService.getadminById(adminId);
		log.info("Success");
		return  ResponseEntity.ok(admin);
	}
	
	/** This method adds the admin details 
	 * 
	 * @param Admin - admin entity details
	 * 
	 * 
	 */
	@ApiOperation(value ="Adding a new Admin in the System",response=Admin.class)
	@PostMapping("/Admin")
	public Admin createadmin( @RequestBody Admin admin) {
		log.info(admin);
		return adminService.createadmin(admin);
		
	}

	
	/** This method updates the admin details 
	 * 
	 * @param Admin - admin entity details and adminId
	 * 
	 * 
	 */
	@ApiOperation(value ="Updating Admin Information in the System by id",response=Admin.class)
	@PutMapping("/Admin/{id}")
	public ResponseEntity<Admin> updateadmin(@PathVariable(value = "id") Integer adminId,
			 @RequestBody Admin adminDetails) throws ResourceNotFoundException {
		
		Admin admin=adminService.updateadmin(adminId, adminDetails);
		log.info(admin);
		return ResponseEntity.ok(admin);
	}
	
	/** This method deletes the admin details 
	 * 
	 * @param Admin - admin entity details and adminId
	 * 
	 * 
	 */
	@ApiOperation(value ="Deleting a Admin in the System by id",response=Admin.class)
	@DeleteMapping("/Admin/{id}")
	public boolean deleteadmin(@PathVariable(value = "id") Integer adminId)
			throws ResourceNotFoundException {
		adminService.deleteadmin(adminId);
		log.info("Success");
		return true;
	
	}
	
}
