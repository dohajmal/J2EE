package tn.iit.dao;

import java.util.List;

import javax.ejb.Local;

import tn.iit.model.Server;

@Local
public interface ServerDaoLocal {
	void save(Server s);
	void delete(Server s);
	void update(Server s);
	List<Server> getAllS();
}