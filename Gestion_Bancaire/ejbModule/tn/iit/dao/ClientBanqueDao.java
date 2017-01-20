package tn.iit.dao;

import java.util.List;

import javax.ejb.Singleton;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.iit.model.ClientBanque;


@Singleton
public class ClientBanqueDao implements ClientBanqueDaoLocal {
	@PersistenceContext
	private EntityManager emm;
	public ClientBanqueDao(){}
	
	
	public void save(ClientBanque cl) {
	emm.persist(cl);
	}
	
	public void delete(ClientBanque cl) {
		emm.remove(emm.find(ClientBanque.class, cl.getCin()));		
	}

	public void update(ClientBanque cl) {
		
		emm.merge(cl);
	}

	//@SuppressWarnings("unchecked")
	public List<ClientBanque> list() {
		Query q1 = emm.createNamedQuery("listClientt", ClientBanque.class);
		List<ClientBanque> list = (List<ClientBanque>) q1.getResultList();
		return list;
	}
	public ClientBanque find(String cin){
		System.out.println(cin);
	 ClientBanque cl=emm.find(ClientBanque.class, cin);
		return cl;
	}
	
}
