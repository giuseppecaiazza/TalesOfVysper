package it.begear.corso.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.begear.corso.DAO.DAOMagoImpl;
import it.begear.corso.model.Mago;
import it.begear.corso.model.Utente;

@Service("MagoService")
public class MagoService {

	@Autowired
	DAOMagoImpl magoDAO;
	
	@Transactional
	public List<Mago> getMaghi(){
		return magoDAO.getMaghi();
	}
	
	@Transactional
	public void addMago(Mago mago) {
		magoDAO.addMago(mago);
}
	@Transactional
	public List<Mago> getUser(Utente user){
		return magoDAO.getUser(user);
	}
	
	@Transactional
	public List<Mago> getMago(String utente) {
		return magoDAO.getMago(utente);
	}
	
}
