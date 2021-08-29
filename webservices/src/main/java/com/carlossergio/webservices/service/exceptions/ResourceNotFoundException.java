package com.carlossergio.webservices.service.exceptions;

public class ResourceNotFoundException extends RuntimeException{

	private static final long serialVersionUID = 1L;

	/*
	 * O contrutor dessa exceção recebe o id que está sendo procurado*/
	public ResourceNotFoundException (Object id) {
		super("Resource not found. Id "+ id);
	}
	
}
