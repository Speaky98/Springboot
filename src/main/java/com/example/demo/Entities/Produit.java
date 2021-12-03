package com.example.demo.Entities;

import com.fasterxml.jackson.annotation.*;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Objects;
import java.util.Set;

import javax.persistence.*;

@Entity
//@JsonIdentityInfo(
//		generator = ObjectIdGenerators.PropertyGenerator.class,
//		property = "idProduit")
public class Produit implements Serializable {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column(name="idProduit")
	long idProduit;
	@Column(length = 64)
    String code;  
	@Column(length = 64)
	String libelle;
	float prixUnitaire;

	@OneToMany(mappedBy="produit_d_facture",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JsonIgnore
//	@JsonBackReference
//	@JsonManagedReference
	//@OnDelete(action = OnDeleteAction.CASCADE)
	private Set<detailFacture> set_d_factures=new HashSet<detailFacture>();

	@OneToOne(mappedBy="produit",fetch = FetchType.LAZY, cascade =  CascadeType.ALL)
	@JsonIgnore
//	@JsonManagedReference
	DetailProduit detailProduit;

	@ManyToOne
//	@JsonIgnore
//	@JsonBackReference
//    @JsonManagedReference
	@JoinColumn(name="FK_RayonsP_ID")
	Rayon rayons;

	@ManyToOne
	@JsonIgnore
//	@JsonBackReference
//    @JsonManagedReference
	@JoinColumn(name="FK_StocksP_ID")
	Stock stocks;

	@ManyToMany(cascade = CascadeType.ALL)
	@JsonIgnore
	@JoinTable(name = "Produit_Founisseur",
	joinColumns={@JoinColumn(name="Produit_ID")},
	inverseJoinColumns={@JoinColumn(name ="Fournisseur_ID")})

	private Set<Fournisseur> Fournisseurs=new HashSet<Fournisseur>();
	public Produit(){}

	public DetailProduit getDetailProduit() {
		return detailProduit;
	}
	public void setDetailProduit(DetailProduit detailProduit) {
		this.detailProduit = detailProduit;
	}

	public long getIdProduit() {
		return idProduit;
	}

	public void setIdProduit(long idProduit) {
		this.idProduit = idProduit;
	}

	public String getCode() {
		return code;
	}

	public void setCode(String code) {
		this.code = code;
	}

	public String getLibelle() {
		return libelle;
	}

	public void setLibelle(String libelle) {
		this.libelle = libelle;
	}

	public Rayon getRayons() {
		return rayons;
	}

	public void setRayons(Rayon rayons) {
		this.rayons = rayons;
	}

	public Set<detailFacture> getSet_d_factures() {
		return set_d_factures;
	}

	public void setSet_d_factures(Set<detailFacture> set_d_factures) {
		this.set_d_factures = set_d_factures;
	}

	public Stock getStocks() {
		return stocks;
	}

	public void setStocks(Stock stocks) {
		this.stocks = stocks;
	}

	public float getPrixUnitaire() {
		return prixUnitaire;
	}

	public void setPrixUnitaire(float prixUnitaire) {
		this.prixUnitaire = prixUnitaire;
	}

	public Set<Fournisseur> getFournisseurs() {
		return Fournisseurs;
	}

	public void setFournisseurs(Set<Fournisseur> fournisseurs) {
		this.Fournisseurs = fournisseurs;
	}

	@Override
	public String toString() {
		return "Produit{" +
				"idProduit=" + idProduit +
				", code='" + code + '\'' +
				", libelle='" + libelle + '\'' +
				", DetailProduit=" + detailProduit +
				", rayons=" + rayons +
				", set_d_factures=" + set_d_factures +
				", stocks=" + stocks +
				", prixUnitaire=" + prixUnitaire +
				", Fournisseurs=" + Fournisseurs +
				'}';
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (!(o instanceof Produit)) return false;
		Produit produit = (Produit) o;
		return idProduit == produit.idProduit;
	}

	@Override
	public int hashCode() {
		return Objects.hash(idProduit);
	}
}
