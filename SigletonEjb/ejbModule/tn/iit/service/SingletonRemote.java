package tn.iit.service;


import javax.ejb.Remote;
import javax.ejb.Singleton;

/**
 * Session Bean implementation class SingletonLocal
 */
@Remote
public interface SingletonRemote {

 double add(double a,double b);

}
