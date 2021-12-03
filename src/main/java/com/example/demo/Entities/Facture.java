package com.example.demo.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonManagedReference;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Facture implements Serializable{
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column(name="idFacture")
	long idFacture;
	float montantRemise;
	float  montantFacture;
	Date datFacture;
	boolean active;

	@OneToMany(mappedBy="factures",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JsonBackReference
	private Set<detailFacture> set_detailFacture=new HashSet<>();

	@ManyToOne
//	@JsonManagedReference
	@JoinColumn(name="FK_ClentP_ID")
	Client clients;

	public Facture() {}

	public Client getClients() {
		return clients;
	}

	public void setClients(Client clients) {
		clients = clients;
	}

	public Set<detailFacture> getSet_detailFacture() {
		return set_detailFacture;
	}

	public void setSet_detailFacture(Set<detailFacture> set_detailFacture) {
		this.set_detailFacture = set_detailFacture;
	}

	public long getIdFacture() {
		return idFacture;
	}

	public void setIdFacture(long idFacture) {
		this.idFacture = idFacture;
	}

	public float getMontantRemise() {
		return montantRemise;
	}

	public void setMontantRemise(float montantRemise) {
		this.montantRemise = montantRemise;
	}

	public float getMontantFacture() {
		return montantFacture;
	}

	public void setMontantFacture(float montantFacture) {
		this.montantFacture = montantFacture;
	}

	public Date getDatFacture() {
		return datFacture;
	}

	public void setDatFacture(Date datFacture) {
		this.datFacture = datFacture;
	}
	public boolean isActive() {
		return active;
	}
	public void setActive(boolean active) {
		this.active = active;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idFacture ^ (idFacture >>> 32));
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
		Facture other = (Facture) obj;
		if (idFacture != other.idFacture)
			return false;
		return true;
	}

	@Override
	public String toString() {
		return "Facture{" +
				"idFacture=" + idFacture +
				", montantRemise=" + montantRemise +
				", montantFacture=" + montantFacture +
				", datFacture=" + datFacture +
				", active=" + active +
				", clients=" + clients +
				'}';
	}
	
}
