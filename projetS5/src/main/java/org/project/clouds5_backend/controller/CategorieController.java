package org.project.clouds5_backend.controller;

import org.project.clouds5_backend.model.Categorie;
import org.project.clouds5_backend.repository.CategorieRepository;
import org.project.clouds5_backend.service.CategorieService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("categories")
public class CategorieController {
    private final CategorieService categorieService;

    @Autowired
    public CategorieController(CategorieService categorieService) {
        this.categorieService = categorieService;
    }

    @GetMapping
    public ResponseEntity<List<Categorie>> getAllCategories() {
        List<Categorie> categories = categorieService.getAllCategories();
        if(!categories.isEmpty()){
            return ResponseEntity.ok(categories);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Categorie> getCategorieById(@PathVariable Integer id) {
        Categorie categorie = categorieService.getCategorieById(id);
        if(categorie != null){
            return ResponseEntity.ok(categorie);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @PostMapping
    public ResponseEntity<Categorie> createCategorie(@RequestBody Categorie categorie) {
        try{
            categorieService.createCategorie(categorie);
            return ResponseEntity.ok(categorie);
        }catch (Exception e){
            return ResponseEntity.notFound().build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Categorie> updateCategorieById(@PathVariable Integer id, @RequestBody Categorie categorie) {
        Categorie categorieToUpdate = categorieService.updateCategorieById(id, categorie);
        if(categorieToUpdate != null){
            return ResponseEntity.ok(categorieToUpdate);
        }else{
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Categorie> deleteCategorieById(@PathVariable Integer id) {
        Categorie categorie = categorieService.deleteCategorieById(id);
        if(categorie != null){
            return ResponseEntity.ok(categorie);
        }else{
            return ResponseEntity.notFound().build();
        }
    }
}
