package com.example.demo.tn.esprit.spring.repository;

import com.example.demo.Entities.Client;
import com.example.demo.Entities.Produit;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;

@Repository
public interface ProduitRepository extends CrudRepository<Produit,Long> {
//    @Query("select p from Produit p join fetch p.Rayons where p.idProduit = ?1")
//    public Produit findAccount(Long id);
@Query(value = "SELECT SUM(d.prix_total*d.qte) FROM facture f,detail_facture d " +
        "WHERE d.fk_facturesp_id=?1 and f.dat_facture>= ?2" +
        " and  f.dat_facture<=?3 and f.active=true and f.id_facture=d.fk_facturesp_id  "
        , nativeQuery = true)
float getRevenuBrutProduit(Long idProduit, Date startDate, Date endDate);
}
