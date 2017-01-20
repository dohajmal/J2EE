package tn.iit.hello;

import javax.jws.WebMethod;
import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style=SOAPBinding.Style.RPC)
public interface HelloWS extends java.rmi.Remote {
	@WebMethod
	String say_hello();
}
