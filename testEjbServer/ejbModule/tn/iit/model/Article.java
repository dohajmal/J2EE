package tn.iit.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Set;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name = "article", query = "select OBJECT(b) from Article b")
public class Article implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idArticle;
	private String libelle;
	//reference unique par article
	@Column(unique=true)
	private String reference;
	private float prixAchatHT;
	private int stock;

	@OneToMany(mappedBy="article",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private Collection <LigneAchat> ligneAchat;

	public Article(long idArticle, String libelle, String reference, float prixAchatHT, int stock) {
		super();
		this.idArticle = idArticle;
		this.libelle = libelle;
		this.reference = reference;
		this.prixAchatHT = prixAchatHT;
		this.stock = stock;
	}

	public Article() {
		super();
		// TODO Auto-generated constructor stub
	}

	public long getIdArticle() {
		return idArticle;
	}

	public void setIdArticle(long idArticle) {
		this.idArticle = idArticle;
	}

	public String getLibelle() {
		return libelle;
	}

	public Article(String libelle, String reference, float prixAchatHT) {
		super();
		this.libelle = libelle;
		this.reference = reference;
		this.prixAchatHT = prixAchatHT;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public String getReference() {
		return reference;
	}

	public void setReference(String reference) {
		this.reference = reference;
	}

	public float getPrixAchatHT() {
		return prixAchatHT;
	}

	public void setPrixAchatHT(float prixAchatHT) {
		this.prixAchatHT = prixAchatHT;
	}

	public int getStock() {
		return stock;
	}

	public void setStock(int stock) {
		this.stock = stock;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idArticle ^ (idArticle >>> 32));
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
		Article other = (Article) obj;
		if (idArticle != other.idArticle)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Article [idArticle=" + idArticle + ", libelle=" + libelle + ", reference=" + reference
				+ ", prixAchatHT=" + prixAchatHT + ", stock=" + stock + "]";
	}

}
