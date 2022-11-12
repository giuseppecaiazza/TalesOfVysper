package it.begear.corso.DAO;

import java.util.List;

import it.begear.corso.model.Utente;

public interface DAOUtente {
	
	public List<Utente> SelectUser(Utente user);
	
	public List<Utente> getUsers();
	
	public Utente addUser(Utente user);

}
