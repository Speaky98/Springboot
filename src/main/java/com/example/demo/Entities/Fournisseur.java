package com.example.demo.Entities;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
@Entity
public class Fournisseur implements Serializable {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column(name="idFournisseur")
	long idFournisseur;
	@Column(length = 64)
	String code;
	@Column(length = 64)
	String  libelle;
	@Column(length = 128)
	String  avatar;
	@Column(length = 128)
	String  localisation_fournisseur;
	@Column(length = 128,nullable = true)
	String  longitude_fournisseur;
	@Column(length = 128,nullable = true)
	String  latitude_fournisseur;

	public Fournisseur() {}

	public String getLocalisation_fournisseur() {
		return localisation_fournisseur;
	}

	public void setLocalisation_fournisseur(String localisation_fournisseur) {
		this.localisation_fournisseur = localisation_fournisseur;
	}

	public String getLongitude_fournisseur() {
		return longitude_fournisseur;
	}

	public void setLongitude_fournisseur(String longitude_fournisseur) {
		this.longitude_fournisseur = longitude_fournisseur;
	}

	public String getLatitude_fournisseur() {
		return latitude_fournisseur;
	}

	public void setLatitude_fournisseur(String latitude_fournisseur) {
		this.latitude_fournisseur = latitude_fournisseur;
	}

	public long getIdFournisseur() {
		return idFournisseur;
	}

	public void setIdFournisseur(long idFournisseur) {
		this.idFournisseur = idFournisseur;
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

	public String getAvatar() {
		return avatar;
	}

	public void setAvatar(String avatar) {
		this.avatar = avatar;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + (int) (idFournisseur ^ (idFournisseur >>> 32));
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
		Fournisseur other = (Fournisseur) obj;
		return idFournisseur == other.idFournisseur;
	}
	
}
