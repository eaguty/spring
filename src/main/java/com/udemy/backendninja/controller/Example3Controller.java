package com.udemy.backendninja.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.udemy.backendninja.model.Person;

@Controller
@RequestMapping("/example3")
public class Example3Controller {
	
	public static final String FORM_VIEW = "form";
	
	@GetMapping("/showform")
	public String showForm(Model model) {
		
		model.addAttribute("person", new  Person());
		return FORM_VIEW;
		
	}
}
