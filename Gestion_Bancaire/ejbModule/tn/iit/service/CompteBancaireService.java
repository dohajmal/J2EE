package tn.iit.service;

import java.util.List;

import javax.ejb.EJB;
import javax.ejb.LocalBean;
import javax.ejb.Stateless;

import tn.iit.dao.ClientBanqueDaoLocal;
import tn.iit.dao.CompteBancaireDao;
import tn.iit.dao.CompteBancaireDaoLocal;
import tn.iit.model.ClientBanque;
import tn.iit.model.CompteBancaire;

@Stateless
@LocalBean
public class CompteBancaireService implements CompteBancaireServiceLocal {
	@EJB
	private CompteBancaireDaoLocal dao;

	public void save(CompteBancaire cb) {
		System.out.println(cb.getSolde());
		dao.save(cb);
	}

	public void remove(CompteBancaire cb) {
		dao.remove(cb);
	}

	public List<CompteBancaire> list(ClientBanque cl) {
		return dao.list(cl);
	}

	public void depotArgent(long rib, double solde) {
		dao.depotArgent(rib, solde);
	}

	public void retraitArgent(long rib, double solde) {
		dao.retraitArgent(rib, solde);
	}

	@Override
	public void update(CompteBancaire cb) {
		dao.update(cb);

	}
	public List<CompteBancaire> listC(){
		return dao.listC();
	}
	public List<CompteBancaire> listRib(Long rib){
		return dao.listRib(rib);
	}

}