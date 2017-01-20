package tn.iit.bean;

import javax.ejb.LocalBean;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

import tn.iit.model.Achat;
import tn.iit.model.Article;

/**
 * Session Bean implementation class GestionArticle
 */
@Stateless
@LocalBean
public class GestionArticle implements GestionArticleRemote {

	@PersistenceContext
	private EntityManager em;

	public GestionArticle() {
		// TODO Auto-generated constructor stub
	}

	public Article getById(long idArticle) {
		Article c1 = em.find(Article.class, idArticle);
		return c1;
	}

	public Article getByReference(String reference) {
		Query q = em.createQuery("select OBJECT(b) from Article a where a.reference= :ref");
		q.setParameter("ref", reference);
		return (Article) q.getSingleResult();
	}

	public long ajoutArticle(String libelle, String reference, float prixAchatHT) {

		if (getByReference(reference) == null) {
			Article a = new Article(libelle, reference, prixAchatHT);
			em.persist(a);
			System.out.println("ajout avec succ�es ");
			return getByReference(reference).getIdArticle() ;

		}
		System.out.println("reference est existant ,alors ajout annuler");
		return 0;
	}
}
