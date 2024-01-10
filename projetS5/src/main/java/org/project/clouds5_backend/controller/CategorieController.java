package org.project.clouds5_backend.controller;

import org.project.clouds5_backend.model.Categorie;
import org.project.clouds5_backend.model.Reponse;
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
    public Reponse<List<Categorie>> getAllCategories() {
        List<Categorie> categories = categorieService.getAllCategories();
        Reponse<List<Categorie>> reponse = new Reponse<>();
        try{
            if(!categories.isEmpty()){
                reponse.setData(categories);
                reponse.setRemarque("Liste des categories");
            }else{
                reponse.setErreur("Liste vide");
            }
        }catch (Exception e) {
            reponse.setErreur(e.getMessage());
        }
        return reponse;
    }

    @GetMapping("/{id}")
    public Reponse<Categorie> getCategorieById(@PathVariable Integer id) {
        Categorie categorie = categorieService.getCategorieById(id);
        Reponse<Categorie> reponse = new Reponse<>();
        try{
        if(categorie != null){
            reponse.setData(categorie);
            reponse.setRemarque("Categorie trouvee");
        }else{
            reponse.setErreur("Categorie non trouvee");
        }
        }catch (Exception e) {
            reponse.setErreur(e.getMessage());
        }
        return reponse;
    }

    @PostMapping
    public Reponse<Categorie> createCategorie(@RequestBody Categorie categorie) {
        Reponse<Categorie> reponse = new Reponse<>();
        try{
            categorieService.createCategorie(categorie);
            reponse.setData(categorie);
            reponse.setRemarque("Categorie creee");
        }catch (Exception e){
            reponse.setErreur(e.getMessage());
        }
        return reponse;
    }

    @PutMapping("/{id}")
    public Reponse<Categorie> updateCategorieById(@PathVariable Integer id, @RequestBody Categorie categorie) {
        Categorie categorieToUpdate = categorieService.updateCategorieById(id, categorie);
        Reponse<Categorie> reponse = new Reponse<>();
        try{
            if(categorieToUpdate != null){
                reponse.setData(categorieToUpdate);
                reponse.setRemarque("Categorie mise a jour");
            }else{
                reponse.setErreur("Categorie non mise a jour");
            }
        }catch (Exception e) {
            reponse.setErreur(e.getMessage());
        }
        return reponse;
    }

    @DeleteMapping("/{id}")
    public Reponse<Categorie> deleteCategorieById(@PathVariable Integer id) {
        Categorie categorie = categorieService.deleteCategorieById(id);
        Reponse<Categorie> reponse = new Reponse<>();
        try {
            if (categorie != null) {
                reponse.setData(categorie);
                reponse.setRemarque("Categorie supprimee");
            } else {
                reponse.setErreur("Categorie non supprimee");
            }
        }catch (Exception e) {
            reponse.setErreur(e.getMessage());
        }
        return reponse;
    }
}
