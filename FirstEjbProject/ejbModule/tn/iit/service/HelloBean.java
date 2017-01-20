package tn.iit.service;

import javax.ejb.Stateless;

/**
 * Session Bean implementation class HelloBean
 */
@Stateless
public class HelloBean implements HelloRemote {

	@Override
	public String sayHello() {
		return "Hello Jamla";
	}
	@Override
  public int calucl(int a, int b){
	return a+b;
}
   

}
