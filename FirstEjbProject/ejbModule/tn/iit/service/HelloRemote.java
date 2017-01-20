package tn.iit.service;

import javax.ejb.Remote;

@Remote
public interface HelloRemote {
	String sayHello();
	int calucl(int a, int b);
}
