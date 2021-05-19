package com.itwill.funstream.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class TempController {

	public TempController() {
		// TODO Auto-generated constructor stub
	}

	@RequestMapping("error")
	public String error() {
		return "/error";
	}



}
