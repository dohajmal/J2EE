package tn.iit.service;

import javax.ejb.Local;
import javax.ejb.Remote;

@Local
public interface HelloLocal {
	String sayHello();
	int calucl(int a, int b);
}
