package com.example.smartspring.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class UtamaOfficeController {
	
	@RequestMapping ("/office")
	public String beranda() {
		String html = "utamaOffice";
		return html;
	}
	
	
}
