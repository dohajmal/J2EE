package tn.iit.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQuery;

@Entity
@NamedQuery(name = "listCompte", query = "select OBJECT(b) from CompteBancaire b")
public class CompteBancaire implements java.io.Serializable {

	private long rib;
	private double solde;
	private ClientBanque client;

	public CompteBancaire(long rib, ClientBanque client, double solde) {
		super();
		this.rib = rib;
		this.client = client;
		this.solde = solde;
	}

	public CompteBancaire(long rib) {
		this.rib = rib;
	}

	public CompteBancaire() {
	}

	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	@Column(name = "RIB")
	public long getRib() {
		return rib;
	}

	public void setRib(long rib) {
		this.rib = rib;
	}

	@ManyToOne
	@JoinColumn(name = "ID_CLIENT")
	public ClientBanque getClient() {
		return client;
	}

	public void setClient(ClientBanque client) {
		this.client = client;
	}

	@Column(name = "SOLDE")
	public double getSolde() {
		return solde;
	}

	public void setSolde(double solde) {
		this.solde = solde;
	}

}
