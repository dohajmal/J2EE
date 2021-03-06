package tn.iit.dao;


import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.iit.model.Server;

public class ServerDao implements ServerDaoLocal{
	@PersistenceContext
	private EntityManager em;

	public void save(Server s) {
		em.persist(s);
	}

	public void delete(Server s) {
		em.remove(em.find(Server.class, s.getIdServer()));
	}

	public void update(Server s) {

		em.merge(s);
	}

	public List<Server> getAllS() {
		Query q = em.createNamedQuery("server", Server.class);
		List<Server> list = (List<Server>) q.getResultList();
		return list;
	}
}

