package tn.iit.bean;

import java.util.Date;

import javax.ejb.LocalBean;
import javax.ejb.Remote;
import javax.ejb.Stateless;

import tn.iit.model.Achat;

/**
 * Session Bean implementation class GestionAchatRemote
 */
@Remote
public interface GestionAchatRemote {

	Achat creerAchat(Date date);
	void AjoutLigneAchat(Achat achat,long idArticle, int quantite);
	void calculTotal(Achat achat,float remise);


}
