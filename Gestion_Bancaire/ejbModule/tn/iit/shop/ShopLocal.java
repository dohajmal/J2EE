package tn.iit.shop;

import java.util.ArrayList;
import java.util.List;

import javax.ejb.Local;

@Local
public interface ShopLocal {
	void achatProduit(String nom, int quantite, double prix);
	//String listProduitAchete();
	boolean suppressionProduit(String nom, int quantite, double prix);
	double getTotal();
	void creerclient(String nom, double prix, int quantite);
	//void payement(long rib);
	List<ProduitDto> listproduit();
	//ArrayList<String> listproduit();

}
