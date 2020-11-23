package com.cbs.capbrandingstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cbs.capbrandingstore.entity.Payment;

/** This is a repository class for Payment module 
 * @author Yoga's
 *
 */

@Repository
public interface PaymentRepository extends JpaRepository<Payment,Integer> {

}
