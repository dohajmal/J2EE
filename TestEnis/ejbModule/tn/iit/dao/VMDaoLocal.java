package tn.iit.dao;

import java.util.List;

import javax.ejb.Local;

import tn.iit.model.VM;

@Local
public interface VMDaoLocal {

	void save(VM v);
	void delete(VM v);
	void update(VM v);
	List<VM> getAll() ;
}
