package it.begear.corso.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.begear.corso.DAO.DAOUtenteImpl;
import it.begear.corso.model.Utente;

@Service("UtenteService")
public class UtenteService {

	@Autowired
	DAOUtenteImpl utenteDAO;

	@Transactional
	public List<Utente> getUsers(){
		return utenteDAO.getUsers();
	}

	@Transactional
	public void addUser(Utente user) {
		utenteDAO.addUser(user);

	}
	@Transactional
	public List<Utente> SelectUser(Utente user){
		return utenteDAO.SelectUser(user);
	}


}
