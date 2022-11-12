package it.begear.corso.DAO;

import java.util.List;

import it.begear.corso.model.Mago;
import it.begear.corso.model.Utente;

public interface DAOMago {

	public Mago addMago(Mago mago);
	
	public List<Mago> getMaghi();
	
	public List<Mago> getUser(Utente user);
	
	public List<Mago> getMago(String utente);
	
}
