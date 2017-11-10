package com.mycompany.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ErrorsController {
	
	@ExceptionHandler(Exception.class)
	
	
	public String serveserrors() {
		return "error/505";
	}

}
