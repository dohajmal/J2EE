package tn.iit.model;

import java.io.Serializable;
import java.util.Collection;
import java.util.Date;
import java.util.List;
import java.util.Set;

import javax.persistence.CascadeType;
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
@NamedQuery(name = "achat", query = "select OBJECT(b) from Achat b")
public class Achat implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idAchat;
	private Date date;
	private float totalHt;
	private float remise;

	@OneToMany(mappedBy = "achat", fetch = FetchType.EAGER, cascade = CascadeType.ALL)
	private Collection<LigneAchat> ligneAchat;

	public Achat() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Achat(long idAchat, Date date, float totalHt, float remise) {
		super();
		this.idAchat = idAchat;
		this.date = date;
		this.totalHt = totalHt;
		this.remise = remise;
	}

	/*
	 * @OneToMany public Set<LigneAchat> getLigneachat() { return ligneachat; }
	 * public void setLigneachat(Set<LigneAchat> ligneachat) { this.ligneachat =
	 * ligneachat; }
	 */
	public long getIdAchat() {
		return idAchat;
	}

	public void setIdAchat(long idAchat) {
		this.idAchat = idAchat;
	}

	public Date getDate() {
		return date;
	}

	public void setDate(Date date) {
		this.date = date;
	}

	public float getTotalHt() {
		return totalHt;
	}

	public void setTotalHt(float totalHt) {
		this.totalHt = totalHt;
	}

	public float getRemise() {
		return remise;
	}

	public void setRemise(float remise) {
		this.remise = remise;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idAchat ^ (idAchat >>> 32));
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
		Achat other = (Achat) obj;
		if (idAchat != other.idAchat)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Article [idAchat=" + idAchat + ", date=" + date + ", totalHt=" + totalHt + ", remise=" + remise + "]";
	}

}