package com.cbs.capbrandingstore.service;

import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.cbs.capbrandingstore.entity.Admin;
import com.cbs.capbrandingstore.repository.AdminRepository;
import com.cbs.capbrandingstore.service.AdminServiceImpl;

import org.mockito.Mockito;
import static org.assertj.core.api.Assertions.assertThat;

/** The AdminServiceImplTest class provides testing of AdminServiceImplService layer
 *   
 * @author Yoga's
 * 
 */



@RunWith(SpringRunner.class)
@SpringBootTest
class AdminServiceImplTest {

	 @MockBean
	 private AdminRepository adminrepository;
	
	 @Autowired
	 private AdminServiceImpl adminservice;
	@Test
	void testGetAlladmins() {
		Admin admin = new Admin();
		 
		 admin.setAdminName("Yoga");
		  admin.setAdminPhone(345678289);
		  admin.setAdminEmail("yoga@gmail.com");
		  Admin admin1 = new Admin();
		  
		  admin1.setAdminName("Anandh");
		  admin1.setAdminPhone(543678298);
		  admin1.setAdminEmail("anandh@gmail.com");
      List<Admin> adminList = new ArrayList<>();
      adminList.add(admin);
      adminList.add(admin1);

      Mockito.when(adminrepository.findAll()).thenReturn(adminList);
      assertThat(adminservice.getAlladmins()).isEqualTo(adminList);
	}

	@Test
	void testCreateadmin() {
		 Admin admin = new Admin();
		  admin.setAdminName("Reddy");
		  admin.setAdminPhone(432178289);
		  admin.setAdminEmail("reddy@gmail.com");
		  Mockito.when(adminrepository.save(admin)).thenReturn(admin);
	        assertThat(adminservice.createadmin(admin)).isEqualTo(admin);
	}

	@Test
	void testUpdateadmin() {
		 Admin admin = new Admin();
		  admin.setAdminName("ReddyYoga");
		  admin.setAdminPhone(987178289);
		  admin.setAdminEmail("reddyyoga@gmail.com");
	         
		  adminrepository.save(admin);
    System.out.println(adminrepository.findById(100));
    Assert.assertTrue(adminrepository.findById(100).isEmpty());
	}

	@Test
	void testDeleteadmin() {
		Admin admin = new Admin();
		  admin.setAdminName("Yogi");
		  admin.setAdminPhone(345678289);
		  admin.setAdminEmail("reddyyogi@gmail.com");
		  adminrepository.deleteById(admin.getAdminId());
	        System.out.println(adminrepository.findById(100));
	        Assert.assertTrue(adminrepository.findById(100).isEmpty());
	}

	@Test
	void testGetadminById() {
		Admin admin = new Admin();
		 admin.setAdminName("YogaReddy");
		  admin.setAdminPhone(567878289);
		  admin.setAdminEmail("yogareddy@gmail.com");
		  System.out.println(adminrepository.findById(100));
	      Assert.assertTrue(adminrepository.findById(100).isEmpty());
	}

}
