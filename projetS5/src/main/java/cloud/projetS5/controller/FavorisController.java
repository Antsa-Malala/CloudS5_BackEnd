package cloud.projetS5.controller;

import cloud.projetS5.model.Annonce;
import cloud.projetS5.model.Favoris;
import cloud.projetS5.model.Reponse;
import cloud.projetS5.model.Utilisateur;
import cloud.projetS5.service.FavorisService;
import cloud.projetS5.service.UtilisateurService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("favoris")
public class FavorisController {
    private final FavorisService favorisService;

    private final UtilisateurService utilisateurService;


    public FavorisController(FavorisService favorisService, UtilisateurService utilisateurService) {
        this.favorisService = favorisService;
        this.utilisateurService = utilisateurService;
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Reponse<Favoris>> deleteFavoris(@PathVariable Integer id) {
        Reponse<Favoris> reponse = new Reponse<>();
        Favoris deletedFavoris = favorisService.deleteFavoris(id);

        if (deletedFavoris != null) {
            reponse.setData(deletedFavoris);
            reponse.setRemarque("FAvoris supprime");
            return ResponseEntity.status(201).body(reponse);
        } else {
            reponse.setErreur("FAvoris non creee");
            return ResponseEntity.status(400).body(reponse);
        }
    }

    @PostMapping
    public ResponseEntity<Reponse<Favoris>> addToFav(@RequestBody Favoris favoris) {
        Reponse<Favoris> reponse = new Reponse<>();
        try {
            Favoris fCreated = favorisService.addToFav(favoris);
            if (fCreated != null) {
                reponse.setData(fCreated);
                reponse.setRemarque("FAvoris creee");
                return ResponseEntity.status(201).body(reponse);
            } else {
                reponse.setErreur("FAvoris non creee");
                return ResponseEntity.status(400).body(reponse);
            }
        } catch (Exception e) {
            reponse.setErreur(e.getMessage());
            return ResponseEntity.status(500).body(reponse);
        }
    }


    @GetMapping("/favoris/{id}")
    public ResponseEntity<Reponse<List<Favoris>>> getFavorisByUser(@PathVariable String id) {
        Reponse<List<Favoris>> reponse = new Reponse<>();
        try {
            Utilisateur utilisateur = utilisateurService.getUtilisateurById(id);
            if(utilisateur != null){
                List<Favoris> result = favorisService.getFavorisByUser(utilisateur);
                if (result != null) {
                    reponse.setData(result);

                    return ResponseEntity.status(201).body(reponse);
                } else {
                    reponse.setErreur("Erreur sur la liste des favoris par utilisateur");
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
}
