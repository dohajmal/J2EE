package tn.iit.test;

import java.util.Date;

import javax.ejb.EJB;
import javax.ejb.Stateless;

import tn.iit.bean.GestionAchatRemote;
import tn.iit.bean.GestionArticleRemote;
import tn.iit.model.Achat;

@Stateless
public class TestAchat implements TestAchatRemote  {
@EJB GestionAchatRemote gestionAchatRemote;
@EJB GestionArticleRemote gestionArticleRemote;

public void testCreationAchat(){
	long idArticle1=gestionArticleRemote.ajoutArticle("huile","Exon4T",45000);
	long idArticle2=gestionArticleRemote.ajoutArticle("Filtre","GIF",5000);
gestionArticleRemote.ajoutArticle("huile","Exon4T",45000);
Achat achat=gestionAchatRemote.creerAchat(new Date());
gestionAchatRemote.AjoutLigneAchat(achat, idArticle1, 5);
gestionAchatRemote.AjoutLigneAchat(achat, idArticle2, 2);
gestionAchatRemote.AjoutLigneAchat(achat, idArticle2, 2);
gestionAchatRemote.calculTotal(achat, 8);
System.out.println("TotalHT = "+achat.getTotalHt());
	
}

}