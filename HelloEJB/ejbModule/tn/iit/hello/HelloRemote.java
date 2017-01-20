package tn.iit.hello;

import javax.ejb.Remote;

@Remote
public interface HelloRemote {
	String say_hello();
	double som(double x,double y);
	double mult(double x,double y);
	double sous(double x,double y);

}
