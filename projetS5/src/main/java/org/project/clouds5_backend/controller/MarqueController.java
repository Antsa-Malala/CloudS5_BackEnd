package org.project.clouds5_backend.controller;

import org.project.clouds5_backend.model.Marque;
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
    public ResponseEntity<List<Marque>> getAllMarques() {
        List<Marque> marques = marqueService.getAllMarques();
        if(!marques.isEmpty()){
            return ResponseEntity.ok(marques);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Marque> getMarqueById(@PathVariable Integer id) {
        Marque marque = marqueService.getMarqueById(id);
        if(marque != null){
            return ResponseEntity.ok(marque);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Marque> createMarque(@RequestBody Marque marque) {
        try{
            marqueService.createMarque(marque);
            return ResponseEntity.ok(marque);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Marque> updateMarqueById(@PathVariable Integer id, @RequestBody Marque marque) {
        Marque marqueToUpdate = marqueService.updateMarqueById(id, marque);
        if(marqueToUpdate != null){
            return ResponseEntity.ok(marqueToUpdate);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Marque> deleteMarqueById(@PathVariable Integer id) {
        Marque marqueToDelete = marqueService.deleteMarqueById(id);
        if(marqueToDelete != null){
            return ResponseEntity.ok(marqueToDelete);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
