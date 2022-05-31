package it.uniroma3.siw.spring.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.spring.model.Buffet;
import it.uniroma3.siw.spring.model.Plate;

public interface BuffetRepository extends CrudRepository<Buffet, Long> {
	
	public Optional<Buffet> findByName(String name);

}