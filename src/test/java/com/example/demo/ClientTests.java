package com.example.demo;

import com.example.demo.Entities.*;
import com.example.demo.tn.esprit.spring.service.ClientSerivce;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import com.example.demo.tn.esprit.spring.repository.ClientRepository;

import java.sql.Timestamp;
import java.util.Date;

@Slf4j
@SpringBootTest
class ClientTests {

@Autowired
    private ClientSerivce clientSerivce;

    @Autowired
    private ClientRepository clientRepository;

    @Test
    void AddClient() {
        Date date=new Date();
        Timestamp timestamp2 = new Timestamp(date.getTime());
        Client client_1=new Client("Selim","Ben Aich",timestamp2,"speaky@gmail.com","123456"
                ,CategorieClient.Fidele, Profession.ingénieur);
        this.clientSerivce.addClient(client_1);
    }
    @Test
    void DisplayClient() {
        /**
         * choose only one Function
         **/
               /* log.info(this.clientSerivce.retrieveClient(8L).toString());*/

        this.clientRepository.ClientNames_sql().forEach((client -> {
            log.info(client.toString());
        }));
        this.clientRepository.ClientNames_jpql().forEach(log::info);

    }
    @Test
    void DisplayClients() {
        for (Client c:
             this.clientSerivce.retrieveAllClients()) {
            log.info(c.toString());
        }
    }
    @Test
    void UpdateClient() {
        Client client_1=this.clientRepository.findById(8L).get();
        client_1.setPrenom("spiki");
        this.clientSerivce.updateClient(client_1);
    }
    @Test
    void DeleteClient() {
this.clientSerivce.deleteClient(8L);
    }

    @Test
    void ChiffreAffaire() {
       System.out.println(this.clientSerivce.getChiffreAffaireParCategorieClient(CategorieClient.Fidele,new Date("1997/01/01"),new Date("1997/09/01")));
    }

}
