package cloud.projetS5.controller;

import cloud.projetS5.model.Utilisateur;
import cloud.projetS5.model.Reponse;
import cloud.projetS5.service.UtilisateurService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("utilisateurs")
public class UtilisateurController {
    private final UtilisateurService utilisateurService;

    @Autowired
    public UtilisateurController(UtilisateurService utilisateurService) {
        this.utilisateurService = utilisateurService;
    }

    @GetMapping("/all")
    public Reponse<List<Utilisateur>> getAllUtilisateurs() {
        Reponse reponse = new Reponse<List<Utilisateur>>();
        try{
            List<Utilisateur> utilisateur = utilisateurService.getAllUtilisateurs();
            reponse.setData(utilisateur);
            // return ResponseEntity.ok(Utilisateurs);
            return reponse;
        }catch(Exception e){
            reponse.setErreur("Not any 'utilisateur'\n"+e.getMessage());
            return reponse;
        }
    }

    @GetMapping("get/{id}")
    public Reponse<Utilisateur> getUtilisateurById(@PathVariable String id) {
        Reponse reponse = new Reponse<Utilisateur>();
        try{
            Utilisateur utilisateur = utilisateurService.getUtilisateurById(id);
            reponse.setData(utilisateur);
            // return ResponseEntity.ok(Utilisateur);
            return reponse;
        }catch(Exception e){
            reponse.setErreur("Not any 'utilisateur'\n"+e.getMessage());
            return reponse;
        }
    }

    @PostMapping("/add")
    public Reponse<Utilisateur> createUtilisateur(@RequestBody Utilisateur utilisateur) {
        Reponse reponse = new Reponse<Utilisateur>();
        try{
            Utilisateur utilisateur_creee = utilisateurService.createUtilisateur(utilisateur);
            reponse.setData(utilisateur_creee);
            // return ResponseEntity.ok(ville);
            return reponse;
        }catch (Exception e){
            // return ResponseEntity.notFound().build();
            reponse.setErreur("Can not create this 'utilisateur'\n"+e.getMessage());
            return reponse;
        }
    }

    @PutMapping("update/{id}")
    public Reponse<Utilisateur> updateUtilisateurById(@PathVariable String id, @RequestBody Utilisateur utilisateur) {
        Reponse reponse = new Reponse<Utilisateur>();
        try{
            Utilisateur utilisateurToUpdate = utilisateurService.updateUtilisateurById(id, utilisateur);
            reponse.setData(utilisateurToUpdate);
            // return ResponseEntity.ok(utilisateurToUpdate);
            return reponse;
        }catch (Exception e){
            // return ResponseEntity.notFound().build();
            reponse.setErreur("Can not update this 'utilisateur'\n"+e.getMessage());
            return reponse;
        }
    }

    @PutMapping("delete/{id}")
    public Reponse<Utilisateur> deleteUtilisateurById(@PathVariable String id) {
        Reponse reponse = new Reponse<Utilisateur>();
        try{
            Utilisateur utilisateurToDelete = utilisateurService.deleteUtilisateurById(id);
            reponse.setData(utilisateurToDelete);
            // return ResponseEntity.ok(utilisateurToDelete);
            return reponse;
        }catch(Exception e){
            // return ResponseEntity.notFound().build();
            reponse.setErreur("Can not delete this 'utilisateur', cannot update 'statut' to supprissed\n"+e.getMessage());
            return reponse;
        }
    }

}
