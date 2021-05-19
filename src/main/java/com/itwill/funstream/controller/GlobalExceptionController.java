package com.itwill.funstream.controller;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

//@ControllerAdvice
public class GlobalExceptionController {
	
	//@ExceptionHandler(Exception.class)
	public String exception(Exception e) {
		return "error";
	}
}
