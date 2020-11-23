package com.cbs.capbrandingstore.controller;

import static org.assertj.core.api.Assertions.assertThat;
import java.util.ArrayList;
import java.util.List;
import org.junit.Assert;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.cbs.capbrandingstore.controller.AdminController;
import com.cbs.capbrandingstore.entity.Admin;
import com.cbs.capbrandingstore.service.AdminServiceImpl;
import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

/** The AdminControllerTest class provides testing of AdminController layer
 *   
 * @author Yoga's
 * 
 */



@RunWith(SpringRunner.class)
@WebMvcTest(value = AdminController.class)
class AdminControllerTest {

	 @Autowired
	    private MockMvc mockMvc;

	    @MockBean
	    private AdminServiceImpl adminservice; 
	@Test
	void testGetAlladmins() throws Exception {
		String URI = "/api/v0/Admin";
		  Admin admin = new Admin();
		  admin.setAdminName("Yoga");
		  admin.setAdminPhone(345678289);
		  admin.setAdminEmail("yoga@gmail.com");
		  Admin admin1 = new Admin();
		  admin1.setAdminName("Anandh");
		  admin1.setAdminPhone(543678298);
		  admin1.setAdminEmail("anandh@gmail.com");
	    	 List<Admin> adminList=new ArrayList<>();
	    	  adminList.add(admin);
	    	adminList.add(admin1);
	    	 
	    	String jsonInput = this.converttoJson(adminList);

	         Mockito.when(adminservice.getAlladmins()).thenReturn(adminList);
	         MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI).accept(MediaType.APPLICATION_JSON)).andReturn();
	         MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
	         String jsonOutput = mockHttpServletResponse.getContentAsString();

	         assertThat(jsonInput).isEqualTo(jsonOutput);
	}

	private String converttoJson(Object admin) throws JsonProcessingException {
		ObjectMapper objectMapper = new ObjectMapper();
        return objectMapper.writeValueAsString(admin);
	}

	@Test
	void testGetAdminById() throws Exception {
		String URI= "/api/v0/Admin/{id}";
		 Admin admin = new Admin();
		 admin.setAdminName("YogaReddy");
		  admin.setAdminPhone(567878289);
		  admin.setAdminEmail("yogareddy@gmail.com");
       String jsonInput = this.converttoJson(admin);

       Mockito.when(adminservice.getadminById(Mockito.any())).thenReturn(admin);
       MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.get(URI, 102).accept(MediaType.APPLICATION_JSON)).andReturn();
       MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
       String jsonOutput = mockHttpServletResponse.getContentAsString();

       assertThat(jsonInput).isEqualTo(jsonOutput);
	}

	@Test
	void testCreateadmin() throws Exception {
		String URI = "/api/v0/Admin";
		 Admin admin = new Admin();
		  admin.setAdminName("Reddy");
		  admin.setAdminPhone(432178289);
		  admin.setAdminEmail("reddy@gmail.com");
       String jsonInput = this.converttoJson(admin);

       Mockito.when(adminservice.createadmin(Mockito.any(Admin.class))).thenReturn(admin);
       MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.post(URI).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
               .andReturn();
       MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
       String jsonOutput = mockHttpServletResponse.getContentAsString();
       assertThat(jsonInput).isEqualTo(jsonOutput);
       Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
	}

	@Test
	void testUpdateadmin() throws Exception {
		String URI = "/api/v0/Admin/{id}";
		 Admin admin = new Admin();
		  admin.setAdminName("ReddyYoga");
		  admin.setAdminPhone(987178289);
		  admin.setAdminEmail("reddyyoga@gmail.com");
        String jsonInput = this.converttoJson(admin);

        Mockito.when(adminservice.updateadmin(Mockito.any(),Mockito.any())).thenReturn(admin);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.put(URI,105).accept(MediaType.APPLICATION_JSON).content(jsonInput).contentType(MediaType.APPLICATION_JSON))
                .andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();
        String jsonOutput = mockHttpServletResponse.getContentAsString();

        assertThat(jsonInput).isEqualTo(jsonOutput);
	}

	@Test
	void testDeleteadmin() throws Exception {
		String URI = "/api/v0/Admin/{id}";
		 Admin admin = new Admin();
		  admin.setAdminName("Yogi");
		  admin.setAdminPhone(345678289);
		  admin.setAdminEmail("reddyyogi@gmail.com");

        Mockito.when(adminservice.getadminById(Mockito.any())).thenReturn(admin);
        Mockito.when(adminservice.deleteadmin(Mockito.any())).thenReturn(true);
        MvcResult mvcResult = this.mockMvc.perform(MockMvcRequestBuilders.delete(URI, 105).accept(MediaType.APPLICATION_JSON)).andReturn();
        MockHttpServletResponse mockHttpServletResponse = mvcResult.getResponse();

        Assert.assertEquals(HttpStatus.OK.value(), mockHttpServletResponse.getStatus());
	}

}
