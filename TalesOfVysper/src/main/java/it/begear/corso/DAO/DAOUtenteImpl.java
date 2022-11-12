package it.begear.corso.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import it.begear.corso.model.Utente;

@Repository
public class DAOUtenteImpl implements DAOUtente {

	@Autowired
	private SessionFactory sessionFactory;

	public List<Utente> SelectUser(Utente user) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Utente> utenti = session.createQuery("select id, utente, password from Utente where utente like '"+user.getUtente()+ "' and password like '" + user.getPassword()+"'").list();
		return utenti;
	}

	public List<Utente> getUsers() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Utente> utenti = session.createQuery("from Utente").list();;
		return utenti;
	}

	public Utente addUser(Utente user) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(user);
		return user;
	}


}
