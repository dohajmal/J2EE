package tn.iit.service;

import javax.ejb.Singleton;

/**
 * Session Bean implementation class SingletonEjb
 */
@Singleton
public class SingletonEjb implements SingletonLocal, SingletonRemote {

	/**
	 * Default constructor.
	 */
	public SingletonEjb() {
		// TODO Auto-generated constructor stub
	}

	public double add(double a, double b) {
		return a + b;
	}
}
