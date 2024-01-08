package org.project.clouds5_backend.controller;

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
    public ResponseEntity<List<Ville>> getAllVilles() {
        List<Ville> villes = villeService.getAllVilles();
        if(!villes.isEmpty()){
            return ResponseEntity.ok(villes);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Ville> getVilleById(@PathVariable Integer id) {
        Ville ville = villeService.getVilleById(id);
        if(ville != null){
            return ResponseEntity.ok(ville);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Ville> createVille(@RequestBody Ville ville) {
        try{
            villeService.createVille(ville);
            return ResponseEntity.ok(ville);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Ville> updateVilleById(@PathVariable Integer id, @RequestBody Ville ville) {
        Ville villeToUpdate = villeService.updateVilleById(id, ville);
        if(villeToUpdate != null){
            return ResponseEntity.ok(villeToUpdate);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Ville> deleteVilleById(@PathVariable Integer id) {
        Ville villeToDelete = villeService.deleteVilleById(id);
        if(villeToDelete != null){
            return ResponseEntity.ok(villeToDelete);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

}
