package tn.iit.shop;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQuery;
@Entity
@NamedQuery(name="list",query="select OBJECT(b) from ProduitDto b")
public class ProduitDto implements Serializable {
	@Override
	public String toString() {
		return "ProduitDto [nom=" + nom + ", prix=" + prix + ", quantite=" + quantite + "]";
	}
	@Id
	private String nom;
	private double prix ;
	private int quantite;
	
	public String getNom() {
		return nom;
	}
	public void setNom(String nom) {
		this.nom = nom;
	}
	public double getPrix() {
		return prix;
	}
	public void setPrix(double prix) {
		this.prix = prix;
	}
	public int getQuantite() {
		return quantite;
	}
	public ProduitDto(String nom, double prix, int quantite) {
		super();
		this.nom = nom;
		this.prix = prix;
		this.quantite = quantite;
	}
	
	public ProduitDto() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + quantite;
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
		ProduitDto other = (ProduitDto) obj;
		if (quantite != other.quantite)
			return false;
		return true;
	}
	public void setQuantite(int i) {

		
	}
	
	}


