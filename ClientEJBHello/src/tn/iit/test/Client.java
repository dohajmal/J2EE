package tn.iit.test;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;

import tn.iit.service.HelloRemote;

public class Client {
	public static void main(String[] args) throws Exception
	{
	Properties jndiProperties= new Properties();
	jndiProperties.put(Context.URL_PKG_PREFIXES,"org.jboss.ejb.client.naming");
	Context ctx= new InitialContext(jndiProperties);
	HelloRemote hello = (HelloRemote) ctx.lookup("ejb:/FirstEjbProject/HelloBean!tn.iit.service.HelloRemote");
	System.out.println(hello.sayHello()); }
}
