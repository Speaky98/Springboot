package com.example.demo.Entities;

import com.fasterxml.jackson.annotation.*;
import com.sun.istack.NotNull;
import lombok.*;
import org.hibernate.annotations.OnDelete;
import org.hibernate.annotations.OnDeleteAction;

import java.io.Serializable;
import java.util.HashSet;
import java.util.Set;

import javax.persistence.*;

@Entity
@Getter
@Setter
@NoArgsConstructor
//@JsonIdentityInfo(
//		generator = ObjectIdGenerators.PropertyGenerator.class,
//		property = "idRayon")
public class Rayon implements Serializable {
	@Id
	@GeneratedValue( strategy = GenerationType.IDENTITY )
	@Column(name="idRayon")
	@NonNull
	long idRayon;
	@Column(length = 64)
	@NonNull
	String code;
	@Column(length = 64)
	@NonNull
	String  libelle;

	@OneToMany(mappedBy="rayons",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JsonBackReference
	//@JsonIgnore
	//@OnDelete(action = OnDeleteAction.CASCADE)
	private Set<Produit> set_r_produits=new HashSet<Produit>();

	public Set<Produit> getSet_r_produits() {
		return set_r_produits;
	}

	public void setSet_r_produits(Set<Produit> set_r_produits) {
		this.set_r_produits = set_r_produits;
	}

	@Override
	public String toString() {
		return "Rayon{" +
				"idRayon=" + idRayon +
				", code='" + code + '\'' +
				", libelle='" + libelle + '\'' +
				'}';
	}
}
