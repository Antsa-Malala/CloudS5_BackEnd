package org.project.clouds5_backend.controller;

import org.project.clouds5_backend.model.Marque;
import org.project.clouds5_backend.model.Reponse;
import org.project.clouds5_backend.service.MarqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("marques")
public class MarqueController {
    private final MarqueService marqueService;

    @Autowired
    public MarqueController(MarqueService marqueService) {
        this.marqueService = marqueService;
    }

    @GetMapping
    public Reponse<List<Marque>> getAllMarques() {
        List<Marque> marques = marqueService.getAllMarques();
        Reponse<List<Marque>> marque = new Reponse<>();
        try{
            if(!marques.isEmpty()){
                marque.setData(marques);
                marque.setRemarque("Liste des marques");
            }else{
                marque.setErreur("Liste vide");
            }
        }catch (Exception e) {
            marque.setErreur(e.getMessage());
        }
        return marque;
    }

    @GetMapping("/{id}")
    public Reponse<Marque> getMarqueById(@PathVariable Integer id) {
        Marque marque = marqueService.getMarqueById(id);
        Reponse<Marque> reponse = new Reponse<>();
        try{
            if(marque != null){
                reponse.setData(marque);
                reponse.setRemarque("Marque trouvee");
            }else{
                reponse.setErreur("Marque non trouvee");
            }
        }catch (Exception e) {
            reponse.setErreur(e.getMessage());
        }
        return reponse;
    }

    @PostMapping
    public Reponse<Marque> createMarque(@RequestBody Marque marque) {
        Reponse<Marque> reponse = new Reponse<>();
        try{
            marqueService.createMarque(marque);
            reponse.setData(marque);
            reponse.setRemarque("Marque creee");
        }catch (Exception e){
            reponse.setErreur(e.getMessage());
        }
        return reponse;
    }

    @PutMapping("/{id}")
    public Reponse<Marque> updateMarqueById(@PathVariable Integer id, @RequestBody Marque marque) {
        Marque marqueToUpdate = marqueService.updateMarqueById(id, marque);
        Reponse<Marque> reponse = new Reponse<>();
        try{
            if(marqueToUpdate != null){
                reponse.setData(marqueToUpdate);
                reponse.setRemarque("Marque mise a jour");
            }else{
                reponse.setErreur("Marque non mise a jour");
            }
        }catch (Exception e) {
            reponse.setErreur(e.getMessage());
        }
        return reponse;
    }

    @DeleteMapping("/{id}")
    public Reponse<Marque> deleteMarqueById(@PathVariable Integer id) {
        Marque marqueToDelete = marqueService.deleteMarqueById(id);
        Reponse<Marque> reponse = new Reponse<>();
        try{
            if(marqueToDelete != null){
                reponse.setData(marqueToDelete);
                reponse.setRemarque("Marque supprimee");
            }else{
                reponse.setErreur("Marque non supprimee");
            }
        }catch (Exception e) {
            reponse.setErreur(e.getMessage());
        }
       return reponse;
    }
}
