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
@NamedQuery(name = "server", query = "select OBJECT(b) from Server b")
public class Server implements Serializable {
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private long idServer;
	private float ram;
	private float disk;
	private String hypervisor;
	
	@OneToMany(mappedBy="server",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	private Collection <VM> vm;
	public Server() {
		super();
		// TODO Auto-generated constructor stub
	}

	public Server(long idServer, float ram, float disk, String hypervisor) {
		super();
		this.idServer = idServer;
		this.ram = ram;
		this.disk = disk;
		this.hypervisor = hypervisor;
	}

	public long getIdServer() {
		return idServer;
	}

	public void setIdServer(long idServer) {
		this.idServer = idServer;
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

	public String getHypervisor() {
		return hypervisor;
	}

	public void setHypervisor(String hypervisor) {
		this.hypervisor = hypervisor;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idServer ^ (idServer >>> 32));
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
		Server other = (Server) obj;
		if (idServer != other.idServer)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Server [idServer=" + idServer + ", ram=" + ram + ", disk=" + disk + ", hypervisor=" + hypervisor + "]";
	}
}
