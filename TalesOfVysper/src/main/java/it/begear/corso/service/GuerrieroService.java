package it.begear.corso.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.begear.corso.DAO.DAOGuerrieroImpl;
import it.begear.corso.model.Guerriero;
import it.begear.corso.model.Utente;

@Service("GuerrieroService")
public class GuerrieroService {

	@Autowired
	DAOGuerrieroImpl guerrieroDAO;
	
	@Transactional
	public List<Guerriero> getGuerrieri(){
		return guerrieroDAO.getGuerrieri();
	}
	
	@Transactional
	public void addGuerriero(Guerriero guerriero) {
		guerrieroDAO.addGuerriero(guerriero);
	
}
	@Transactional
	public List<Guerriero> getUser(Utente user){
		return guerrieroDAO.getUser(user);
	}
	
	@Transactional
	public List<Guerriero> getGuerriero(String utente) {
		return guerrieroDAO.getGuerriero(utente);
	}
}
