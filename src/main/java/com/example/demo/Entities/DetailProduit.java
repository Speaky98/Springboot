package com.example.demo.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import com.fasterxml.jackson.annotation.JsonIdentityInfo;
import com.fasterxml.jackson.annotation.JsonManagedReference;
import com.fasterxml.jackson.annotation.ObjectIdGenerators;

import java.io.Serializable;
import java.util.Date;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.EnumType;
import javax.persistence.Enumerated;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
@Entity
//@JsonIdentityInfo(
//		generator = ObjectIdGenerators.PropertyGenerator.class,
//		property = "idDetailProduit")
public class DetailProduit implements Serializable {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column(name="idDetailProduit")
	long idDetailProduit;
	Date dateCreation;
	Date dateDerniereModification;
	CategorieProduit CategorieProduit;

	@OneToOne
	@JsonBackReference
	@JoinColumn(name="FK_ProtduitD_ID")
	Produit produit;

	public DetailProduit(){};

	public Produit getProduit() {
		return produit;
	}

	public long getIdDetailProduit() {
		return idDetailProduit;
	}
	public void setIdDetailProduit(long idDetailProduit) {
		this.idDetailProduit = idDetailProduit;
	}

	public void setProduit(Produit produit) {
		this.produit = produit;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getDateCreation() {
		return dateCreation;
	}

	public void setDateCreation(Date dateCreation) {
		this.dateCreation = dateCreation;
	}

	@Temporal(TemporalType.TIMESTAMP)
	public Date getDateDerniereModification() {
		return dateDerniereModification;
	}

	public void setDateDerniereModification(Date dateDerniereModification) {
		this.dateDerniereModification = dateDerniereModification;
	}

	@Enumerated(EnumType.STRING)
	public CategorieProduit getCategorieProduit() {
		return CategorieProduit;
	}

	public void setCategorieProduit(CategorieProduit categorieProduit) {
		CategorieProduit = categorieProduit;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idDetailProduit ^ (idDetailProduit >>> 32));
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
		DetailProduit other = (DetailProduit) obj;
		if (idDetailProduit != other.idDetailProduit)
			return false;
		return true;
	}
	
}
