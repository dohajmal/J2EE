package tn.iit.calculatrice;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class Calculatrice
 */
@Stateless
@LocalBean
public class Calculatrice implements CalculatriceLocal,CalculatriceRemote{

    /**
     * Default constructor. 
     */
    public Calculatrice() {
        // TODO Auto-generated constructor stub
    }
    @Override
    public double som(double x,double y){
    	return x+y;
    }
    @Override
    public double mult(double x,double y){
    	return x*y;
    }
    @Override
    public double sous(double x,double y){
    	return x-y;
    }
}
