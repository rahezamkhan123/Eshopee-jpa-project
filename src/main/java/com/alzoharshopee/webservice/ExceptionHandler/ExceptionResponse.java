package com.alzoharshopee.webservice.ExceptionHandler;

import java.util.Date;

import com.alzoharshopee.webservice.Exception.ShopRegistrationNotFound;

public class ExceptionResponse {

	private String message;
	private Date timestamp;
	private String status;
	private String error;

	public ExceptionResponse(String message, Date timestamp, String status, String error) {
		super();
		this.message = message;
		this.timestamp = timestamp;
		this.status = status;
		this.error = error;
	}

	public ExceptionResponse() {
		super();
	}

	public ExceptionResponse(String message2, Date timestamp2, String name,
			Class<? extends ShopRegistrationNotFound> class1) {
		// TODO Auto-generated constructor stub
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}

	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getStatus() {
		return status;
	}

	public void setStatus(String status) {
		this.status = status;
	}

	public String getError() {
		return error;
	}

	public void setError(String error) {
		this.error = error;
	}

}
