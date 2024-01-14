package cloud.projetS5.controller;

import cloud.projetS5.model.Annonce;
import cloud.projetS5.model.Reponse;
import cloud.projetS5.model.Utilisateur;
import cloud.projetS5.service.AnnonceService;
import cloud.projetS5.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("annonces")
public class AnnonceController {
    private final AnnonceService annonceService;

    private  final UtilisateurService utilisateurService;

    @Autowired
    public AnnonceController(AnnonceService annonceService, UtilisateurService utilisateurService) {
        this.annonceService = annonceService;
        this.utilisateurService = utilisateurService;
    }

    @GetMapping("/utilisateur/{id}")
    public ResponseEntity<Reponse<List<Annonce>>> getAnnonceByUser(@PathVariable String id) {
        Reponse<List<Annonce>> reponse = new Reponse<>();
        try {
            Utilisateur utilisateur = utilisateurService.getUtilisateurById(id);
            if(utilisateur != null){
                List<Annonce> result = annonceService.getHistoriqueByUser(utilisateur);
                if (result != null) {
                    reponse.setData(result);

                    return ResponseEntity.status(201).body(reponse);
                } else {
                    reponse.setErreur("Erreur sur la liste des annonces par utilisateur");
                    return ResponseEntity.status(400).body(reponse);
                }
            }else  {
                reponse.setErreur("User not found");
                return ResponseEntity.status(400).body(reponse);
            }
        } catch (Exception e) {
            reponse.setErreur(e.getMessage());
            return ResponseEntity.status(500).body(reponse);
        }
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
        } catch (Exception e) {
            reponse.setErreur(e.getMessage());
            return ResponseEntity.status(500).body(reponse);
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<Reponse<Annonce>> getAnnonceById(@PathVariable String id) {
        Reponse<Annonce> reponse = new Reponse<>();
        try {
            Annonce annonce = annonceService.getAnnonceById(id);
            if (annonce != null) {
                reponse.setData(annonce);
                reponse.setRemarque("Annonce trouvee");
                return ResponseEntity.ok().body(reponse);
            } else {
                reponse.setErreur("Annonce non trouvee");
                return ResponseEntity.status(404).body(reponse);
            }
        } catch (Exception e) {
            reponse.setErreur(e.getMessage());
            return ResponseEntity.status(500).body(reponse);
        }
    }

    @PostMapping
    public ResponseEntity<Reponse<Annonce>> createAnnonce(@RequestBody Annonce annonce) {
        Reponse<Annonce> reponse = new Reponse<>();
        try {
            Annonce annonceCreated = annonceService.createAnnonce(annonce);
            if (annonceCreated != null) {
                reponse.setData(annonceCreated);
                reponse.setRemarque("Annonce creee");
                return ResponseEntity.status(201).body(reponse);
            } else {
                reponse.setErreur("Annonce non creee");
                return ResponseEntity.status(400).body(reponse);
            }
        } catch (Exception e) {
            reponse.setErreur(e.getMessage());
            return ResponseEntity.status(500).body(reponse);
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<Reponse<Annonce>> updateAnnonce(@PathVariable String id,
                                                          @Validated @RequestBody Annonce annonce) {
        Reponse<Annonce> reponse = new Reponse<>();
        try {
            Annonce annonce1 = annonceService.updateAnnonceById(id, annonce);
            if (annonce1 != null) {
                reponse.setData(annonce1);
                reponse.setRemarque("Annonce modifiee");
                return ResponseEntity.ok().body(reponse);
            } else {
                reponse.setErreur("Annonce non trouvee");
                return ResponseEntity.status(404).body(reponse);
            }
        } catch (Exception e) {
            reponse.setErreur(e.getMessage());
            return ResponseEntity.status(500).body(reponse);
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Reponse<Annonce>> deleteAnnonce(@PathVariable String id) {
        Reponse<Annonce> reponse = new Reponse<>();
        try {
            Annonce annonce = annonceService.deleteAnnonceById(id);
            if (annonce != null) {
                reponse.setData(annonce);
                reponse.setRemarque("Annonce supprimee");
                return ResponseEntity.ok().body(reponse);
            } else {
                reponse.setErreur("Annonce non trouvee");
                return ResponseEntity.status(404).body(reponse);
            }
        } catch (Exception e) {
            reponse.setErreur(e.getMessage());
            return ResponseEntity.status(500).body(reponse);
        }
    }
}
