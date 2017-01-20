package tn.iit.dao;

import java.util.List;

import javax.ejb.Local;

import tn.iit.model.ClientBanque;
import tn.iit.model.CompteBancaire;

@Local
public interface ClientBanqueDaoLocal {
	void save(ClientBanque cl);
	void delete(ClientBanque cl);
	void update(ClientBanque cl);
	List<ClientBanque> list();
	public ClientBanque find(String cin);
}
