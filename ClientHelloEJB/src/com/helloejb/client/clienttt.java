package com.helloejb.client;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import tn.iit.hello.HelloRemote;

public class clienttt {

	public static void main(String[] args) throws Exception{
		// TODO Auto-generated method stub
		Properties jndiProperties = new Properties();
		jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
		Context ctx = new InitialContext(jndiProperties);
		HelloRemote s = (HelloRemote) ctx.lookup("ejb:/HelloEJB/HelloEJBBean!tn.iit.HelloRemote");
		s.say_hello();

	}

}
