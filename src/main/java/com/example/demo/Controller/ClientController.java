package com.example.demo.Controller;

import com.example.demo.Entities.Client;
import com.example.demo.tn.esprit.spring.service.ClientSerivce;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.xml.ws.Action;
import java.util.List;

@RestController
public class ClientController {
    @Autowired
    ClientSerivce clientSerivce;
    @RequestMapping(value ="/Client",method = RequestMethod.POST,produces="application/json", consumes="application/json")
    public void Add(@RequestBody String json) throws JSONException {
        JSONObject jsonRequest=new JSONObject(json);
        Integer id= (Integer) jsonRequest.get("id");
        this.clientSerivce.retrieveClient(Long.valueOf(id));
    }
    @RequestMapping(value ="/Clients",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Client> retrieveAllClients(){
        return this.clientSerivce.retrieveAllClients();
    }

    @RequestMapping(value ="/Client/Add",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public Client Add(@RequestBody Client client){
        return this.clientSerivce.addClient(client);
    }
    @RequestMapping(value ="/Client/Update",method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
    public Client Update(@RequestBody Client client){
        return this.clientSerivce.updateClient(client);
    }

    @RequestMapping(value ="/Clien/Delete",method = RequestMethod.DELETE,consumes = MediaType.APPLICATION_JSON_VALUE)
    public void Delete(@RequestBody Client client){
        this.clientSerivce.deleteClient(client.getIdClient());
    }
}
