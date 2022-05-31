package it.uniroma3.siw.spring.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import it.uniroma3.siw.spring.model.Credentials;
import it.uniroma3.siw.spring.model.Prenotazione;
import it.uniroma3.siw.spring.service.CredentialsService;
import it.uniroma3.siw.spring.service.PrenotazioneService;

@Controller
public class PrenotaController{ 


	@Autowired
	protected PrenotazioneService prenotazioneService;
	
	@Autowired
	protected CredentialsService credentialsService;
	
	
	@RequestMapping(value= { "/prenotazione" }, method = RequestMethod.GET)
	public String richiestaPrenotazione(Model model, Principal prin) {
		UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	Credentials credentials = credentialsService.getCredentials(userDetails.getUsername());
    	Prenotazione prenotazione = new Prenotazione();
		prenotazione.setUsername(credentials.getUsername().toString());
		model.addAttribute("prenotazione", prenotazione);
		return "homePrenotazione";
	}


	@RequestMapping(value= { "/prenotazione" }, method = RequestMethod.POST)
	public String registerPrenotazione(@ModelAttribute ("prenotazione") Prenotazione prenotazione,
			BindingResult bindingResult, 
			Model model) {
		UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	Credentials credentials = credentialsService.getCredentials(userDetails.getUsername());
    	prenotazione.setUsername(credentials.getUsername());
		if(!bindingResult.hasErrors()) { 
			prenotazioneService.savePrenotazione(prenotazione);
			return "logIndex";
		}
		return "homePrenotazione";

	}
	
	@RequestMapping(value = "/listaPrenotazioni", method = RequestMethod.GET) 
	public String showPrenotazioni (Model model) {
		UserDetails userDetails = (UserDetails)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
    	Credentials credentials = credentialsService.getCredentials(userDetails.getUsername());
    	String username=credentials.getUsername();
    	model.addAttribute("prenotazioni", prenotazioneService.getAllPrenotazioniUser(username));
		return "listaPrenotazioni";
	}
	

}
