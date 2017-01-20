package tn.iit.hello;

import javax.ejb.Local;

@Local
public interface HelloLocal {

	String say_hello();
	double som(double x,double y);
	double mult(double x,double y);
	double sous(double x,double y);
}
