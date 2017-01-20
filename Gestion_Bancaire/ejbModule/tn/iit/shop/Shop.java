package tn.iit.shop;

import java.util.ArrayList;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.ejb.EJB;
import javax.ejb.Stateless;
import javax.jws.WebService;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import sun.net.www.content.text.plain;
import tn.iit.calculatrice.CalculatriceRemote;



/**
 * Session Bean implementation class ShopBean
 */
@Stateless
@WebService(endpointInterface="tn.iit.shop.Compte_bancaireWS")
public class Shop implements ShopRemote, ShopLocal ,Compte_bancaireWS{
	@PersistenceContext
	private EntityManager em;
	/*private List<ProduitDto> listProduit = new ArrayList<>();*/
	private double total = 0;
	@EJB 
	CalculatriceRemote cal ;
	
	public Shop() {
		// TODO Auto-generated constructor stub
	}

   //lister
    public List<ProduitDto> listproduit(){
    	
    	Query q = em.createNamedQuery("list");
    	List<ProduitDto> list= (List<ProduitDto>) q.getResultList();
		return list;
		}
    //supprimer
	public boolean suppressionProduit(String nom, int quantite,double prix) {
		ProduitDto c1= em.find(ProduitDto.class,nom);
		if((c1.getQuantite()-quantite)>0){
			c1.setQuantite(c1.getQuantite()-quantite);
			c1.setPrix(c1.getPrix()-prix);
			em.merge(c1);
			return true;
		}else{
			em.remove(c1);
			return false;
		}
	}
	//ajouter
	
	  public void creerclient(String nom, double prix, int quantite) {
	    	ProduitDto c1= new ProduitDto(nom,prix,quantite);
	    	em.persist(c1);

	        }
	  //modifier
		@Override
		public void achatProduit(String nom, int quantite, double prix) {
			ProduitDto c1=em.find(ProduitDto.class, nom);
			if(c1==null){
				em.persist(c1);
			}
			else{
				c1.setQuantite(c1.getQuantite()+quantite);
				c1.setPrix(c1.getPrix()+prix);
				em.merge(c1);
			}
			
		}

			@Override
		public double getTotal() {
				total =0;
				for (int i = 0; i < listproduit().size(); i++) {
					total +=cal.mult(listproduit().get(i).getPrix(), listproduit().get(i).getQuantite());
				}
			return total;
			
	
		}



		}

	
  /*
	@Override
	public void achatProduit(String produit, int quantite, double prix) {
			ProduitDto pro= new ProduitDto(produit, prix, quantite);
		if (!listProduit.contains(produit)){
			listProduit.add(pro);
		}else{
			int indice=listProduit.indexOf(pro);
			listProduit.get(indice).setQuantite(listProduit.get(indice).getQuantite()+quantite);
		}
	}

	@Override
	public String listProduitAchete() {
		
		StringBuilder s = new StringBuilder();
	
		for( ProduitDto p : listProduit){
			s.append(p.toString());
			s.append("\n");
			//s+=p.getNom()+ "\t" + p.getPrix()+"\t"+ p.getQuantite() + "\n";
		}
		return s.toString();
	}

	@Override
	public boolean suppressionProduit(String produit, int quantite) {
	/*	listProduit.remove(produit);
		listQuantite.remove(quantite);*/
/*		return true;
	}

	@Override
	public double getTotal() {
		total =0;
		/*for (int i = 0; i < listProduit.size(); i++) {
			total +=cal.multi(listPrix.get(i), listQuantite.get(i));
		}*/
	/*	for( ProduitDto p : listProduit){
			total+=cal.som(total,cal.mult(p.getPrix(),p.getQuantite()));
		}
		return total;
	}

	@Override
	public void payement(long rib) {
		// TODO Auto-generated method stub

	}
	@PostConstruct
	public void nouveauClient(){
		System.out.println("Nouveau client s'est connecté***********************************");
	}
public ArrayList<String> listproduit(){
	 ArrayList<String> listProduit = new ArrayList<>();

	return listProduit;
	
}*/

    
