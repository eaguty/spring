package com.udemy.backendninja.controller;

import javax.validation.Valid;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.backendninja.model.Person;

@Controller
@RequestMapping("/example3")
public class Example3Controller {
	private static final Log LOG = LogFactory.getLog(Example3Controller.class);

	public static final String FORM_VIEW = "form";
	public static final String RESULT_VIEW = "result";

	@GetMapping("/showform")
	public String showForm(Model model) {

		model.addAttribute("person", new  Person());
		return FORM_VIEW;

	}

	@GetMapping("/addperson")
	public ModelAndView addPerson(@Valid @ModelAttribute("person") Person person, BindingResult bindingResult) {
		ModelAndView mav = new ModelAndView();
		if(bindingResult.hasErrors()) {
			mav.setViewName(FORM_VIEW);
		}else {
			mav.setViewName(RESULT_VIEW);
			mav.addObject("person", person);
		}

		//LOG.info("METHOD: 'addPerson' -- PARAMS: "+person);
		//LOG.info("TEMPLATE: '"+ RESULT_VIEW + "' -- DATA: "+person);
		return mav;
	}
}
