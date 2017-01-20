package tn.iit.service;

import java.util.List;


import javax.ejb.Local;

import tn.iit.model.ClientBanque;
@Local
public interface ClientBanqueServiceLocal {
	void save(ClientBanque cl);
	void delete(ClientBanque cl);
	void update(ClientBanque cl);
	List<ClientBanque> list();
	
}
