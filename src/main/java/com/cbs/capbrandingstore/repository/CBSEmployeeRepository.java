package com.cbs.capbrandingstore.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.cbs.capbrandingstore.entity.CBSEmployee;

/** This is a repository class for CBSEmployee module 
 * 
 * @author Reshma's
 *
 */

@Repository
public interface CBSEmployeeRepository extends JpaRepository<CBSEmployee, Integer>  {

}