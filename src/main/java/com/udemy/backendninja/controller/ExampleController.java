package com.udemy.backendninja.controller;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.udemy.backendninja.component.ExampleComponent;
import com.udemy.backendninja.model.Person;
import com.udemy.backendninja.service.ExampleService;
import com.udemy.backendninja.service.impl.ExampleServiceImpl;

@Controller
@RequestMapping("/example")

public class ExampleController {
	
	public static final String EXAMPLE_VIEW="example";
	
	@Autowired
	@Qualifier("exampleService")
	private ExampleService exampleService;
	
	
	@Autowired
	@Qualifier("exampleComponent")
	private ExampleComponent exampleComponent;
	
	//Primera Forma
	@GetMapping("/exampleString")
	public String exampleString(Model model) {
		
		exampleComponent.sayHello();
		//model.addAttribute("person", new Person("Jon",23));
		model.addAttribute("people", exampleService.getListPeople());
		//model.addAttribute("people", getPeople());
		return EXAMPLE_VIEW;
	}
	
	//Segunda forma
	
	@RequestMapping(value="/exampleMAV", method=RequestMethod.GET)
	public ModelAndView exampleMAV() {
		
		ModelAndView mav= new ModelAndView(EXAMPLE_VIEW);
		
		//mav.addObject("person", new Person("Mikel",30));
		mav.addObject("people", getPeople());
		
		
		return mav;
	}
	
	private List<Person> getPeople(){
		
		
		List<Person> people = new ArrayList<>();
		people.add(new Person("juan", 23));
		people.add(new Person("Mikel", 35));
		people.add(new Person("Pedro", 25));
		people.add(new Person("Carlos", 56));
		
		return people;
	}
	
	
}
