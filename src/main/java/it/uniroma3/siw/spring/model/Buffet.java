package it.uniroma3.siw.spring.model;

import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;

@Entity
public class Buffet {
	
	public Buffet() {
		
	}
	
public Buffet(Long id) {
		this.id=id;
	}
	
	
	public Buffet(String name, String description, Chef chef){
		this.name=name;
		this.description=description;
		this.chef=chef;
		
	}

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Long id;	
	
	@Column(nullable=false)
	private String name;
	
	@Column(nullable=false)
	private String description;
	
	@ManyToOne(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	private Chef chef;
	
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	private List<Plate> primi;
	
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	private List<Plate> secondi;
	
	@OneToMany(cascade = {CascadeType.PERSIST, CascadeType.REMOVE})
	private List<Plate> dessert;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}

	public Chef getChef() {
		return chef;
	}

	public void setChef(Chef chef) {
		this.chef = chef;
	}

	public List<Plate> getPrimi() {
		return primi;
	}

	public void setPrimi(List<Plate> primi) {
		this.primi = primi;
	}

	public List<Plate> getSecondi() {
		return secondi;
	}

	public void setSecondi(List<Plate> secondi) {
		this.secondi = secondi;
	}

	public List<Plate> getDessert() {
		return dessert;
	}

	public void setDessert(List<Plate> dessert) {
		this.dessert = dessert;
	}

	
}
