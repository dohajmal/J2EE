package tn.iit.service;

import java.util.List;


import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import tn.iit.dao.ClientBanqueDaoLocal;
import tn.iit.model.ClientBanque;

@Stateless
@LocalBean
public class ClientBanqueService implements ClientBanqueServiceLocal{
	@EJB
	private ClientBanqueDaoLocal dao;
	
	public void save(ClientBanque cl) {
		System.out.println("ddd"+cl.getAdresse());
		System.out.println("ddd"+cl.getNom());
		System.out.println("ddd"+cl.getPrenom());
		
		dao.save(cl);
	}
	public void delete(ClientBanque cl) {
		dao.delete(cl);
	}

	public void update(ClientBanque cl) {
		dao.update(cl);
	}
	public List<ClientBanque> list() {
		return dao.list();
	}
	public ClientBanque find(String cin){
		System.out.println(cin);
			return	dao.find(cin);

	}
}
