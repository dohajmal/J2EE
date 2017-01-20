package tn.iit.hello;

import javax.ejb.LocalBean;
import javax.ejb.Stateful;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

/**
 * Session Bean implementation class HelloEJBBean
 */
@Stateless
@WebService(endpointInterface="tn.iit.hello.HelloWS")
public class HelloEJBBean implements HelloLocal, HelloRemote,HelloWS{
private int i=0;
    /**
     * Default constructor. 
     */
    public HelloEJBBean() {
 
    }


	public String say_hello() {
		// TODO Auto-generated method stub
		i++;
		System.out.println("Bonjour tout le monde"+i);
		return "hello";
		
	}
	

	    public double som(double x,double y){
	    	return x+y;
	    }

	    public double mult(double x,double y){
	    	return x*y;
	    }
	
	    public double sous(double x,double y){
	    	return x-y;
	    }

}
