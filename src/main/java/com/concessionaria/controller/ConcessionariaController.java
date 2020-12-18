package com.concessionaria.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class ConcessionariaController {
	
	@RequestMapping("/")
	public String index() {
		return "index";
	}

}
