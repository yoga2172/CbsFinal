package com.cbs.capbrandingstore.service;

/** This is an interface which defines CRUD methods for Payment service
 * 
 * @author Yoga's
 *
 */

import java.util.List;

import com.cbs.capbrandingstore.entity.Payment;
import com.cbs.capbrandingstore.exception.ResourceNotFoundException;

public interface PaymentService {

	public List<Payment> getAllpayments();

	public Payment createpayment(Payment payment);

	public Payment updatepayment(Integer paymentId, Payment paymentDetails) throws ResourceNotFoundException;

	public boolean deletepayment(Integer paymentId) throws ResourceNotFoundException;

	public Payment getpaymentById(Integer paymentId) throws ResourceNotFoundException ;

}
