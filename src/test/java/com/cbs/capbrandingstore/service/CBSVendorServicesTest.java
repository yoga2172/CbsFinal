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

import com.cbs.capbrandingstore.entity.CBSVendor;
import com.cbs.capbrandingstore.repository.CBSVendorRepository;
import com.cbs.capbrandingstore.service.CBSVendorServices;

import org.mockito.Mockito;
import static org.assertj.core.api.Assertions.assertThat;


/** The CBSVendorServiceTest class provides testing of CBSVendorDetailsService layer
 *   
 * @author AbhiRam's
 * 
 */

@RunWith(SpringRunner.class)
@SpringBootTest
class CBSVendorServicesTest {

	@MockBean
	 private CBSVendorRepository vendorRepository;
	
	 @Autowired
	 private CBSVendorServices vendorServices;
	@Test
	void testGetVendorById() {
		CBSVendor vendor = new CBSVendor();
		vendor.setVendorId(3);
		vendor.setVendorName("Abhi");
		  vendor.setVendorPhone(6789345);
		  vendor.setVendorEmail("abhi@gmail.com");
		  vendor.setVendorLocation("chennai");
	     
	      System.out.println(vendorRepository.findById(3));
	      Assert.assertTrue(vendorRepository.findById(3).isEmpty());
	}

	@Test
	void testDeleteVendor() {
		CBSVendor vendor = new CBSVendor();
		vendor.setVendorId(4);
		vendor.setVendorName("Ram");
		  vendor.setVendorPhone(6579345);
		  vendor.setVendorEmail("ram@gmail.com");
		  vendor.setVendorLocation("chennai");
	        
		  vendorRepository.deleteById(vendor.getVendorId());
      System.out.println(vendorRepository.findById(3));
      Assert.assertTrue(vendorRepository.findById(3).isEmpty());
	}

	@Test
	void testUpdateVendorById() {
		CBSVendor vendor = new CBSVendor();
		vendor.setVendorId(4);
		vendor.setVendorName("Abhir");
		  vendor.setVendorPhone(4567345);
		  vendor.setVendorEmail("abhir@gmail.com");
		  vendor.setVendorLocation("chennai");
	         
	      vendorRepository.save(vendor);
    System.out.println(vendorRepository.findById(100));
    Assert.assertTrue(vendorRepository.findById(100).isEmpty());
	}

	@Test
	void testGetAllVendors() {
		 CBSVendor vendor = new CBSVendor();
		 vendor.setVendorId(2); 
		 vendor.setVendorName("Ramu");
		  vendor.setVendorPhone(78989345);
		  vendor.setVendorEmail("ramu@gmail.com");
		  vendor.setVendorLocation("chennai");
	      CBSVendor vendor1 = new CBSVendor();
	      vendor1.setVendorName("Abhi");
		  vendor1.setVendorPhone(6789345);
		  vendor1.setVendorEmail("abhi@gmail.com");
		  vendor1.setVendorLocation("chennai");
      List<CBSVendor> empList = new ArrayList<>();
      empList.add(vendor);
      empList.add(vendor1);

      Mockito.when(vendorRepository.findAll()).thenReturn(empList);
      assertThat(vendorServices.getAllVendors()).isEqualTo(empList);
	}

	@Test
	void testSaveVendor() {
		 CBSVendor vendor = new CBSVendor();
		 vendor.setVendorId(1); 
		 vendor.setVendorName("Vinod");
		  vendor.setVendorPhone(2349345);
		  vendor.setVendorEmail("vinod@gmail.com");
		  vendor.setVendorLocation("chennai");

        Mockito.when(vendorRepository.save(vendor)).thenReturn(vendor);
        assertThat(vendorServices.saveVendor(vendor)).isEqualTo(vendor);
	}

}
