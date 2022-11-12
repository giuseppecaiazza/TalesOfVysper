package it.begear.corso.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;


import it.begear.corso.model.Mostro;

@Repository
public class DAOMostroImpl implements DAOMostro {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public List<Mostro> getMostroA1(){
		Session session = this.sessionFactory.getCurrentSession();
		List<Mostro> arpie = session.createQuery("from Mostro where area like 'area1'").list();
		return arpie;
	}
	
	public List<Mostro> getMostroA2(){
		Session session = this.sessionFactory.getCurrentSession();
		List<Mostro> golem = session.createQuery("from Mostro where area like 'area2'").list();
		return golem;
	}
	
	public List<Mostro> getMostroA3(){
		Session session = this.sessionFactory.getCurrentSession();
		List<Mostro> spiriti = session.createQuery("from Mostro where area like 'area3'").list();
		return spiriti;
	}

}
