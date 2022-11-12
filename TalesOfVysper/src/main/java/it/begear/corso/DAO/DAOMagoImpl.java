package it.begear.corso.DAO;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import it.begear.corso.model.Arciere;
import it.begear.corso.model.Mago;
import it.begear.corso.model.Utente;

@Repository
public class DAOMagoImpl implements DAOMago {
	
	@Autowired
	private SessionFactory sessionFactory;
	
	public Mago addMago(Mago mago) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(mago);
		return mago;
	}
	
	public List<Mago> getMaghi() {
		Session session = this.sessionFactory.getCurrentSession();
		List<Mago> maghi = session.createQuery("from Mago").list();;
		return maghi;
	}

	public List<Mago> getUser(Utente user){
		Session session = this.sessionFactory.getCurrentSession();
		List<Mago> maghi = session.createQuery("select utente from Mago where utente like '"+user.getUtente()+"'").list();
		return maghi;
	}
	
	public List<Mago> getMago(String utente) {
		Session session = this.sessionFactory.getCurrentSession();
		List<Mago> maghi = session.createQuery("from Mago where utente like '"+utente+"'").list();;
		return maghi;
	}
}
