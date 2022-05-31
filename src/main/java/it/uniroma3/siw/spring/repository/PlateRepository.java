package it.uniroma3.siw.spring.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.spring.model.Plate;

public interface PlateRepository extends CrudRepository<Plate, Long> {
	
	public Optional<Plate> findByName(String name);

}