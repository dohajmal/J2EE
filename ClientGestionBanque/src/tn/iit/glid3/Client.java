package tn.iit.glid3;

import java.util.Properties;

import javax.naming.Context;
import javax.naming.InitialContext;
import javax.naming.NamingException;

import tn.iit.shop.ShopRemote;

public class Client {

	public static void main(String[] args) throws NamingException {
	
			Properties jndiProperties = new Properties();
			jndiProperties.put(Context.URL_PKG_PREFIXES, "org.jboss.ejb.client.naming");
			Context ctx = new InitialContext(jndiProperties);
			ShopRemote s = (ShopRemote) ctx.lookup("ejb:GestionBancaireEar/Gestion_Bancaire/Shop!tn.iit.shop.ShopRemote?stateful");
			s.achatProduit("Thon", 2, 14.5);
			s.achatProduit("ghj", 2, 2.5);
			System.out.println(s.listProduitAchete());
			s.suppressionProduit("ghj", 2);
			System.out.println("Total = "+ s.getTotal());

		
	}
}