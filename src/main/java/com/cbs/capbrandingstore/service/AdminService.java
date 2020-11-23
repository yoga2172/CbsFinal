package com.cbs.capbrandingstore.service;


/** This is an interface which defines CRUD methods for Admin service
 * 
 * @author Yoga's
 *
 */



import java.util.List;

import com.cbs.capbrandingstore.entity.Admin;
import com.cbs.capbrandingstore.exception.ResourceNotFoundException;

public interface AdminService {

	List<Admin> getAlladmins();

	Admin createadmin(Admin admin);

	Admin updateadmin(Integer adminId, Admin adminDetails) throws ResourceNotFoundException;

	boolean deleteadmin(Integer adminId) throws ResourceNotFoundException;

	Admin getadminById(Integer adminId) throws ResourceNotFoundException ;

}
