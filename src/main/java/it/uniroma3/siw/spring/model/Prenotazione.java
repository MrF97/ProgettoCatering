package it.uniroma3.siw.spring.model;


import java.text.DateFormat;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

import org.springframework.format.annotation.DateTimeFormat;

@Entity
public class Prenotazione {

	public Prenotazione() {
		
	}
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private Long id;	
	
	@Column
	private String username;
	
	@Column(length = 2000 )
	private String descrizione;
	
	@Column(nullable=false)
	@DateTimeFormat(pattern = "dd/MM/yyyy h:mm a")
    private Date date;
	
	@Column
	private String buffet; 
	
	public String getDescrizione() {
		return descrizione;
	}

	public void setDescrizione(String descrizione) {
		this.descrizione = descrizione;
	}
	
	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public String getBuffet() {
		return buffet;
	}

	public void setBuffet(String buffet) {
		this.buffet = buffet;
	}

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	
}
