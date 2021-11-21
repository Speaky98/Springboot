package com.example.demo;

import com.example.demo.Entities.Client;
import com.example.demo.Entities.Produit;
import com.example.demo.Entities.Stock;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import com.example.demo.tn.esprit.spring.repository.ClientRepository;
import org.springframework.scheduling.annotation.EnableScheduling;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

import java.util.Optional;

@EnableScheduling
@EnableSwagger2
@SpringBootApplication
//@EntityScan(basePackages = {"Entities"})
//@EnableJpaRepositories(basePackages = {"com.example.demo.tn.esprit.spring.repository"})
public class DemoApplication{

    public static void main(String[] args) {
        SpringApplication.run(DemoApplication.class, args);
    }


//    @Override
//    public void run(String... args) throws Exception {
//        ClientRepository clientRepository = new ClientRepository() {
//            @Override
//            public <S extends Stock> S save(S entity) {
//                return null;
//            }
//
//            @Override
//            public <S extends Stock> Iterable<S> saveAll(Iterable<S> entities) {
//                return null;
//            }
//
//            @Override
//            public Optional<Stock> findById(Long aLong) {
//                return Optional.empty();
//            }
//
//            @Override
//            public boolean existsById(Long aLong) {
//                return false;
//            }
//
//            @Override
//            public Iterable<Stock> findAll() {
//                return null;
//            }
//
//            @Override
//            public Iterable<Stock> findAllById(Iterable<Long> longs) {
//                return null;
//            }
//
//            @Override
//            public long count() {
//                return 0;
//            }
//
//            @Override
//            public void deleteById(Long aLong) {
//
//            }
//
//            @Override
//            public void delete(Stock entity) {
//
//            }
//
//            @Override
//            public void deleteAllById(Iterable<? extends Long> longs) {
//
//            }
//
//            @Override
//            public void deleteAll(Iterable<? extends Stock> entities) {
//
//            }
//
//            @Override
//            public void deleteAll() {
//
//            }
//        };
//        Produit produit_1=new Produit();
//        Stock stock_1=new Stock();
//        stock_1.setIdStock(1);stock_1.setLibelleStock("Informatique");
//        stock_1.setQte(40);
//        stock_1.setQteMin(10);
//        stock_1.setSet_s_produits(produit_1.getStocks().getSet_s_produits());
//        clientRepository.save(stock_1);
//    }
}
