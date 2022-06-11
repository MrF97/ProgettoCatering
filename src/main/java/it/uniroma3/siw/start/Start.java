package it.uniroma3.siw.start;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationListener;
import org.springframework.context.event.ContextRefreshedEvent;
import org.springframework.security.access.method.P;
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
    	
    
    	
    	//BUFFET TIPOLOGIA 1
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
    	
    	List<Plate> secondi1 = new ArrayList<Plate>();
    	secondi1.add(piatto3);
    	secondi1.add(piatto4);
    	
  
    	List<Ingridient> listaIngredienti5=new ArrayList<Ingridient>();
    	listaIngredienti5.add(new Ingridient("manzo", "guatemala", "aaa"));
    	listaIngredienti5.add(new Ingridient("pomodoro", "italia", "fatta con nocciole"));
    	Plate piatto5=new Plate("spezzatino al sugo", "pane di farina 000, e nutella dell'euro spin" ,listaIngredienti1);
    	
    	List<Ingridient> listaIngredienti6=new ArrayList<Ingridient>();
    	listaIngredienti6.add(new Ingridient("pollo", "guatemala", "aaa"));
    	listaIngredienti6.add(new Ingridient("farina", "italia", "fatta con nocciole"));
    	Plate piatto6 = new Plate("pollo fritto", "pane di farina 000, e pomodori dell'euro spin" ,listaIngredienti2);
    	
    	List<Plate> dessert1 = new ArrayList<Plate>();
    	dessert1.add(piatto5);
    	dessert1.add(piatto6);
    	
    	
    	Chef chefMR= new Chef("Mario", "Rossi", "Italia");
    	
    	
    	Buffet buffet1 = new Buffet("Buffet Carne 1", "molto buono", chefMR);
    	
    	buffet1.setPrimi(primi1);
    	buffet1.setSecondi(secondi1);
    	buffet1.setDessert(dessert1);
    	
    	buffetService.saveBuffet(buffet1);
    	
//    	//BUFFET TIPOLOGIA 2
//    	
//    	long i=0;
//    	
//    	Ingridient ingrediente1 = new Ingridient("pane","Italia", "farina 00");
//    	Ingridient ingrediente2 = new Ingridient("pasta", "Italia", "farina 00");
//    	List<Ingridient> listaIngredienti = new ArrayList<Ingridient>();
//    
//    	ingrediente1.setId(i++);
//    	ingrediente2.setId(i++);
//    	
//    	listaIngredienti.add(ingrediente1);
//    	listaIngredienti.add(ingrediente2);
//    	
//    	Plate piatto = new Plate("piatto", "buono", listaIngredienti);
//    	
//    	//PRIMI
//    	List<Plate> primi = new ArrayList<Plate>();
//    	
//    	piatto.setId(i++);
//    	primi.add(piatto);
//    	
//    	piatto.setId(i++);
//    	primi.add(piatto);
//    	
//    	//SECONDI
//    	List<Plate> secondi = new ArrayList<Plate>();
//    	
//    	piatto.setId(i++);
//    	secondi.add(piatto);
//    	
//    	piatto.setId(i++);
//    	secondi.add(piatto);
//    	
//    	//DESSERT
//    	List<Plate> dessert = new ArrayList<Plate>();
//    	
//    	piatto.setId(i++);
//    	dessert.add(piatto);
//    	
//    	piatto.setId(i++);
//    	dessert.add(piatto);
//    	
//    	Chef chefGB = new Chef("Giovanni", "Bianchi", "Germania");
//    	
//    	Buffet buffet2 = new Buffet("Buffet carne 2", "eccellente", chefGB);
//    	
//    	buffet2.setPrimi(primi);
//    	buffet2.setSecondi(secondi);
//    	buffet2.setDessert(dessert);
//    	
//    	buffetService.saveBuffet(buffet2);

    	//BUFFET TIPOLOGIA 2
    	List<Ingridient> listaIngredienti12=new ArrayList<Ingridient>();
    	listaIngredienti12.add(new Ingridient("pane", "guatemala", "aaa"));
    	listaIngredienti12.add(new Ingridient("nutella", "italia", "fatta con nocciole"));
    	Plate piatto12=new Plate("pane e nutella", "pane di farina 000, e nutella dell'euro spin" ,listaIngredienti1);
    	
    	List<Ingridient> listaIngredienti22=new ArrayList<Ingridient>();
    	listaIngredienti22.add(new Ingridient("pane", "guatemala", "aaa"));
    	listaIngredienti22.add(new Ingridient("pomodori", "italia", "fatta con nocciole"));
    	Plate piatto22 = new Plate("bruschetta con i pomodori", "pane di farina 000, e pomodori dell'euro spin" ,listaIngredienti2);
    	
    	List<Plate> primi12 = new ArrayList<Plate>();
    	primi12.add(piatto12);
    	primi12.add(piatto22);
    	
    	List<Ingridient> listaIngredienti32=new ArrayList<Ingridient>();
    	listaIngredienti32.add(new Ingridient("manzo", "guatemala", "aaa"));
    	listaIngredienti32.add(new Ingridient("pomodoro", "italia", "fatta con nocciole"));
    	Plate piatto32=new Plate("spezzatino al sugo", "pane di farina 000, e nutella dell'euro spin" ,listaIngredienti1);
    	
    	List<Ingridient> listaIngredienti42=new ArrayList<Ingridient>();
    	listaIngredienti42.add(new Ingridient("pollo", "guatemala", "aaa"));
    	listaIngredienti42.add(new Ingridient("farina", "italia", "fatta con nocciole"));
    	Plate piatto42 = new Plate("pollo fritto", "pane di farina 000, e pomodori dell'euro spin" ,listaIngredienti2);
    	
    	List<Plate> secondi12 = new ArrayList<Plate>();
    	secondi12.add(piatto32);
    	secondi12.add(piatto42);
    	
  
    	List<Ingridient> listaIngredienti52=new ArrayList<Ingridient>();
    	listaIngredienti52.add(new Ingridient("manzo", "guatemala", "aaa"));
    	listaIngredienti52.add(new Ingridient("pomodoro", "italia", "fatta con nocciole"));
    	Plate piatto52=new Plate("spezzatino al sugo", "pane di farina 000, e nutella dell'euro spin" ,listaIngredienti1);
    	
    	List<Ingridient> listaIngredienti62=new ArrayList<Ingridient>();
    	listaIngredienti62.add(new Ingridient("pollo", "guatemala", "aaa"));
    	listaIngredienti62.add(new Ingridient("farina", "italia", "fatta con nocciole"));
    	Plate piatto62 = new Plate("pollo fritto", "pane di farina 000, e pomodori dell'euro spin" ,listaIngredienti2);
    	
    	List<Plate> dessert12 = new ArrayList<Plate>();
    	dessert12.add(piatto52);
    	dessert12.add(piatto62);
    	
    	
    	Chef chefGV= new Chef("Giovanni", "Verdi", "Italia");
    	
    	
    	Buffet buffet2 = new Buffet("Buffet Carne 2", "molto buono", chefGV);
    	
    	buffet2.setPrimi(primi12);
    	buffet2.setSecondi(secondi12);
    	buffet2.setDessert(dessert12);
    	
    	buffetService.saveBuffet(buffet2);
    	
    	
    }
}
