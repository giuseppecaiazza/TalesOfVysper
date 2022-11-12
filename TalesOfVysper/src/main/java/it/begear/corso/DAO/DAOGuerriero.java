package it.begear.corso.DAO;

import java.util.List;

import it.begear.corso.model.Guerriero;
import it.begear.corso.model.Utente;

public interface DAOGuerriero {
	
	public Guerriero addGuerriero(Guerriero guerriero);
	
	public List<Guerriero> getGuerrieri();
	
	public List<Guerriero> getUser(Utente user);
	
	public List<Guerriero> getGuerriero(String utente);

}
