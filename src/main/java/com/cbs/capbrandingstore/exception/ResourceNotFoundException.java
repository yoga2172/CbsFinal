package com.cbs.capbrandingstore.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/** Resource Not Found Exception is an user defined exception
 * 
 * @author Yoga's, Reshma's and AbhiRams's
 *
 */



@ResponseStatus(value = HttpStatus.NOT_FOUND)
public class ResourceNotFoundException extends Exception{

	private static final long serialVersionUID = 1L;

	public ResourceNotFoundException(String message){
    	super(message);
    }
}
