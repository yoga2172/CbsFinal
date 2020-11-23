package com.cbs.capbrandingstore.repository;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.List;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;
import org.springframework.boot.test.autoconfigure.orm.jpa.TestEntityManager;
import org.springframework.test.context.junit4.SpringRunner;

import com.cbs.capbrandingstore.entity.CBSVendor;
import com.cbs.capbrandingstore.repository.CBSVendorRepository;

/** The CBSVendorRepositoryTest class provides testing of CBSVendorRepository layer
 *   
 * @author Reshma's
 * 
 */

@RunWith(SpringRunner.class)
@DataJpaTest
class CBSVendorRepositoryTest {

	@Autowired
    private CBSVendorRepository vendorrepository;

    @Autowired
    private TestEntityManager testEntityManager;
	@Test
	 void testCreateVendor() {
		CBSVendor vendor = getCBSVendor();
		CBSVendor saveInDb = testEntityManager.persist(vendor);
		CBSVendor getFromInDb = vendorrepository.findById(saveInDb.getVendorId()).get();
        assertThat(getFromInDb).isEqualTo(saveInDb);
	}
	public CBSVendor getCBSVendor() {
		CBSVendor vendor=new CBSVendor();
		vendor.setVendorName("Ramu");
		  vendor.setVendorPhone(78989345);
		  vendor.setVendorEmail("ramu@gmail.com");
		  vendor.setVendorLocation("chennai");
		return vendor;
	}
	@Test
     void testGetVendorById() throws Exception{
		CBSVendor vendor=new CBSVendor();
		vendor.setVendorName("Abhi");
		  vendor.setVendorPhone(34589345);
		  vendor.setVendorEmail("abhi@gmail.com");
		  vendor.setVendorLocation("chennai");
       CBSVendor saveInDb = testEntityManager.persist(vendor);
       CBSVendor getInDb = vendorrepository.findById(vendor.getVendorId()).get();
        assertThat(getInDb).isEqualTo(saveInDb);
	}
	 @Test
	   void testGetAllVendors() throws Exception{
		 CBSVendor vendor=new CBSVendor();
			vendor.setVendorName("Ram");
			  vendor.setVendorPhone(234589345);
			  vendor.setVendorEmail("ram@gmail.com");
			  vendor.setVendorLocation("chennai");
	        
			  CBSVendor vendor1=new CBSVendor();
			  vendor1.setVendorName("Ramesh");
			  vendor1.setVendorPhone(654589345);
			  vendor1.setVendorEmail("ramesh@gmail.com");
			  vendor1.setVendorLocation("chennai");
	        testEntityManager.persist(vendor); 
	        testEntityManager.persist(vendor1);
	        List<CBSVendor> empList = (List<CBSVendor>) vendorrepository.findAll();

	        Assert.assertEquals(2, empList.size());
	    }
	 @Test
	    void testDeleteVendorById() throws Exception{
		 CBSVendor vendor=new CBSVendor();
			vendor.setVendorName("Suresh");
			  vendor.setVendorPhone(897689345);
			  vendor.setVendorEmail("suresh@gmail.com");
			  vendor.setVendorLocation("delhi");
	        

			  CBSVendor vendor1=new CBSVendor();
			  vendor1.setVendorName("Manyam");
			  vendor1.setVendorPhone(34589345);
			  vendor1.setVendorEmail("manyam@gmail.com");
			  vendor1.setVendorLocation("cuttak");
	        

			CBSVendor vendor2 = testEntityManager.persist(vendor);
	        testEntityManager.persist(vendor1);
	        testEntityManager.remove(vendor2);

	        List<CBSVendor> cbsvend = (List<CBSVendor>) vendorrepository.findAll();
	        Assert.assertEquals(1,cbsvend.size());

	    }
	 @Test
	  void testUpdateEmployee(){

		 CBSVendor vendor=new CBSVendor();
			vendor.setVendorName("Samali");
			  vendor.setVendorPhone(342689345);
			  vendor.setVendorEmail("samali@gmail.com");
			  vendor.setVendorLocation("delhi");
	        
	        testEntityManager.persist(vendor);

	        CBSVendor getFromDb = vendorrepository.findById(vendor.getVendorId()).get();
	        getFromDb.setVendorPhone(999658943); 
	        testEntityManager.persist(getFromDb);

	        assertThat(getFromDb.getVendorPhone()).isEqualTo(999658943);
	    }


}



