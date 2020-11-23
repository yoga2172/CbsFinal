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

import com.cbs.capbrandingstore.entity.Payment;
import com.cbs.capbrandingstore.repository.PaymentRepository;
import com.cbs.capbrandingstore.service.PaymentServiceImpl;

import org.mockito.Mockito;
import static org.assertj.core.api.Assertions.assertThat;

/** The AdminServiceImplTest class provides testing of AdminServiceImplService layer
 *   
 * @author Yoga's
 * 
 */


@RunWith(SpringRunner.class)
@SpringBootTest
class PaymentServiceImplTest {

	@MockBean
	 private PaymentRepository paymentrepository;
	
	 @Autowired
	 private PaymentServiceImpl paymentservice;
	@Test
	void testGetAllpayments() {
		Payment pay = new Payment();
		  pay.setEmpLocation("chennai");
		  pay.setProductCategory("apparel");
		  pay.setProductName("kurthis");
		  pay.setVendorLocation("delhi");
		  Payment pay1 = new Payment();
		  pay1.setEmpLocation("Bangalore");
		  pay1.setProductCategory("apparel");
		  pay1.setProductName("paijamas");
		  pay1.setVendorLocation("delhi");
		  List<Payment> payList = new ArrayList<>();
	      payList.add(pay);
	      payList.add(pay1);

	      Mockito.when(paymentrepository.findAll()).thenReturn(payList);
	      assertThat(paymentservice.getAllpayments()).isEqualTo(payList);
	}

	@Test
	void testCreatepayment() {
		Payment pay = new Payment();
		  pay.setEmpLocation("delhi");
		  pay.setProductCategory("Electronics");
		  pay.setProductName("samsung");
		  pay.setVendorLocation("bangalore");
		  Mockito.when(paymentrepository.save(pay)).thenReturn(pay);
	        assertThat(paymentservice.createpayment(pay)).isEqualTo(pay);
	}

	@Test
	void testUpdatepayment() {
		Payment pay = new Payment();
		  pay.setEmpLocation("Andhra");
		  pay.setProductCategory("Stationery");
		  pay.setProductName("pen");
		  pay.setVendorLocation("delhi");
		  paymentrepository.save(pay);
		    System.out.println(paymentrepository.findById(100));
		    Assert.assertTrue(paymentrepository.findById(100).isEmpty());
	}

	@Test
	void testDeletepayment() {
		Payment pay = new Payment();
		  pay.setEmpLocation("Andhra");
		  pay.setProductCategory("Stationery");
		  pay.setProductName("penpencil");
		  pay.setVendorLocation("chennai");
		  paymentrepository.save(pay);
		    System.out.println(paymentrepository.findById(100));
		    Assert.assertTrue(paymentrepository.findById(100).isEmpty());
	}

	@Test
	void testGetpaymentById() {
		Payment pay = new Payment();
		  pay.setEmpLocation("chennai");
		  pay.setProductCategory("Electronics");
		  pay.setProductName("electric cooker");
		  pay.setVendorLocation("bangalore");
		  paymentrepository.save(pay);
		    System.out.println(paymentrepository.findById(100));
		    Assert.assertTrue(paymentrepository.findById(100).isEmpty());
	}

}
