package it.begear.corso.DAO;

import java.util.List;

import it.begear.corso.model.Arciere;
import it.begear.corso.model.Utente;

public interface DAOArciere {
	
	public Arciere addArciere(Arciere arciere);
	
	public List<Arciere> getArcieri() ;
	
	public List<Arciere> getUser(Utente user);
	
	public List<Arciere> getArciere(String utente);
	
}
