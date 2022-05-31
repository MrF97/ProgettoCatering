package it.uniroma3.siw.spring.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.uniroma3.siw.spring.model.Prenotazione;
import it.uniroma3.siw.spring.repository.PrenotazioneRepository;

@Service
public class PrenotazioneService {

	@Autowired
	protected PrenotazioneRepository prenotazioneRepository;
	
	
	@Transactional
    public Prenotazione savePrenotazione(Prenotazione prenotazione) {
        return this.prenotazioneRepository.save(prenotazione);
    }
	
	@Transactional
    public List<Prenotazione> getAllPrenotazioniUser(String username) {
        return (List<Prenotazione>) this.prenotazioneRepository.findByUsername(username);
    }
	
}
