package cloud.projetS5.controller;

import java.util.List;

import cloud.projetS5.model.Marque;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cloud.projetS5.model.Modele;
import cloud.projetS5.model.Reponse;
import cloud.projetS5.service.ModeleService;

@RequestMapping("apiModele")
@RestController
public class ModeleController {
     private final ModeleService modeleService;

    public ModeleController(ModeleService modeleService) {
        this.modeleService = modeleService;
    }

    @GetMapping("/modele_categorie_marque/{id_categorie}/{id_marque}")
    public Reponse<List<Modele>> getByCategorieMarque(@PathVariable Integer id_categorie, @PathVariable Integer id_marque) {
        Reponse<List<Modele>> valiny = new Reponse<List<Modele>>();
        try {
            valiny.setData(modeleService.getByCategorieMarque(id_categorie, id_marque));
        } catch (Exception e) {
            valiny.setErreur(e.getMessage());
        }
        return valiny;
    }
    @GetMapping("/modele_categorie/{id}")
    public Reponse<List<Modele>> getByCategorie(@PathVariable Integer id) {
        Reponse<List<Modele>> valiny = new Reponse<List<Modele>>();
        try {
            valiny.setData(modeleService.getByCategorie(id));
        } catch (Exception e) {
            valiny.setErreur(e.getMessage());
        }
        return valiny;
    }
    @GetMapping("/modele_marque/{id}")
    public Reponse<List<Modele>> getByMarque(@PathVariable Integer id) {
        Reponse<List<Modele>> valiny = new Reponse<List<Modele>>();
        try {
            valiny.setData(modeleService.getByMarque(id));
        } catch (Exception e) {
            valiny.setErreur(e.getMessage());
        }
        return valiny;
    }

    @GetMapping("/modeles")
    public Reponse<List<Modele>> getAll() {
        Reponse<List<Modele>> valiny = new Reponse<List<Modele>>();
        try {
            valiny.setData(modeleService.getAll());
        } catch (Exception e) {
            valiny.setErreur(e.getMessage());
        }
        return valiny;
    }

    @GetMapping("/{id}")
    public Reponse<Modele> getById(@PathVariable Integer id) {
        Reponse<Modele> valiny = new Reponse<Modele>();
       try {
            valiny.setData(modeleService.getById(id));
        } catch (Exception e) {
            valiny.setErreur(e.getMessage());
        }
        return valiny;
    }

    @PostMapping("/modele")
    public Reponse<Modele> insert(@RequestBody Modele modele) {
        Reponse<Modele> valiny = new Reponse<Modele>();
        try {
            valiny.setData(modeleService.insert(modele));
        } catch (Exception e) {
            valiny.setErreur(e.getMessage());
        }
        return valiny;
    }

    @PutMapping("/{id}")
    public Reponse<Modele> update(@PathVariable Integer id, @RequestBody Modele modele) {
        Reponse<Modele> valiny = new Reponse<Modele>();
        try {
            Integer myId = Integer.valueOf(id);
            valiny.setData(modeleService.update(myId, modele));
        } catch (Exception e) {
            valiny.setErreur(e.getMessage());
        }
        return valiny;
    }

    @PutMapping("/delete/{id}")
    public Reponse<Modele> delete(@PathVariable Integer id) {
        Reponse<Modele> valiny = new Reponse<Modele>();
        try {
            Integer myId = Integer.valueOf(id);
            valiny.setData(modeleService.delete(myId));
        } catch (Exception e) {
            valiny.setErreur(e.getMessage());
        }
        return valiny;
    }
}
