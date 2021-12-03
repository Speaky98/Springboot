package com.example.demo.Controller;

import com.example.demo.Entities.Fournisseur;
import com.example.demo.tn.esprit.spring.repository.FournisseurRepository;
import com.example.demo.tn.esprit.spring.service.FournisseurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@RestController
public class FournisseurController {
    @Autowired
    FournisseurService fournisseurService;
    @Autowired
    FournisseurRepository fournisseurRepository;

    @RequestMapping(value = "/Fournisseurs",method= RequestMethod.GET, produces= MediaType.APPLICATION_JSON_VALUE)
    public List<Fournisseur> retrieveAllFournisseurs(){
        return this.fournisseurService.retrieveAllFournisseurs();
    }

    @RequestMapping(value ="/Fournisseur/Delete",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public void Delete(@RequestBody Fournisseur fournisseur){
        this.fournisseurService.deleteFournisseur(fournisseur.getIdFournisseur());
        if(this.fournisseurService.retrieveAllFournisseurs().size()!=0) {
            long max = this.fournisseurService.retrieveAllFournisseurs().stream().mapToLong(Fournisseur::getIdFournisseur).max().getAsLong();
            max += 1;
            this.fournisseurRepository.fix_auto_increment((int) max);
        }
    }

    @RequestMapping(value = "/Fournisseur/Add",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public Fournisseur Add(@RequestBody Fournisseur fournisseur){
        return this.fournisseurService.addFournisseur(fournisseur);

    }

    @RequestMapping(value = "/Fournisseur/Update",method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
    public Fournisseur Update(@RequestBody Fournisseur fournisseur){
        return this.fournisseurService.updateFournisseur(fournisseur);

    }

}
