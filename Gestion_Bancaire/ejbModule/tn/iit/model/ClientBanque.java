package tn.iit.model;

import java.io.Serializable;
import java.util.Set;

import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;

@Entity
@NamedQuery(name = "listClientt", query = "select OBJECT(b) from ClientBanque b")
public class ClientBanque implements Serializable {

	private String cin;

	protected Set<CompteBancaire> comptebancaire;

	private String nom, prenom, adresse;

	@Override
	public String toString() {
		return "ClientBanqueDTO [cin=" + cin + ", nom=" + nom + ", prenom=" + prenom + ", adresse=" + adresse + "]";
	}
	
	

	public ClientBanque() {
	}



	public ClientBanque(String cin, Set<CompteBancaire> comptebancaire) {
		super();
		this.cin = cin;
		this.comptebancaire = comptebancaire;
	}



	public ClientBanque(String cin, String nom, String prenom, String adresse) {
		super();
		this.cin = cin;
		this.nom = nom;
		this.prenom = prenom;
		this.adresse = adresse;
	}

	@Id
	public String getCin() {
		return cin;
	}

	public void setCin(String cin) {
		this.cin = cin;
	}

	@OneToMany
	public Set<CompteBancaire> getComptebancaire() {
		return comptebancaire;
	}

	public void setComptebancaire(Set<CompteBancaire> comptebancaire) {
		this.comptebancaire = comptebancaire;
	}

	public String getNom() {
		return nom;
	}

	public void setNom(String nom) {
		this.nom = nom;
	}

	public String getPrenom() {
		return prenom;
	}

	public void setPrenom(String prenom) {
		this.prenom = prenom;
	}

	public String getAdresse() {
		return adresse;
	}

	public void setAdresse(String adresse) {
		this.adresse = adresse;
	}
}
