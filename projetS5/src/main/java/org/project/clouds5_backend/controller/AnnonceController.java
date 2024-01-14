package org.project.clouds5_backend.controller;

import jakarta.validation.Valid;
import org.project.clouds5_backend.model.Annonce;
import org.project.clouds5_backend.model.Reponse;
import org.project.clouds5_backend.service.AnnonceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.sql.Date;
import java.util.List;

@RestController
@RequestMapping("annonces")
public class AnnonceController {
    private final AnnonceService annonceService;

    @Autowired
    public AnnonceController(AnnonceService annonceService) {
        this.annonceService = annonceService;
    }

    @GetMapping
    public ResponseEntity<Reponse<List<Annonce>>> getAllAnnonces() {
        Reponse<List<Annonce>> reponse = new Reponse<>();
        try {
            List<Annonce> annonces = annonceService.getAllAnnonces();
            if (!annonces.isEmpty()) {
                reponse.setData(annonces);
                reponse.setRemarque("Liste des annonces");
                return ResponseEntity.ok().body(reponse);
            } else {
                reponse.setErreur("Liste vide");
                return ResponseEntity.status(404).body(reponse);
            }
        }catch (Exception e) {
            reponse.setErreur(e.getMessage());
            return ResponseEntity.status(500).body(reponse);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reponse<Annonce>> getAnnonceById(@PathVariable String id) {
        Reponse<Annonce> reponse = new Reponse<>();
        try{
            Annonce annonce = annonceService.getAnnonceById(id);
            if(annonce != null){
                reponse.setData(annonce);
                reponse.setRemarque("Annonce trouvee");
                return ResponseEntity.ok().body(reponse);
            }else{
                reponse.setErreur("Annonce non trouvee");
                return ResponseEntity.status(404).body(reponse);
            }
        }catch (Exception e) {
            reponse.setErreur(e.getMessage());
            return ResponseEntity.status(500).body(reponse);
        }
    }

    @PostMapping
    public ResponseEntity<Reponse<Annonce>> createAnnonce(@RequestBody Annonce annonce) {
        Reponse<Annonce> reponse = new Reponse<>();
        try{
            Annonce annonceCreated = annonceService.createAnnonce(annonce);
            if(annonceCreated != null){
                reponse.setData(annonceCreated);
                reponse.setRemarque("Annonce creee");
                return ResponseEntity.status(201).body(reponse);
            }else{
                reponse.setErreur("Annonce non creee");
                return ResponseEntity.status(400).body(reponse);
            }
        }catch (Exception e) {
            reponse.setErreur(e.getMessage());
            return ResponseEntity.status(500).body(reponse);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reponse<Annonce>> updateAnnonce(@PathVariable String id, @Valid @RequestBody Annonce annonce) {
        Reponse<Annonce> reponse = new Reponse<>();
        try{
            Annonce annonce1 = annonceService.updateAnnonceById(id, annonce);
            if(annonce1 != null){
                reponse.setData(annonce1);
                reponse.setRemarque("Annonce modifiee");
                return ResponseEntity.ok().body(reponse);
            }else{
                reponse.setErreur("Annonce non trouvee");
                return ResponseEntity.status(404).body(reponse);
            }
        }catch (Exception e) {
            reponse.setErreur(e.getMessage());
            return ResponseEntity.status(500).body(reponse);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Reponse<Annonce>> deleteAnnonce(@PathVariable String id) {
        Reponse<Annonce> reponse = new Reponse<>();
        try{
            Annonce annonce = annonceService.deleteAnnonceById(id);
            if(annonce != null){
                reponse.setData(annonce);
                reponse.setRemarque("Annonce supprimee");
                return ResponseEntity.ok().body(reponse);
            }else{
                reponse.setErreur("Annonce non trouvee");
                return ResponseEntity.status(404).body(reponse);
            }
        }catch (Exception e) {
            reponse.setErreur(e.getMessage());
            return ResponseEntity.status(500).body(reponse);
        }
    }

    @GetMapping("/search")
    public ResponseEntity<Reponse<List<Annonce>>> searchAnnonce(
            @RequestParam(required = false) String motCle,
            @RequestParam(required = false) Date dateDebut,
            @RequestParam(required = false) Date dateFin,
            @RequestParam(required = false) Double prixMin,
            @RequestParam(required = false) Double prixMax,
            @RequestParam(required = false) Integer idCategorie,
            @RequestParam(required = false) Integer idMarque,
            @RequestParam(required = false) Integer idModel,
            @RequestParam(required = false) Integer idBoite,
            @RequestParam(required = false) Integer idEnergie,
            @RequestParam(required = false) Integer idPlace,
            @RequestParam(required = false) Integer idPorte,
            @RequestParam(required = false) Integer idCouleur,
            @RequestParam(required = false) Integer idVille,
            @RequestParam(required = false) Integer idUtilisateur,
            @RequestParam(required = false) Double kilometrageMin,
            @RequestParam(required = false) Double kilometrageMax,
            @RequestParam(required = false) Double consommationMin,
            @RequestParam(required = false) Double consommationMax
    ) {
        Reponse<List<Annonce>> reponse = new Reponse<>();
        try{
            List<Annonce> annonces = annonceService.rechercheAvancee(motCle, dateDebut, dateFin, prixMin, prixMax, idCategorie, idMarque, idModel, idBoite, idEnergie, idPlace, idPorte, idCouleur, idVille, idUtilisateur, kilometrageMin, kilometrageMax, consommationMin, consommationMax);
            if(!annonces.isEmpty()){
                reponse.setData(annonces);
                reponse.setRemarque("Annonces trouvees");
                return ResponseEntity.ok().body(reponse);
            }else{
                reponse.setErreur("Aucune annonce trouvee");
                return ResponseEntity.status(404).body(reponse);
            }
        }catch (Exception e) {
            reponse.setErreur(e.getMessage());
            return ResponseEntity.status(500).body(reponse);
        }
    }
}
