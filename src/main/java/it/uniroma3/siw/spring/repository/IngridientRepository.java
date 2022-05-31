package it.uniroma3.siw.spring.repository;

import java.util.Optional;

import org.springframework.data.repository.CrudRepository;

import it.uniroma3.siw.spring.model.Ingridient;

public interface IngridientRepository extends CrudRepository<Ingridient, Long> {
	
	public Optional<Ingridient> findByName(String name);

}