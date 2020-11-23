package com.cbs.capbrandingstore.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.cbs.capbrandingstore.entity.Admin;
import com.cbs.capbrandingstore.exception.ResourceNotFoundException;
import com.cbs.capbrandingstore.repository.AdminRepository;


/** The AdminServiceImpl class provides access to repository methods to CRUD operations Admin details 
 * 
 * 
 * @author Yoga's
 *
 */


@Service
@Transactional
public class AdminServiceImpl  implements AdminService {
	@Autowired
	private AdminRepository adminRepository;
	
	@Override
	public List<Admin> getAlladmins() {
		return adminRepository.findAll();
	}

	@Override
	public Admin createadmin(Admin admin) {
		return adminRepository.save(admin);
	}
 
	@Override
	public Admin updateadmin(Integer adminId, Admin adminDetails)throws ResourceNotFoundException {
		Admin admin = adminRepository.findById(adminId)
				.orElseThrow(() -> new ResourceNotFoundException("Admin not found for this id :" + adminId));

		admin.setAdminEmail(adminDetails.getAdminEmail());
		admin.setAdminName(adminDetails.getAdminName());
		admin.setAdminPhone(adminDetails.getAdminPhone());
		return adminRepository.save(admin);
		

	}

	@Override
	public boolean deleteadmin(Integer adminId) throws ResourceNotFoundException {
		Admin admin = adminRepository.findById(adminId)
				.orElseThrow(() -> new ResourceNotFoundException("Admin not found for this id :: " + adminId));
		adminRepository.delete(admin);
		return true;
	
	}

	@Override
	public Admin getadminById(Integer adminId) throws ResourceNotFoundException {
		return adminRepository.findById(adminId).orElseThrow(() -> new ResourceNotFoundException("Admin not found for this id ::" + adminId));
		
	}




	
}
