package it.begear.corso.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import it.begear.corso.model.Arciere;
import it.begear.corso.model.Utente;

@Repository
public class DAOArciereImpl implements DAOArciere {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Arciere addArciere(Arciere arciere) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(arciere);
		return arciere;
	}
	
	public List<Arciere> getArcieri() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Arciere> arcieri = session.createQuery("from Arciere").list();
		return arcieri;
	}
	
	public List<Arciere> getUser(Utente user){
		Session session = this.sessionFactory.getCurrentSession();
		List<Arciere> arcieri = session.createQuery("select utente from Arciere where utente like '"+user.getUtente()+"'").list();
		return arcieri;
	}
	
	public List<Arciere> getArciere(String utente) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Arciere> arcieri = session.createQuery("from Arciere where utente like '"+utente+"'").list();
		return arcieri;
	}
	
	
	
	

	
}
