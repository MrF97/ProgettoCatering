package it.uniroma3.siw.spring.service;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.TypedQuery;
import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.spring.model.Buffet;
import it.uniroma3.siw.spring.model.Ingridient;
import it.uniroma3.siw.spring.repository.BuffetRepository;

@Service
public class BuffetService {

	@Autowired
	protected BuffetRepository buffetRepository;
	
	@PersistenceContext
	private EntityManager em;
	
	
	@Transactional
	public Buffet getBuffet(Long id) {
		Optional<Buffet> result = this.buffetRepository.findById(id);
		return result.orElse(null);
	}
	
	public Buffet saveBuffet(Buffet buffet) {
        return this.buffetRepository.save(buffet);
    }
	
	@Transactional
    public List<Buffet> getAllBuffets() {
        return (List<Buffet>) this.buffetRepository.findAll();
    }
	
//	@Transactional
//	public Buffet updateBuffet(Buffet buffet) {
//		Buffet nuovoBuffet = buffetRepository.findById(buffet.getId()).map(newBuffet -> 
//		{return buffetRepository.save(newBuffet);}).orElseGet(()->
//		{return buffetRepository.save(buffet);});
//		buffet.setId(nuovoBuffet.getId());
//		return buffetRepository.save(buffet);
//		
//	}
	
}