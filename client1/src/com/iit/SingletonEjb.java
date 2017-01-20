package com.iit;

import javax.ejb.LocalBean;
import javax.ejb.Singleton;

/**
 * Session Bean implementation class SingletonEjb
 */
@Singleton
@LocalBean
public class SingletonEjb {

    /**
     * Default constructor. 
     */
    public SingletonEjb() {
        // TODO Auto-generated constructor stub
    	
    	}
    public double add(double a,double b){
		return a+b;
    }

}
