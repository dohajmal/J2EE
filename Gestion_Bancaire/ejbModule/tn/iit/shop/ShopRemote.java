package tn.iit.shop;

import javax.ejb.Remote;

@Remote
public interface ShopRemote {
	void achatProduit(String nom, int quantite, double prix);
	//String listProduitAchete();
	boolean suppressionProduit(String nom, int quantite, double prix);
	double getTotal();

}
