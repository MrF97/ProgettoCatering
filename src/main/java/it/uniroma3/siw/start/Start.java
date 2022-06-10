package it.uniroma3.siw.start;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.stereotype.Component;

import it.uniroma3.siw.spring.model.Buffet;
import it.uniroma3.siw.spring.model.Chef;
import it.uniroma3.siw.spring.model.Credentials;
import it.uniroma3.siw.spring.model.Ingridient;
import it.uniroma3.siw.spring.model.Plate;
import it.uniroma3.siw.spring.service.BuffetService;
import it.uniroma3.siw.spring.service.ChefService;
import it.uniroma3.siw.spring.service.CredentialsService;
import it.uniroma3.siw.spring.service.IngridientService;
import it.uniroma3.siw.spring.service.PlateService;

@Component
public class Start implements ApplicationListener<ContextRefreshedEvent> {


    @Autowired
    private CredentialsService credentialsService;
    
    @Autowired
    PlateService plateService;
    
    @Autowired
    private ChefService chefService;
    
    @Autowired
    private BuffetService buffetService;
    
    @Autowired
    private IngridientService ingridientService;
    
    

    @Override
    public void onApplicationEvent(ContextRefreshedEvent contextRefreshedEvent) {
    	
    	//QUESTE SONO LE CREDENZIALI
    	credentialsService.saveCredentials(new Credentials("test1@test.com","p", "ADMIN"));
    	credentialsService.saveCredentials(new Credentials("test2@test.com","p", "ADMIN"));
    	credentialsService.saveCredentials(new Credentials("aaaa","aaaaaa", "DEFAULT"));
    	
    	
//    	//QUESTI SONO GLI INGREDIENTI
//    	ingridientService.saveIngridient(new Ingridient("Pomodoro", "Italia", "San Marzano DOC"));
//    	
//    	//QUESTI SONO I PIATTI
//    	plateService.savePlate(new Plate( "pasta al sugo",
//    			" pachini gialli, eco"));
//    	plateService.savePlate(new Plate("pasta al pesto",
//    			"pasta al pesto"));
//    	
//    	
//    	
//    	chefService.saveChef(new Chef("pippo", "messicano", "sa cucinare"));
//    	
//    	
//    	buffetService.saveBuffet(new Buffet("Buffet Pesce 1", "tutto a base di pesce"));
    	
    
    	
    	List<Ingridient> listaIngredienti1=new ArrayList<Ingridient>();
    	listaIngredienti1.add(new Ingridient("pane", "guatemala", "aaa"));
    	listaIngredienti1.add(new Ingridient("nutella", "italia", "fatta con nocciole"));
    	Plate piatto1=new Plate("pane e nutella", "pane di farina 000, e nutella dell'euro spin" ,listaIngredienti1);
    	
    	List<Ingridient> listaIngredienti2=new ArrayList<Ingridient>();
    	listaIngredienti2.add(new Ingridient("pane", "guatemala", "aaa"));
    	listaIngredienti2.add(new Ingridient("pomodori", "italia", "fatta con nocciole"));
    	Plate piatto2 = new Plate("bruschetta con i pomodori", "pane di farina 000, e pomodori dell'euro spin" ,listaIngredienti2);
    	
    	List<Plate> primi1 = new ArrayList<Plate>();
    	primi1.add(piatto1);
    	primi1.add(piatto2);
    	
    	List<Ingridient> listaIngredienti3=new ArrayList<Ingridient>();
    	listaIngredienti3.add(new Ingridient("manzo", "guatemala", "aaa"));
    	listaIngredienti3.add(new Ingridient("pomodoro", "italia", "fatta con nocciole"));
    	Plate piatto3=new Plate("spezzatino al sugo", "pane di farina 000, e nutella dell'euro spin" ,listaIngredienti1);
    	
    	List<Ingridient> listaIngredienti4=new ArrayList<Ingridient>();
    	listaIngredienti4.add(new Ingridient("pollo", "guatemala", "aaa"));
    	listaIngredienti4.add(new Ingridient("farina", "italia", "fatta con nocciole"));
    	Plate piatto4 = new Plate("pollo fritto", "pane di farina 000, e pomodori dell'euro spin" ,listaIngredienti2);
    	
    	List<Plate> secondi = new ArrayList<Plate>();
    	secondi.add(piatto3);
    	secondi.add(piatto4);
    	
  
    	List<Ingridient> listaIngredienti5=new ArrayList<Ingridient>();
    	listaIngredienti5.add(new Ingridient("manzo", "guatemala", "aaa"));
    	listaIngredienti5.add(new Ingridient("pomodoro", "italia", "fatta con nocciole"));
    	Plate piatto5=new Plate("spezzatino al sugo", "pane di farina 000, e nutella dell'euro spin" ,listaIngredienti1);
    	
    	List<Ingridient> listaIngredienti6=new ArrayList<Ingridient>();
    	listaIngredienti6.add(new Ingridient("pollo", "guatemala", "aaa"));
    	listaIngredienti6.add(new Ingridient("farina", "italia", "fatta con nocciole"));
    	Plate piatto6 = new Plate("pollo fritto", "pane di farina 000, e pomodori dell'euro spin" ,listaIngredienti2);
    	
    	List<Plate> dessert = new ArrayList<Plate>();
    	dessert.add(piatto5);
    	dessert.add(piatto6);
    	
    	
    	Chef chefMR= new Chef("Mario", "Rossi", "Italia");
    	
    	
    	Buffet buffet1 = new Buffet("Buffet Carne 1", "molto buono", chefMR);
    	
    	buffet1.setPrimi(primi1);
    	buffet1.setSecondi(secondi);
    	buffet1.setDessert(dessert);
    	
    	buffetService.saveBuffet(buffet1);
    }
}
