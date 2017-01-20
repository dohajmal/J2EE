package tn.iit.dao;

import java.util.List;

import javax.ejb.Local;

import tn.iit.model.ClientBanque;
import tn.iit.model.CompteBancaire;

@Local
public interface CompteBancaireDaoLocal {
	void save(CompteBancaire cb);


	void remove(CompteBancaire cb) ;

	void update(CompteBancaire cb) ;

	List<CompteBancaire> list(ClientBanque cl);
	boolean retraitArgent(long rib, double solde);
	void depotArgent(long rib, double solde);
	List<CompteBancaire> listC();
	List<CompteBancaire> listRib(Long rib);
	}
