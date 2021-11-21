package com.example.demo.Entities;

import com.fasterxml.jackson.annotation.*;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

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
//		property = "idStock")
public class Stock implements Serializable {
	@Id
	@GeneratedValue( strategy = GenerationType.AUTO )
	@Column(name="idStock")
	long idStock;
	int qte;
	int  qteMin;
	@Column(length = 64)
	String  libelleStock;

	@OneToMany(mappedBy="stocks",fetch = FetchType.EAGER,cascade = CascadeType.ALL)
	@JsonBackReference
	//@JsonIgnore
	//@OnDelete(action = OnDeleteAction.CASCADE)
	private Set<Produit> set_s_produits=new HashSet<Produit>();

	@Override
	public String toString() {
		return "Stock{" +
				"idStock=" + idStock +
				", qte=" + qte +
				", qteMin=" + qteMin +
				", libelleStock='" + libelleStock + '\'' +
				'}';
	}


}
