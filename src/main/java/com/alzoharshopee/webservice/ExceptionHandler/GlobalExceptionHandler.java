package com.alzoharshopee.webservice.ExceptionHandler;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.alzoharshopee.webservice.ExceptionHandler.*;
import com.alzoharshopee.webservice.Exception.ShopRegistrationNotFound;

@ControllerAdvice
public class GlobalExceptionHandler {

	ExceptionResponse response;

	@ExceptionHandler(value = ShopRegistrationNotFound.class)
	public ResponseEntity<ExceptionResponse> shopRegistrationNotFound(ShopRegistrationNotFound exception) {
		response = new ExceptionResponse(exception.getMessage(), new Date(), HttpStatus.NOT_FOUND.name(),
				exception.getClass().getSimpleName());
		return new ResponseEntity<ExceptionResponse>(response, HttpStatus.NOT_FOUND);
	}
}
