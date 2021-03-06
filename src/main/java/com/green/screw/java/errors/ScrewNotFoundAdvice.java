package com.green.screw.java.errors;


import javax.persistence.RollbackException;
import javax.servlet.http.HttpServletRequest;
import javax.validation.ConstraintViolationException;

import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.mapping.PropertyReferenceException;
import org.springframework.http.HttpStatus;
import org.springframework.web.HttpRequestMethodNotSupportedException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;


/**
 * 
 * @author pingvin
 *
 */
@ControllerAdvice
@RequestMapping(produces = "application/vnd.error+json")
public class ScrewNotFoundAdvice {

	/**
	 * 
	 * @param request
	 * @param ex
	 * @return
	 */
	@ResponseBody
	@ExceptionHandler({org.springframework.data.mapping.PropertyReferenceException.class}) 
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	ErrorDetail serverHandler(HttpServletRequest request, PropertyReferenceException ex) {
		System.out.println(ex.getPropertyName());
		ErrorDetail error = new ErrorDetail();
	    error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
	    error.setMessage("Server error, no Property Name - " + ex.getPropertyName().toString());
	    error.setUrl(request.getRequestURL().toString());
	    error.setQuery(request.getQueryString());
	    return error;

	}
	
	/**
	 * 
	 * @param request
	 * @param ex
	 * @return
	 */
	@ResponseBody
	@ExceptionHandler({EmptyResultDataAccessException.class}) 
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	ErrorDetail serverDelHandler(HttpServletRequest request, EmptyResultDataAccessException ex) {
		System.out.println(ex.getMessage());
		ErrorDetail error = new ErrorDetail();
	    error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
	    error.setMessage(ex.getMessage());
	    error.setUrl(request.getRequestURL().toString());
	    error.setQuery(request.getQueryString());
	    return error;

	}
	
	/**
	 * 
	 * @param request
	 * @param ex
	 * @return
	 */
	@ResponseBody
	@ExceptionHandler({HttpRequestMethodNotSupportedException.class}) 
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	ErrorDetail serverDelEmtylHandler(HttpServletRequest request, HttpRequestMethodNotSupportedException ex) {
		System.out.println(ex.getMessage());
		ErrorDetail error = new ErrorDetail();
	    error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
	    error.setMessage(ex.getMessage());
	    error.setUrl(request.getRequestURL().toString());
	    error.setQuery(request.getQueryString());
	    return error;

	}
	
	/**
	 * 
	 * @param request
	 * @param ex
	 * @return
	 */
	@ResponseBody
	@ExceptionHandler({RollbackException.class}) 
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	ErrorDetail serverUpdateEmtylHandler(HttpServletRequest request, RollbackException ex) {
		ErrorDetail error = new ErrorDetail();
	    error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
	    error.setMessage(ex.getMessage());
	    error.setUrl(request.getRequestURL().toString());
	    error.setQuery(request.getQueryString());
	    return error;

	}
	
	/**
	 * 
	 * @param request
	 * @param ex
	 * @return
	 */
	@ResponseBody
	@ExceptionHandler({ConstraintViolationException.class}) 
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	ErrorDetail serverPostEmtylHandler(HttpServletRequest request, ConstraintViolationException ex) {
		ErrorDetail error = new ErrorDetail();
	    error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
	    error.setMessage(ex.getMessage());
	    error.setUrl(request.getRequestURL().toString());
	    error.setQuery(request.getQueryString());
	    return error;

	}
	
	/**
	 * 
	 * @param request
	 * @param ex
	 * @return
	 */
	@ResponseBody
	@ExceptionHandler({DataIntegrityViolationException.class}) 
	@ResponseStatus(HttpStatus.INTERNAL_SERVER_ERROR)
	ErrorDetail serverPostUniqueEmtylHandler(HttpServletRequest request, DataIntegrityViolationException ex) {
		ErrorDetail error = new ErrorDetail();
	    error.setStatus(HttpStatus.INTERNAL_SERVER_ERROR.value());
	    error.setMessage(ex.getMessage());
	    error.setUrl(request.getRequestURL().toString());
	    error.setQuery(request.getQueryString());
	    return error;

	}
	
	/**
	 * 
	 * @param request
	 * @param ex
	 * @return
	 */
	@ResponseBody
	@ExceptionHandler(ScrewNotFoundException.class)
	@ResponseStatus(HttpStatus.NOT_FOUND)
	ErrorDetail supplierNotFoundHandler(HttpServletRequest request, ScrewNotFoundException ex) {
		ErrorDetail error = new ErrorDetail();
		error.setStatus(HttpStatus.NOT_FOUND.value());
		error.setMessage(ex.getMessage());
		error.setUrl(request.getRequestURL().toString());
		error.setQuery("");
		return error;
	}

}
