package tn.iit.bean;

import javax.ejb.Remote;

import tn.iit.model.Article;

/**
 * Session Bean implementation class GestionArticleRemote
 */
@Remote
public interface GestionArticleRemote {

  Article getById(long idArticle);
  Article getByReference(String reference);
  long ajoutArticle(String libelle, String reference, float prixAchatHT);
}
