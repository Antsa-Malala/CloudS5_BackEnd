package cloud.projetS5.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cloud.projetS5.model.Boite;
import cloud.projetS5.model.Reponse;
import cloud.projetS5.service.BoiteService;

@RequestMapping("apiBoite")
@RestController
public class BoiteController {
    private BoiteService boiteService;

    public BoiteController(BoiteService boiteService) {
        this.boiteService = boiteService;
    }

    @GetMapping("/boites")
    public Reponse<List<Boite>> getAll(){
        Reponse<List<Boite>> valiny = new Reponse<List<Boite>>();
        try {
            valiny.setData(boiteService.getAll());
        } catch (Exception e) {
            valiny.setErreur(e.getMessage());
        }
        return valiny;
    }

    @GetMapping("/boite/{id}")
    public Reponse<Boite> getById(@PathVariable String id){
        
       Reponse<Boite> valiny = new Reponse<Boite>();
        try {
            Integer myId = Integer.valueOf(id);
            valiny.setData(boiteService.getById(myId));
        } catch (Exception e) {
            valiny.setErreur(e.getMessage());
        }
        return valiny;
    }

    @PostMapping("/boite")
    public Reponse<Boite> insert(@RequestBody Boite boite){
       Reponse<Boite> valiny = new Reponse<Boite>();
        try {
            valiny.setData(boiteService.insert(boite));
        } catch (Exception e) {
            valiny.setErreur(e.getMessage());
        }
        return valiny;
    }

    @PutMapping("/boite/{id}")
    public Reponse<Boite> update(@RequestBody Boite boite, @PathVariable String id){
       Reponse<Boite> valiny = new Reponse<Boite>();
        try {
            Integer myId = Integer.valueOf(id);
            valiny.setData(boiteService.update(myId, boite));
        } catch (Exception e) {
            valiny.setErreur(e.getMessage());
        }
        return valiny;
    }

    @PutMapping("/delete/{id}")
    public Reponse<Boite> delete(@PathVariable String id){
       Reponse<Boite> valiny = new Reponse<Boite>();
        try {
            Integer myId = Integer.valueOf(id);
            valiny.setData(boiteService.delete(myId));
        } catch (Exception e) {
            valiny.setErreur(e.getMessage());
        }
        return valiny;
    }
}
