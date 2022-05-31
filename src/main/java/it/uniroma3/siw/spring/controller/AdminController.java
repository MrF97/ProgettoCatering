package it.uniroma3.siw.spring.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.spring.model.Buffet;
import it.uniroma3.siw.spring.model.Chef;
import it.uniroma3.siw.spring.service.BuffetService;
import it.uniroma3.siw.spring.service.ChefService;

@Controller
public class AdminController {
	
	
	@Autowired
	protected ChefService chefService;	
	
	@Autowired
	protected BuffetService buffetService;	
	

	//	@RequestMapping(value = "/admin/home", method = RequestMethod.GET)
	//	public String home(Model model) {
	//		return "admin/home";
	//	}


	@RequestMapping(value="/admin/chefs", method = RequestMethod.GET)
	public String chefs(Model model) {
		List<Chef> chef = chefService.getAllChefs();
		model.addAttribute("chefs", chef);
		return "/admin/chefs";
	}
	
	
	@RequestMapping(value="/admin/addChef", method = RequestMethod.GET)
	public String showInserisciChefForm(Model model) {
		model.addAttribute("chef", new Chef());
		return "/admin/aggiungiChef";
	}
	
	
	@RequestMapping(value="/admin/addBuffet", method = RequestMethod.GET)
	public String nuovoBuffet(Model model) {
		model.addAttribute("buffet", new Buffet());
		model.addAttribute("chefs", chefService.getAllChefs());
		return "/admin/aggiungiBuffet";
	}
	
	
	@RequestMapping(value="/admin/buffets", method = RequestMethod.GET)
	public String buffets(Model model) {
		List<Buffet> buffet = buffetService.getAllBuffets();
		model.addAttribute("buffets", buffet);
		return "/admin/allBuffets";
	}
	
	@RequestMapping(value="/admin/modificaBuffet/{id}", method = RequestMethod.GET)
	public String refactorBuffet(Model model, @PathVariable long id) {
		model.addAttribute("buffet", buffetService.getBuffet((long)id));
		model.addAttribute("chefs", chefService.getAllChefs());
		model.addAttribute("cuoco_id", 0);
		return "/admin/editBuffet";
	}
	
	
	@RequestMapping(value="/admin/addChef", method = RequestMethod.POST)
	public String inserisciChef(@ModelAttribute ("chef") Chef chef,
			BindingResult bindingResult,
			Model model) {
		if(!bindingResult.hasErrors()) {
			chefService.saveChef(chef);
			return "/admin/chefs";
		}
		return "admin/aggiungiChef";
	}
	
	
	@RequestMapping(value="/admin/addBuffet", method = RequestMethod.POST)
	public String inserisciBuffet(@ModelAttribute ("buffet") Buffet buffet,
			BindingResult bindingResult,
			Model model) {
		if(!bindingResult.hasErrors()) {
			buffetService.saveBuffet(buffet);
			return "/admin/allBuffets";
		}
		return "admin/aggiungiBuffet";
	}
	
	
	@RequestMapping(value="/admin/modificaBuffet/{id}", method = RequestMethod.POST)
	public String modificaBuffet(@ModelAttribute ("buffet") Buffet buffet,
			BindingResult buffetBindingResult,
			@ModelAttribute ("cuoco_id") int chef_id,
//			@ModelAttribute ("id") long id, 
//			BindingResult idBindingResult,
			Model model, @PathVariable long buffet_id) {
		if(!buffetBindingResult.hasErrors() ) {
			buffet.setId(buffet_id);
			buffet.setChef(chefService.getChef((long)chef_id));
			buffetService.saveBuffet(buffet);
			return "/admin/allBuffets";
		}
		return "admin/aggiungiBuffet";
	}

}