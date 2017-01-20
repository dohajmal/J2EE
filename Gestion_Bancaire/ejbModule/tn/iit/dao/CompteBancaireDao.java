package tn.iit.dao;

import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.iit.model.ClientBanque;
import tn.iit.model.CompteBancaire;

@Singleton
public class CompteBancaireDao implements CompteBancaireDaoLocal {
	@PersistenceContext
	private EntityManager em;

	public CompteBancaireDao() {

	}

	public void save(CompteBancaire cb) {
		em.persist(cb);
	}

	public List<CompteBancaire> list(ClientBanque cl) {
		// return em.createNamedQuery("list",
		// CompteBancaire.class).getResultList();
		Query q = em.createQuery("select OBJECT(b) from CompteBancaire b where b.client= :cl");
		q.setParameter("cl", cl);
		List<CompteBancaire> list = (List<CompteBancaire>) q.getResultList();
		return list;
	}

	public List<CompteBancaire> listC() {
		Query q1 = em.createNamedQuery("listCompte", CompteBancaire.class);
		List<CompteBancaire> listC = (List<CompteBancaire>) q1.getResultList();
		return listC;
	}

	public List<CompteBancaire> listRib(Long rib) {
		Query q = em.createQuery("select OBJECT(b) from CompteBancaire b where rib != :rib");
		q.setParameter("rib", rib);
		List<CompteBancaire> list = (List<CompteBancaire>) q.getResultList();
		return list;
	}

	public void remove(CompteBancaire cb) {
		em.remove(em.find(CompteBancaire.class, cb.getRib()));

	}

	public void update(CompteBancaire cb) {
		em.merge(cb);

	}

	public boolean retraitArgent(long rib, double solde) {
		CompteBancaire c1 = em.find(CompteBancaire.class, rib);
		if (solde <= c1.getSolde()) {
			c1.setSolde(c1.getSolde() - solde);
			em.merge(c1);
			return true;
		} else {
			return false;
		}
	}

	public void depotArgent(long rib, double solde) {
		CompteBancaire c1 = em.find(CompteBancaire.class, rib);
		c1.setSolde(c1.getSolde() + solde);
		em.merge(c1);

	}

}