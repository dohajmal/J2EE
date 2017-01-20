package tn.iit.model;

import java.io.Serializable;
import java.util.Collection;

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
@NamedQuery(name = "vm", query = "select OBJECT(b) from VM b")
public class VM implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idVm;
	private float price;
	private float ram;
	private float disk;
	private float os;
	

	@ManyToOne
    @JoinColumn(name="idserver")
	private Server server;
	
	public VM() {
		super();
		// TODO Auto-generated constructor stub
	}

	public VM(long idVm, float price, float ram, float disk, float os) {
		super();
		this.idVm = idVm;
		this.price = price;
		this.ram = ram;
		this.disk = disk;
		this.os = os;
	}

	public long getIdVm() {
		return idVm;
	}

	public void setIdVm(long idVm) {
		this.idVm = idVm;
	}

	public float getPrice() {
		return price;
	}

	public void setPrice(float price) {
		this.price = price;
	}

	public float getRam() {
		return ram;
	}

	public void setRam(float ram) {
		this.ram = ram;
	}

	public float getDisk() {
		return disk;
	}

	public void setDisk(float disk) {
		this.disk = disk;
	}

	public float getOs() {
		return os;
	}

	public void setOs(float os) {
		this.os = os;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idVm ^ (idVm >>> 32));
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
		VM other = (VM) obj;
		if (idVm != other.idVm)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "VM [idVm=" + idVm + ", price=" + price + ", ram=" + ram + ", disk=" + disk + ", os=" + os + "]";
	}

}
