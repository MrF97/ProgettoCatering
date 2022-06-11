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
public class Plate {
	
	public Plate(){
		
	}
	
	
	public Plate( String name, String description, List<Ingridient> ingredienti) {
		super();
		this.name = name;
		this.description=description;
		this.ingridients=ingredienti;
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;
	
	@Column(nullable=false)
	private String name;
	
	@Column(nullable=false)
	private String description;
	
	@ManyToMany(mappedBy = "plates" , cascade = {CascadeType.MERGE })
	private List<Ingridient> ingridients;
	
	
	
	
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

	public List<Ingridient> getIngridients() {
		return ingridients;
	}

	public void setIngridients(List<Ingridient> ingridients) {
		this.ingridients = ingridients;
	}
	
}
