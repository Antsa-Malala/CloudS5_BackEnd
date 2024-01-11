package cloud.projetS5.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cloud.projetS5.model.Energie;
import cloud.projetS5.model.Reponse;
import cloud.projetS5.service.EnergieService;


@RequestMapping("apiEnergie")
@RestController
public class EnergieController {
    private EnergieService energieService;

    public EnergieController(EnergieService energieService) {
        this.energieService = energieService;
    }

    @GetMapping("/energies")
    public Reponse<List<Energie>> getAll(){
        Reponse<List<Energie>> valiny = new Reponse<List<Energie>>();
        try {
            valiny.setData(energieService.getAll());
        } catch (Exception e) {
            valiny.setErreur(e.getMessage());
        }
        return valiny;
    }

    @GetMapping("/energie/{id}")
    public Reponse<Energie> getById(@PathVariable String id){
        
       Reponse<Energie> valiny = new Reponse<Energie>();
        try {
            Integer myId = Integer.valueOf(id);
            valiny.setData(energieService.getById(myId));
        } catch (Exception e) {
            valiny.setErreur(e.getMessage());
        }
        return valiny;
    }

    @PostMapping("/energie")
    public Reponse<Energie> insert(@RequestBody Energie energie){
       Reponse<Energie> valiny = new Reponse<Energie>();
        try {
            valiny.setData(energieService.insert(energie));
        } catch (Exception e) {
            valiny.setErreur(e.getMessage());
        }
        return valiny;
    }

    @PutMapping("/energie/{id}")
    public Reponse<Energie> update(@RequestBody Energie energie, @PathVariable String id){
       Reponse<Energie> valiny = new Reponse<Energie>();
        try {
            Integer myId = Integer.valueOf(id);
            valiny.setData(energieService.update(myId, energie));
        } catch (Exception e) {
            valiny.setErreur(e.getMessage());
        }
        return valiny;
    }

    @PutMapping("/delete/{id}")
    public Reponse<Energie> delete(@PathVariable String id){
       Reponse<Energie> valiny = new Reponse<Energie>();
        try {
            Integer myId = Integer.valueOf(id);
            valiny.setData(energieService.delete(myId));
        } catch (Exception e) {
            valiny.setErreur(e.getMessage());
        }
        return valiny;
    }
}
