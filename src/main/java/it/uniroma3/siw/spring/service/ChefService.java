package it.uniroma3.siw.spring.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.spring.model.Chef;
import it.uniroma3.siw.spring.repository.ChefRepository;


@Service
public class ChefService {
	
	@Autowired
	protected ChefRepository chefRepository;
	
	
	@Transactional
	public Chef getChef(Long id) {
		Optional<Chef> result = this.chefRepository.findById(id);
		return result.orElse(null);
	}
	
	public Chef saveChef(Chef chef) {
        return this.chefRepository.save(chef);
    }
	
	@Transactional
    public List<Chef> getAllChefs() {
        return (List<Chef>) this.chefRepository.findAll();
    }

}
