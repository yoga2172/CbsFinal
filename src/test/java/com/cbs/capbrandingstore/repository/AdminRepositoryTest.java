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

import com.cbs.capbrandingstore.entity.Admin;
import com.cbs.capbrandingstore.repository.AdminRepository;

/** The AdminRepositoryTest class provides testing of AdminRepository layer
 *   
 * @author Yoga's
 * 
 */



@RunWith(SpringRunner.class)
@DataJpaTest
 class AdminRepositoryTest {

	@Autowired
    private AdminRepository adminrepository;

    @Autowired
    private TestEntityManager testEntityManager;
    @Test
     void testNewAdmin() throws Exception{
    	Admin admin= getAdmin();
    	Admin saveInDb = testEntityManager.persist(admin);
    	Admin getFromInDb = adminrepository.findById(saveInDb.getAdminId()).get();
        assertThat(getFromInDb).isEqualTo(saveInDb);
    }
	private Admin getAdmin() {
		Admin admin=new Admin();
		admin.setAdminName("Reddy");
		  admin.setAdminPhone(432178289);
		  admin.setAdminEmail("reddy@gmail.com");
		return admin;
	}
	@Test
    void testGetAdminById() throws Exception{
		Admin admin = new Admin();
		 admin.setAdminName("YogaReddy");
		  admin.setAdminPhone(567878289);
		  admin.setAdminEmail("yogareddy@gmail.com");
       Admin saveInDb = testEntityManager.persist(admin);
       Admin getInDb = adminrepository.findById(admin.getAdminId()).get();
        assertThat(getInDb).isEqualTo(saveInDb);
	}
	 @Test
	    void testGetAllAdmins() throws Exception{
		 Admin admin = new Admin();
		 
		 admin.setAdminName("Yoga");
		  admin.setAdminPhone(345678289);
		  admin.setAdminEmail("yoga@gmail.com");
		  Admin admin1 = new Admin();
		  
		  admin1.setAdminName("Anandh");
		  admin1.setAdminPhone(543678298);
		  admin1.setAdminEmail("anandh@gmail.com");
	        testEntityManager.persist(admin); 
	        testEntityManager.persist(admin1);
	        List<Admin> empList = (List<Admin>) adminrepository.findAll();

	        Assert.assertEquals(2, empList.size());
	    }
	 @Test
	     void testDeleteAdminById() throws Exception{
		 Admin admin = new Admin();
		
		 admin.setAdminName("YogaReddy");
		  admin.setAdminPhone(567878289);
		  admin.setAdminEmail("yogareddy@gmail.com");
	        

		  Admin admin1 = new Admin();
		 
		  admin1.setAdminName("Yogi");
		  admin1.setAdminPhone(345678289);
		  admin1.setAdminEmail("reddyyogi@gmail.com");
	        

			Admin admin2 = testEntityManager.persist(admin);
	        testEntityManager.persist(admin1);
	        testEntityManager.remove(admin2);

	        List<Admin> adminList = (List<Admin>) adminrepository.findAll();
	        Assert.assertEquals(1,adminList.size());

	    }
	 @Test
	     void testUpdateAdmin(){

		 Admin admin = new Admin();
		  admin.setAdminName("ReddyYoga");
		  admin.setAdminPhone(987178289);
		  admin.setAdminEmail("reddyyoga@gmail.com");
	        
	        testEntityManager.persist(admin);

	        Admin getFromDb = adminrepository.findById(admin.getAdminId()).get();
	        getFromDb.setAdminPhone(999658943); 
	        testEntityManager.persist(getFromDb);

	        assertThat(getFromDb.getAdminPhone()).isEqualTo(999658943);
	    }


}