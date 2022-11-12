package it.begear.corso.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import it.begear.corso.model.Arciere;
import it.begear.corso.model.Guerriero;
import it.begear.corso.model.Utente;

@Repository
public class DAOGuerrieroImpl implements DAOGuerriero {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Guerriero addGuerriero(Guerriero guerriero) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(guerriero);
		return guerriero;
	}
	
	public List<Guerriero> getGuerrieri() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Guerriero> guerrieri = session.createQuery("from Guerriero").list();;
		return guerrieri;
	}
	
	public List<Guerriero> getUser(Utente user){
		Session session = this.sessionFactory.getCurrentSession();
		List<Guerriero> guerrieri = session.createQuery("select utente from Guerriero where utente like '"+user.getUtente()+"'").list();
		return guerrieri;
	}
	
	public List<Guerriero> getGuerriero(String utente) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Guerriero> guerrieri = session.createQuery("from Guerriero where utente like '"+utente+"'").list();;
		return guerrieri;
	}
	


}
