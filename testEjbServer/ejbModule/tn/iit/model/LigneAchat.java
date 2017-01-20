package tn.iit.model;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name = "ligneAchat", query = "select OBJECT(b) from LigneAchat b")
public class LigneAchat implements Serializable {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idLigneAchat;
	private int quantite;
	
	@ManyToOne
    @JoinColumn(name="idArticle")
	private Article article;
	
	@ManyToOne
    @JoinColumn(name="idAchat")
	private Achat achat;
	public LigneAchat() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public LigneAchat(long idLigneAchat, int quantite, Article article, Achat achat) {
		super();
		this.idLigneAchat = idLigneAchat;
		this.quantite = quantite;
		this.article = article;
		this.achat = achat;
	}

	public long getIdLigneAchat() {
		return idLigneAchat;
	}
	public void setIdLigneAchat(long idLigneAchat) {
		this.idLigneAchat = idLigneAchat;
	}
	public int getQuantite() {
		return quantite;
	}
	public void setQuantite(int quantite) {
		this.quantite = quantite;
	}

	/*@ManyToOne
	@JoinColumn(name = "idAchat")*/
	public Achat getAchat() {
		return achat;
	}
	public void setAchat(Achat achat) {
		this.achat = achat;
	}
	
	public Article getArticle() {
		return article;
	}

	public void setArticle(Article article) {
		this.article = article;
	}

	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idLigneAchat ^ (idLigneAchat >>> 32));
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		LigneAchat other = (LigneAchat) obj;
		if (idLigneAchat != other.idLigneAchat)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "LigneAchat [idLigneAchat=" + idLigneAchat + ", quantite=" + quantite + ",article=" + article
				+ ", achat=" + achat + "]";
	}
	
}
