package tn.iit.service;

import java.util.List;

import javax.ejb.Local;

import tn.iit.model.ClientBanque;
import tn.iit.model.CompteBancaire;

@Local
public interface CompteBancaireServiceLocal {
	void save(CompteBancaire cb);

	void remove(CompteBancaire cb);

	void update(CompteBancaire cb);

	 List<CompteBancaire> list(ClientBanque cl);
	 void depotArgent(long rib, double solde);
	 void retraitArgent(long rib, double solde);
	 List<CompteBancaire> listC();
	 List<CompteBancaire> listRib(Long rib);
	 }
