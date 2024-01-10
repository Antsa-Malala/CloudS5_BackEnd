package org.project.clouds5_backend.controller;

import org.project.clouds5_backend.model.Reponse;
import org.project.clouds5_backend.model.Ville;
import org.project.clouds5_backend.service.VilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("villes")
public class VilleController {
    private final VilleService villeService;

    @Autowired
    public VilleController(VilleService villeService) {
        this.villeService = villeService;
    }

    @GetMapping
    public Reponse<List<Ville>> getAllVilles() {
        List<Ville> villes = villeService.getAllVilles();
        Reponse<List<Ville>> reponse = new Reponse<>();
        try{
            if(!villes.isEmpty()){
                reponse.setData(villes);
                reponse.setRemarque("Liste des villes");
            }else{
                reponse.setErreur("Liste vide");
            }
        }catch (Exception e) {
            reponse.setErreur(e.getMessage());
        }
       return reponse;
    }

    @GetMapping("/{id}")
    public Reponse<Ville> getVilleById(@PathVariable Integer id) {
        Ville ville = villeService.getVilleById(id);
        Reponse<Ville> reponse = new Reponse<>();
        try{
            if(ville != null){
                reponse.setData(ville);
                reponse.setRemarque("Ville trouvee");
            }else{
                reponse.setErreur("Ville non trouvee");
            }
        }catch (Exception e) {
            reponse.setErreur(e.getMessage());
        }
        return reponse;
    }

    @PostMapping
    public Reponse<Ville> createVille(@RequestBody Ville ville) {
        Reponse<Ville> reponse = new Reponse<>();
        try{
            villeService.createVille(ville);
            reponse.setData(ville);
            reponse.setRemarque("Ville creee");
        }catch (Exception e){
            reponse.setErreur(e.getMessage());
        }
        return reponse;
    }

    @PutMapping("/{id}")
    public Reponse<Ville> updateVilleById(@PathVariable Integer id, @RequestBody Ville ville) {
        Ville villeToUpdate = villeService.updateVilleById(id, ville);
        Reponse<Ville> reponse = new Reponse<>();
        try{
            if(villeToUpdate != null){
                reponse.setData(villeToUpdate);
                reponse.setRemarque("Ville mise a jour");
            }else{
                reponse.setErreur("Ville non mise a jour");
            }
        }catch (Exception e) {
            reponse.setErreur(e.getMessage());
        }
        return reponse;
    }

    @DeleteMapping("/{id}")
    public Reponse<Ville> deleteVilleById(@PathVariable Integer id) {
        Ville villeToDelete = villeService.deleteVilleById(id);
        Reponse<Ville> reponse = new Reponse<>();
        try{
            if(villeToDelete != null){
                reponse.setData(villeToDelete);
                reponse.setRemarque("Ville supprimee");
            }else{
                reponse.setErreur("Ville non supprimee");
            }
        }catch (Exception e) {
            reponse.setErreur(e.getMessage());
        }
         return reponse;
    }

}
