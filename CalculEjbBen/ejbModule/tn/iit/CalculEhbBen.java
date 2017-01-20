package tn.iit;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;

/**
 * Session Bean implementation class HelloEJBBean
 */
@Stateless
@LocalBean
public class CalculEhbBen implements CalculLocal{
int i=0;
    /**
     * Default constructor. 
     */
    public CalculEhbBen() {
    
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
	    public int cal(int i){
	    	return i++;
	    }

}
