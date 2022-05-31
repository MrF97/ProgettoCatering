package it.uniroma3.siw.spring.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.spring.model.Buffet;
import it.uniroma3.siw.spring.service.BuffetService;

@Controller
public class BuffetController {

	@Autowired
	BuffetService service;
	
	@RequestMapping(value = "/buffet/{id}", method = RequestMethod.GET)
	public String home(Model model, @PathVariable int id) {
		Buffet buffet = service.getBuffet((long) id);
		model.addAttribute("nome",buffet.getName());
		model.addAttribute("descrizione",buffet.getDescription());
		model.addAttribute("primi", buffet.getPrimi());
		model.addAttribute("secondi", buffet.getSecondi());
		model.addAttribute("desserts", buffet.getDessert());
		model.addAttribute("chef", buffet.getChef().getName()+" "+buffet.getChef().getCognome());
		return "buffet";
	}
	
	
	
}