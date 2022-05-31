package it.uniroma3.siw.spring.service;

import java.util.List;
import java.util.Optional;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.uniroma3.siw.spring.model.Plate;
import it.uniroma3.siw.spring.repository.PlateRepository;

@Service
public class PlateService {

	@Autowired
	protected PlateRepository plateRepository;
	
	
	@Transactional
	public Plate getPlate(Long id) {
		Optional<Plate> result = this.plateRepository.findById(id);
		return result.orElse(null);
	}
	
	public Plate savePlate(Plate plate) {
        return this.plateRepository.save(plate);
    }
	
	@Transactional
    public List<Plate> getAllPlates() {
        return (List<Plate>) this.plateRepository.findAll();
    }
	
}
