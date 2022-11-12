package it.begear.corso.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import it.begear.corso.DAO.DAOMostroImpl;
import it.begear.corso.model.Mostro;

@Service("MostroService")
public class MostroService {

	@Autowired
	DAOMostroImpl mostroDAO;
	
	@Transactional
	public List<Mostro> getMostroA1(){
		return mostroDAO.getMostroA1();
	}
	
	@Transactional
	public List<Mostro> getMostroA2(){
		return mostroDAO.getMostroA2();
	}
	
	@Transactional
	public List<Mostro> getMostroA3(){
		return mostroDAO.getMostroA3();
	}
}
