package com.cbs.capbrandingstore.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;

import com.cbs.capbrandingstore.entity.Payment;
import com.cbs.capbrandingstore.exception.ResourceNotFoundException;
import com.cbs.capbrandingstore.repository.PaymentRepository;


/** The PaymentServiceImpl class provides access to repository methods to CRUD operations Payment details 
 * 
 * 
 * @author Yoga's
 *
 */


@Service
@Transactional
public class PaymentServiceImpl  implements PaymentService {
	@Autowired
	private PaymentRepository paymentRepository;
	
	@Override
	public List<Payment> getAllpayments() {
		return paymentRepository.findAll();
	}

	@Override
	public Payment createpayment(Payment payment) {
		return paymentRepository.save(payment);
	}
 
	@Override
	public Payment updatepayment(@PathVariable(value = "id") Integer paymentId, Payment paymentDetails)throws ResourceNotFoundException {
		Payment payment = paymentRepository.findById(paymentId)
				.orElseThrow(() -> new ResourceNotFoundException("Payment not found for this id ::" + paymentId));

		payment.setEmpId(paymentDetails.getEmpId());
		payment.setEmpLocation(paymentDetails.getEmpLocation());
		payment.setProductCategory(paymentDetails.getProductCategory());
		payment.setProductId(paymentDetails.getProductId());
		payment.setProductName(paymentDetails.getProductName());
		payment.setVendorLocation(paymentDetails.getVendorLocation());
		return paymentRepository.save(payment);
		
	}

	@Override
	public boolean deletepayment(Integer paymentId) throws ResourceNotFoundException {
		Payment payment = paymentRepository.findById(paymentId)
				.orElseThrow(() -> new ResourceNotFoundException("Payment not found for this id :: " + paymentId));
		paymentRepository.delete(payment);
		return true;
	
	}

	@Override
	public Payment getpaymentById(Integer paymentId) throws ResourceNotFoundException {
		return paymentRepository.findById(paymentId)
				.orElseThrow(() -> new ResourceNotFoundException("Payment not found for this id :: " + paymentId));
	
	}




	
}
