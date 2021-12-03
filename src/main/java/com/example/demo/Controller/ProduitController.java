package com.example.demo.Controller;

import com.example.demo.Entities.DetailProduit;
import com.example.demo.Entities.Produit;
import com.example.demo.Entities.Stock;
import com.example.demo.tn.esprit.spring.repository.ProduitRepository;
import com.example.demo.tn.esprit.spring.service.ProduitService;
import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class ProduitController {
    @Autowired
    ProduitService produitService;
    @Autowired
    ProduitRepository produitRepository;
    @RequestMapping(value = "/Produit",method= RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public List<Produit> retrieveProduit(){
    return this.produitService.retrieveAllProduits();
    }

    @RequestMapping(value = "/Produit/Add",method = RequestMethod.POST ,consumes =MediaType.APPLICATION_JSON_VALUE)
    public Produit Add(@RequestBody List<Object> objectList){
        ObjectMapper mapper=new ObjectMapper();
        Produit produit = mapper.convertValue(objectList.get(0),Produit.class);
        DetailProduit detailProduit=mapper.convertValue(objectList.get(1), DetailProduit.class);
        return check_rayon_stock(produit,detailProduit);
    }

    @RequestMapping(value = "/Stock/AddStock",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public void AddStock(@RequestBody String json) throws JSONException {
        JSONObject jsonRequest=new JSONObject(json);
        Integer id_p= (Integer) jsonRequest.get("idProduit");
        Integer id_s= (Integer) jsonRequest.get("idStock");
        this.produitService.assignProduitToStock(Long.valueOf(id_p),Long.valueOf(id_s));
    }

    @RequestMapping(value = "/Produit/Delete",method = RequestMethod.DELETE ,consumes =MediaType.APPLICATION_JSON_VALUE)
    public void Delete(@RequestBody Produit produit){
        this.produitRepository.delete(produit);
    }

    @RequestMapping(value = "/Produit/Update",method = RequestMethod.PUT ,consumes =MediaType.APPLICATION_JSON_VALUE)
    public Produit Update(@RequestBody List<Object> objectList){
        ObjectMapper mapper=new ObjectMapper();
        Produit produit = mapper.convertValue(objectList.get(0),Produit.class);
        DetailProduit detailProduit=mapper.convertValue(objectList.get(1), DetailProduit.class);
        return check_rayon_stock(produit,detailProduit);
    }

    private Produit check_rayon_stock(@RequestBody Produit produit,@RequestBody DetailProduit detailProduit) {
        if(produit.getRayons()==null && produit.getStocks()!=null)
            return this.produitService.addProduit(produit,null,produit.getStocks().getIdStock(),detailProduit);
        if(produit.getStocks()==null && produit.getRayons()!=null)
            return this.produitService.addProduit(produit,produit.getRayons().getIdRayon(),null,detailProduit);
        if(produit.getRayons()==null && produit.getStocks()==null)
            return this.produitService.addProduit(produit,null,null,detailProduit);
        else
            return this.produitService.addProduit(produit,produit.getRayons().getIdRayon(),produit.getStocks().getIdStock(),detailProduit);
    }
}
