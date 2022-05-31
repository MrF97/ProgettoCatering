package it.uniroma3.siw.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.spring.service.ChefService;

@Controller
public class ChefController {

	@Autowired
	ChefService service;
	
	@RequestMapping(value = "/chef", method = RequestMethod.GET)
	public String home(Model model) {
		model.addAttribute("chefs", service.getAllChefs());
		return "chef";
	}
	
	
	
}