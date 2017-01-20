package tn.iit.service;

import javax.ejb.Local;

/**
 * Session Bean implementation class SingletonLocal
 */

@Local
public interface SingletonLocal {

 double add(double a,double b);

}
