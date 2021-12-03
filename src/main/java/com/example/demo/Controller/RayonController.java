package com.example.demo.Controller;

import com.example.demo.Entities.Fournisseur;
import com.example.demo.Entities.Rayon;
import com.example.demo.tn.esprit.spring.repository.RayonRepository;
import com.example.demo.tn.esprit.spring.service.RayonService;
import lombok.extern.slf4j.Slf4j;
import org.json.JSONException;
import org.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@CrossOrigin
@Slf4j
@RestController
public class RayonController {
    @Autowired
    RayonService rayonService;
    @Autowired
    RayonRepository rayonRepository;

    @RequestMapping(value = "/Rayon",method = RequestMethod.POST,produces="application/json", consumes="application/json")
    public Rayon retrieveRayon(@RequestBody String json) throws JSONException {
        JSONObject jsonRequest=new JSONObject(json);
        Integer id= (Integer) jsonRequest.get("id");
        return this.rayonService.retrieveRayon(Long.valueOf(id));
    }

    @RequestMapping(value = "/Rayons",method = RequestMethod.GET,produces = MediaType.APPLICATION_JSON_VALUE)
    public List<Rayon> retrieveAllRayons(){
        return this.rayonService.retrieveAllRayons();

    }

    @RequestMapping(value = "/Rayon/Add",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public Rayon Add(@RequestBody Rayon rayon){
      return this.rayonService.addRayon(rayon);

    }
    @RequestMapping(value = "/Rayon/Update",method = RequestMethod.PUT,consumes = MediaType.APPLICATION_JSON_VALUE)
    public Rayon Update(@RequestBody Rayon rayon){
        return this.rayonService.updateRayon(rayon);

    }

    @RequestMapping(value = "/Rayon/Delete",method = RequestMethod.POST,consumes = MediaType.APPLICATION_JSON_VALUE)
    public void Delete(@RequestBody Rayon rayon){
        this.rayonService.deleteRayon(rayon.getIdRayon());
        if(this.rayonService.retrieveAllRayons().size()!=0) {
            long max = this.rayonService.retrieveAllRayons().stream().mapToLong(Rayon::getIdRayon).max().getAsLong();
            max += 1;
            this.rayonRepository.fix_auto_increment((int) max);
        }
    }


}
