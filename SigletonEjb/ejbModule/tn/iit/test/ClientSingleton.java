package tn.iit.test;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.iit.service.SingletonRemote;


public class ClientSingleton {

	public static void main(String[] args) throws NamingException {
		Properties jndiProperties= new Properties();
		jndiProperties.put(Context.URL_PKG_PREFIXES,"org.jboss.ejb.client.naming");
		Context ctx= new InitialContext(jndiProperties);
		SingletonRemote singl = (SingletonRemote) ctx.lookup("ejb:/SigletonEjb/SingletonEjb!tn.iit.service.SingletonRemote");
		System.out.println(singl.add(2, 3));
		

	}

}
