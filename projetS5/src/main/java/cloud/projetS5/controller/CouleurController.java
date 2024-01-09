package cloud.projetS5.controller;

import cloud.projetS5.model.Couleur;
import cloud.projetS5.model.Reponse;
import cloud.projetS5.service.CouleurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("couleurs")
public class CouleurController {
    private final CouleurService couleurService;

    @Autowired
    public CouleurController(CouleurService couleurService) {
        this.couleurService = couleurService;
    }

    @GetMapping("/all")
    public Reponse<List<Couleur>> getAllCouleurs() {
        Reponse reponse = new Reponse<List<Couleur>>();
        try{
            List<Couleur> couleurs = couleurService.getAllCouleurs();
            reponse.setData(couleurs);
            // return ResponseEntity.ok(couleurs);
            return reponse;
        }catch(Exception e){
            reponse.setErreur("Not any ville\n"+e.getMessage());
            return reponse;
        }
    }

    @GetMapping("get/{id}")
    public Reponse<Couleur> getCouleurById(@PathVariable Integer id) {
        Reponse reponse = new Reponse<Couleur>();
        try{
            Couleur couleur = couleurService.getCouleurById(id);
            reponse.setData(couleur);
            // return ResponseEntity.ok(couleur);
            return reponse;
        }catch(Exception e){
            reponse.setErreur("Not any ville\n"+e.getMessage());
            return reponse;
        }
    }

    @PostMapping("/add")
    public Reponse<Couleur> createCouleur(@RequestBody Couleur couleur) {
        Reponse reponse = new Reponse<Couleur>();
        try{
            Couleur couleur_creee = couleurService.createCouleur(couleur);
            reponse.setData(couleur_creee);
            // return ResponseEntity.ok(ville);
            return reponse;
        }catch (Exception e){
            // return ResponseEntity.notFound().build();
            reponse.setErreur("Can not create this ville\n"+e.getMessage());
            return reponse;
        }
    }

    @PutMapping("update/{id}")
    public Reponse<Couleur> updateCouleurById(@PathVariable Integer id, @RequestBody Couleur couleur) {
        Reponse reponse = new Reponse<Couleur>();
        try{
            Couleur couleurToUpdate = couleurService.updateCouleurById(id, couleur);
            reponse.setData(couleurToUpdate);
            // return ResponseEntity.ok(couleurToUpdate);
            return reponse;
        }catch (Exception e){
            // return ResponseEntity.notFound().build();
            reponse.setErreur("Can not update this ville\n"+e.getMessage());
            return reponse;
        }
    }

    @PutMapping("delete/{id}")
    public Reponse<Couleur> deleteVilleById(@PathVariable Integer id) {
        Reponse reponse = new Reponse<Couleur>();
        try{
            Couleur couleurToDelete = couleurService.deleteCouleurById(id);
            reponse.setData(couleurToDelete);
            // return ResponseEntity.ok(couleurToDelete);
            return reponse;
        }catch(Exception e){
            // return ResponseEntity.notFound().build();
            reponse.setErreur("Can not delete this ville, cannot update 'etat' to '10'\n"+e.getMessage());
            return reponse;
        }
    }

}
