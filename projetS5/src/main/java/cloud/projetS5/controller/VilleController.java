package cloud.projetS5.controller;

import cloud.projetS5.model.Ville;
import cloud.projetS5.model.Reponse;
import cloud.projetS5.service.VilleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("villes")
public class VilleController {
    private final VilleService villeService;

    @Autowired
    public VilleController(VilleService villeService) {
        this.villeService = villeService;
    }

    @GetMapping("/all")
    public Reponse<List<Ville>> getAllVilles() {
        Reponse reponse = new Reponse<List<Ville>>();
        try{
            List<Ville> villes = villeService.getAllVilles();
            reponse.setData(villes);
            // return ResponseEntity.ok(villes);
            return reponse;
        }catch(Exception e){
            reponse.setErreur("Not any ville\n"+e.getMessage());
            return reponse;
        }
    }

    @GetMapping("get/{id}")
    public Reponse<Ville> getVilleById(@PathVariable Integer id) {
        Reponse reponse = new Reponse<Ville>();
        try{
            Ville ville = villeService.getVilleById(id);
            reponse.setData(ville);
            // return ResponseEntity.ok(villes);
            return reponse;
        }catch(Exception e){
            reponse.setErreur("Not any ville\n"+e.getMessage());
            return reponse;
        }
    }

    @PostMapping("/add")
    public Reponse<Ville> createVille(@RequestBody Ville ville) {
        Reponse reponse = new Reponse<Ville>();
        try{
            Ville ville_creee = villeService.createVille(ville);
            reponse.setData(ville_creee);
            // return ResponseEntity.ok(ville);
            return reponse;
        }catch (Exception e){
            // return ResponseEntity.notFound().build();
            reponse.setErreur("Can not create this ville\n"+e.getMessage());
            return reponse;
        }
    }

    @PutMapping("update/{id}")
    public Reponse<Ville> updateVilleById(@PathVariable Integer id, @RequestBody Ville ville) {
        Reponse reponse = new Reponse<Ville>();
        try{
            Ville villeToUpdate = villeService.updateVilleById(id, ville);
            reponse.setData(villeToUpdate);
            // return ResponseEntity.ok(villeToUpdate);
            return reponse;
        }catch (Exception e){
            // return ResponseEntity.notFound().build();
            reponse.setErreur("Can not update this ville\n"+e.getMessage());
            return reponse;
        }
    }

    @PutMapping("delete/{id}")
    public Reponse<Ville> deleteVilleById(@PathVariable Integer id) {
        Reponse reponse = new Reponse<Ville>();
        try{
            Ville villeToDelete = villeService.deleteVilleById(id);
            reponse.setData(villeToDelete);
            // return ResponseEntity.ok(villeToDelete);
            return reponse;
        }catch(Exception e){
            // return ResponseEntity.notFound().build();
            reponse.setErreur("Can not delete this ville, cannot update 'etat' to '10'\n"+e.getMessage());
            return reponse;
        }
    }

}
