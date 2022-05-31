package it.uniroma3.siw.spring.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.spring.model.Ingridient;
import it.uniroma3.siw.spring.repository.IngridientRepository;

@Service
public class IngridientService {

	@Autowired
	protected IngridientRepository ingridientRepository;
	
	
	@Transactional
	public Ingridient getIngridient(Long id) {
		Optional<Ingridient> result = this.ingridientRepository.findById(id);
		return result.orElse(null);
	}
	
	public Ingridient saveIngridient(Ingridient ingridient) {
        return this.ingridientRepository.save(ingridient);
    }
	
	@Transactional
    public List<Ingridient> getAllIngridients() {
        return (List<Ingridient>) this.ingridientRepository.findAll();
    }
	
}