package cloud.projetS5.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cloud.projetS5.model.Categorie;
import cloud.projetS5.model.Reponse;
import cloud.projetS5.service.CategorieService;

@RequestMapping("apiCategorie")
@RestController
public class CategorieController {
    private CategorieService categorieService;

    public CategorieController(CategorieService categorieService) {
        this.categorieService = categorieService;
    }

    @GetMapping("/categories")
    public Reponse<List<Categorie>> getAll(){
        Reponse<List<Categorie>> valiny = new Reponse<List<Categorie>>();
        try {
            valiny.setData(categorieService.getAll());
        } catch (Exception e) {
            valiny.setErreur(e.getMessage());
        }
        return valiny;
    }

    @GetMapping("/categorie/{id}")
    public Reponse<Categorie> getById(@PathVariable String id){
        
       Reponse<Categorie> valiny = new Reponse<Categorie>();
        try {
            Integer myId = Integer.valueOf(id);
            valiny.setData(categorieService.getById(myId));
        } catch (Exception e) {
            valiny.setErreur(e.getMessage());
        }
        return valiny;
    }

    @PostMapping("/categorie")
    public Reponse<Categorie> insert(@RequestBody Categorie categorie){
       Reponse<Categorie> valiny = new Reponse<Categorie>();
        try {
            valiny.setData(categorieService.insert(categorie));
        } catch (Exception e) {
            valiny.setErreur(e.getMessage());
        }
        return valiny;
    }

    @PutMapping("/categorie/{id}")
    public Reponse<Categorie> update(@RequestBody Categorie categorie, @PathVariable String id){
       Reponse<Categorie> valiny = new Reponse<Categorie>();
        try {
            Integer myId = Integer.valueOf(id);
            valiny.setData(categorieService.update(myId, categorie));
        } catch (Exception e) {
            valiny.setErreur(e.getMessage());
        }
        return valiny;
    }

    @PutMapping("/delete/{id}")
    public Reponse<Categorie> delete(@PathVariable String id){
       Reponse<Categorie> valiny = new Reponse<Categorie>();
        try {
            Integer myId = Integer.valueOf(id);
            valiny.setData(categorieService.delete(myId));
        } catch (Exception e) {
            valiny.setErreur(e.getMessage());
        }
        return valiny;
    }
}
