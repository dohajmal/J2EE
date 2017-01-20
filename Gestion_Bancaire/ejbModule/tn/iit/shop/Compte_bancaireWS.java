package tn.iit.shop;

import javax.jws.WebService;
import javax.jws.soap.SOAPBinding;

@WebService
@SOAPBinding(style=SOAPBinding.Style.RPC)
public interface Compte_bancaireWS extends java.rmi.Remote {
	void achatProduit(String nom, int quantite, double prix);
	//String listProduitAchete();
	boolean suppressionProduit(String nom, int quantite, double prix);
	double getTotal();

}