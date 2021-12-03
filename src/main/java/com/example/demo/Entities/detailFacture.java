package com.example.demo.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

@Entity
//@JsonIdentityInfo(
//		generator = ObjectIdGenerators.PropertyGenerator.class,
//		property = "idDetailFacture")
public class detailFacture implements Serializable {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column(name="idDetailFacture")
	long idDetailFacture;
	int qte;
	float prixTotal;
	int pourcentageRemise;
	float montantRemise;

	@ManyToOne
//	@JsonManagedReference
	@JoinColumn(name="FK_produit_d_facturesP_ID")
	Produit produit_d_facture;

	@ManyToOne
//	@JsonManagedReference
	@JoinColumn(name="FK_FacturesP_ID")
	Facture factures;

	public detailFacture() {}

	public long getIdDetailFacture() {
		return idDetailFacture;
	}

	public void setIdDetailFacture(long idDetailFacture) {
		this.idDetailFacture = idDetailFacture;
	}

	public int getQte() {
		return qte;
	}

	public void setQte(int qte) {
		this.qte = qte;
	}

	public float getPrixTotal() {
		return prixTotal;
	}

	public void setPrixTotal(float prixTotal) {
		this.prixTotal = prixTotal;
	}

	public int getPourcentageRemise() {
		return pourcentageRemise;
	}

	public void setPourcentageRemise(int pourcentageRemise) {
		this.pourcentageRemise = pourcentageRemise;
	}

	public float getMontantRemise() {
		return montantRemise;
	}

	public void setMontantRemise(float montantRemise) {
		this.montantRemise = montantRemise;
	}

	public Produit getProduit_d_facture() {
		return produit_d_facture;
	}

	public void setProduit_d_facture(Produit produit_d_facture) {
		this.produit_d_facture = produit_d_facture;
	}

	public Facture getFactures() {
		return factures;
	}

	public void setFactures(Facture factures) {
		this.factures = factures;
	}

	@Override
	public String toString() {
		return "detailFacture{" +
				"idDetailFacture=" + idDetailFacture +
				", qte=" + qte +
				", prixTotal=" + prixTotal +
				", pourcentageRemise=" + pourcentageRemise +
				", montantRemise=" + montantRemise +
				", produit_d_facture=" + produit_d_facture +
				", factures=" + factures +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof detailFacture)) return false;
		detailFacture that = (detailFacture) o;
		return idDetailFacture == that.idDetailFacture;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idDetailFacture);
	}

}
