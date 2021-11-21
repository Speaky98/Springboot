package com.example.demo.tn.esprit.spring.repository;

import com.example.demo.Entities.CategorieClient;
import com.example.demo.Entities.Client;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.Date;
import java.util.List;
import java.util.Map;

@Repository
public interface ClientRepository extends CrudRepository<Client,Long> {
    @Query("SELECT nom,prenom FROM Client where dateNaissance >='1997/01/01' and  dateNaissance<= '1997/12/31'")
    List<String> ClientNames_jpql();
    @Query(value = "SELECT * FROM client WHERE date_naissance >='1997/01/01' and  date_naissance<= '1997/12/31'"
            , nativeQuery = true)
    List<Client> ClientNames_sql();
    @Query("SELECT SUM(f.montantFacture-f.montantRemise) FROM Client c,Facture f " +
            "where c.CategorieClient=?1 and f.datFacture >=?2 " +
            "and  f.datFacture<= ?3 and c.idClient=f.clients.idClient")
    public float getChiffreAffaireParCategorieClient(CategorieClient categorieClient,
                                                     Date startDate, Date endDate) ;

}
