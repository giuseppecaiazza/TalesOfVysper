package it.begear.corso.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.begear.corso.DAO.DAOArciereImpl;
import it.begear.corso.model.Arciere;
import it.begear.corso.model.Utente;

@Service("ArciereService")
public class ArciereService {
	
	@Autowired
	DAOArciereImpl arciereDAO;

	@Transactional
	public List<Arciere> getArcieri(){
		return arciereDAO.getArcieri();
	}

	@Transactional
	public void addArciere(Arciere arciere) {
		arciereDAO.addArciere(arciere);
	}
	
	@Transactional
	public List<Arciere> getUser(Utente user){
		return arciereDAO.getUser(user);
	}
	
	@Transactional
	public List<Arciere> getArciere(String utente){
		return arciereDAO.getArciere(utente);
	}
	


}
