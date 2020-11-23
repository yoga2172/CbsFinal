package com.cbs.capbrandingstore.controller;

/** This is a Controller class for Payment module 
 * 
 * @author Yoga's
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

import com.cbs.capbrandingstore.entity.Payment;
import com.cbs.capbrandingstore.exception.ResourceNotFoundException;
import com.cbs.capbrandingstore.service.PaymentService;

import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
@Api(value="PaymentController",description="REST Apis related to Payment Entity!!!")
@RestController
@RequestMapping("/api/v0")
public class PaymentController {
	@Autowired
	private PaymentService paymentService;

	
	/** 
	 * 
	 *This method returns the list of payment details  
	 * 
	 * 
	 */
	@ApiOperation(value ="Get list of payments from  the system",response=Iterable.class)
	@GetMapping("/Payment")
	public List<Payment> getAllpayments() {
		
		return paymentService.getAllpayments();
		
	}

	
	/** 
	 * 
	 *This method returns the list of payment details  
	 *  @param Payment entity details
	 * 
	 */
	@ApiOperation(value ="Get  payment by id from  the system",response=Payment.class)
	@GetMapping("/Payment/{id}")
	public ResponseEntity<Payment> getpaymentById(@PathVariable(value = "id") Integer paymentId)
			throws ResourceNotFoundException {
		
		Payment payment= paymentService.getpaymentById(paymentId);
		return ResponseEntity.ok(payment);
	}

	
	/** This method adds the payment details 
	 * 
	 * @param Payment entity details 
	 * 
	 * 
	 */
	@ApiOperation(value ="Adding a new payment to the system",response=Payment.class)
	@PostMapping("/Payment")
	public Payment createpayment( @RequestBody Payment payment) {
		return paymentService.createpayment(payment);
	}

	
	/** This method updates the payment details 
	 * 
	 * @param Payment entity details and productId
	 * 
	 * 
	 */
	@ApiOperation(value ="Upadte the payment info in the system",response=Payment.class)
	@PutMapping("/Payment/{id}")
	public ResponseEntity<Payment> updatepayment(@PathVariable(value = "id") Integer paymentId,
			 @RequestBody Payment paymentDetails) throws ResourceNotFoundException {
		
		Payment payment=paymentService.updatepayment(paymentId, paymentDetails);
		return ResponseEntity.ok(payment);
	}
	
	
	/** This method deletes the payment details 
	 * 
	 * @param Payment entity details and productId
	 * 
	 * 
	 */
	@ApiOperation(value ="Delete payment info from the system",response=Payment.class)
	@SuppressWarnings("unused")
	@DeleteMapping("/Payment/{id}")
	public boolean deletepayment(@PathVariable(value = "id") Integer paymentId)
			throws ResourceNotFoundException {
		return paymentService.deletepayment(paymentId);
		
	}
	
}
