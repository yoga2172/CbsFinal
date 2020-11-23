/**
 * 
 */
package com.cbs.capbrandingstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cbs.capbrandingstore.entity.Admin;

/** This is a repository class for Admin module 
 * @author Yoga's
 *
 */
@Repository
public interface AdminRepository extends JpaRepository<Admin,Integer> {

}

