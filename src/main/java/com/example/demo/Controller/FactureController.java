package com.example.demo.Controller;

import com.example.demo.Entities.Facture;
import com.example.demo.tn.esprit.spring.service.FactureService;
import io.swagger.models.auth.In;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import javax.websocket.server.PathParam;
import java.util.List;

@RestController
public class FactureController {
    @Autowired
    FactureService factureService;

    @RequestMapping(value = "/Facture/{id}",method = RequestMethod.GET,produces="application/json")
    public Facture retrieveFacture(@PathVariable Integer id) throws JSONException {
        /*JSONObject jsonRequest=new JSONObject(json);
        Integer id= (Integer) jsonRequest.get("id");*/
        return this.factureService.retrieveFacture((long) id);
    }

    @RequestMapping(value = "/Factures",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Facture> retrieveAllFactures(){
        return this.factureService.retrieveAllFactures();

    }

    @RequestMapping(value = "/Facture/Cancel",method = RequestMethod.POST,produces="application/json",
            consumes="application/json")
    public Facture Cancel(@RequestBody String json) throws JSONException {
        JSONObject jsonRequest=new JSONObject(json);
        Integer id= (Integer) jsonRequest.get("id");
        return this.factureService.cancelFacture(Long.valueOf(id));

    }
}
