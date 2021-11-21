package com.example.demo.Entities;

import com.fasterxml.jackson.annotation.JsonBackReference;
import lombok.Getter;

import java.io.Serializable;
import java.util.Date;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
public class Client implements Serializable{
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	@Column(name="idClient")
	long idClient;
	@Column(length = 64)
	String nom;

	@Column(length = 64)
	String prenom;
	Date dateNaissance;
	@Column(length = 64)
	String email;
	@Column(length = 64)
	String password;
	CategorieClient CategorieClient;
	Profession profession;

	@OneToMany(mappedBy="clients",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JsonBackReference
	private Set<Facture> set_Factures=new HashSet<>();

	public Client(String nom, String prenom, Date dateNaissance, String email, String password, CategorieClient categorieClient, Profession profession) {
		this.nom = nom;
		this.prenom = prenom;
		this.dateNaissance = dateNaissance;
		this.email = email;
		this.password = password;
		this.CategorieClient = categorieClient;
		this.profession = profession;
	}

	public Client() {}

	public long getIdClient() {
		return idClient;
	}

	public void setIdClient(long idClient) {
		this.idClient = idClient;
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

	@Temporal(TemporalType.TIMESTAMP)
	public Date getDateNaissance() {
		return dateNaissance;
	}

	public void setDateNaissance(Date dateNaissance) {
		this.dateNaissance = dateNaissance;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	@Enumerated(EnumType.STRING)
	public CategorieClient getCategorieClient() {
		return CategorieClient;
	}

	public void setCategorieClient(CategorieClient categorieClient) {
		CategorieClient = categorieClient;
	}

	@Enumerated(EnumType.STRING)
	public Profession getProfession() {
		return profession;
	}

	public void setProfession(Profession profession) {
		this.profession = profession;
	}

	public Set<Facture> getSet_Factures() {
		return set_Factures;
	}
	public void setSet_Factures(Set<Facture> set_Factures) {
		this.set_Factures = set_Factures;
	}

	@Override
	public String toString() {
		return "Client{" +
				"idClient=" + idClient +
				", nom='" + nom + '\'' +
				", prenom='" + prenom + '\'' +
				", dateNaissance=" + dateNaissance +
				", email='" + email + '\'' +
				", password='" + password + '\'' +
				", CategorieClient=" + CategorieClient +
				", profession=" + profession +
				'}';
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((CategorieClient == null) ? 0 : CategorieClient.hashCode());
		result = prime * result + ((dateNaissance == null) ? 0 : dateNaissance.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result + (int) (idClient ^ (idClient >>> 32));
		result = prime * result + ((nom == null) ? 0 : nom.hashCode());
		result = prime * result + ((password == null) ? 0 : password.hashCode());
		result = prime * result + ((prenom == null) ? 0 : prenom.hashCode());
		result = prime * result + ((profession == null) ? 0 : profession.hashCode());
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
		Client other = (Client) obj;
		if (CategorieClient != other.CategorieClient)
			return false;
		if (dateNaissance == null) {
			if (other.dateNaissance != null)
				return false;
		} else if (!dateNaissance.equals(other.dateNaissance))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (idClient != other.idClient)
			return false;
		if (nom == null) {
			if (other.nom != null)
				return false;
		} else if (!nom.equals(other.nom))
			return false;
		if (password == null) {
			if (other.password != null)
				return false;
		} else if (!password.equals(other.password))
			return false;
		if (prenom == null) {
			if (other.prenom != null)
				return false;
		} else if (!prenom.equals(other.prenom))
			return false;
		if (profession != other.profession)
			return false;
		return true;
	}

}
