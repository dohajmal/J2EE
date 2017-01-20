package tn.iit.ejbclientHello;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import tn.iit.hello.HelloRemote;

public class Client {
	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Properties jndiProperties = new Properties();
		jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		Context ctx = new InitialContext(jndiProperties);
		HelloRemote s = (HelloRemote) ctx.lookup("ejb:EntreproseHelloEjbProject/HelloEJB/HelloEJBBean!tn.iit.HelloRemote?stateful");
		System.out.println(s.say_hello());

	}
}
