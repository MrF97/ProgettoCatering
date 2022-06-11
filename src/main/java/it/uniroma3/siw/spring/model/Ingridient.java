package it.uniroma3.siw.spring.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Ingridient {
	
	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	public String getOrigin() {
		return origin;
	}


	public void setOrigin(String origin) {
		this.origin = origin;
	}


	public String getDescription() {
		return description;
	}


	public void setDescription(String description) {
		this.description = description;
	}


	public List<Plate> getPlates() {
		return plates;
	}


	public void setPlates(List<Plate> plates) {
		this.plates = plates;
	}


	public void setId(Long id) {
		this.id = id;
	}


	public Ingridient (String name, String origin, String description) {
		this.name=name;
		this.origin=origin;
		this.description=description;
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false)
	private String name;
	
	@Column(nullable=false)
	private String origin;
	
	@Column(nullable=false)
	private String description;
	
	@ManyToMany(cascade = {CascadeType.MERGE})
	private List<Plate> plates;


	public Long getId() {
		return id;
	}
}