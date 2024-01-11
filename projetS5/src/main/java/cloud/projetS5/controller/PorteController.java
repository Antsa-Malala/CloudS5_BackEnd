package cloud.projetS5.controller;

import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cloud.projetS5.model.Porte;
import cloud.projetS5.model.Reponse;
import cloud.projetS5.service.PorteService;

@RequestMapping("apiPorte")
@RestController
public class PorteController {
     private final PorteService porteService;

    public PorteController(PorteService porteService) {
        this.porteService = porteService;
    }

    @GetMapping("/portes")
    public Reponse<List<Porte>> getAll() {
        Reponse<List<Porte>> valiny = new Reponse<List<Porte>>();
        try {
            valiny.setData(porteService.getAll());
        } catch (Exception e) {
            valiny.setErreur(e.getMessage());
        }
        return valiny;
    }

    @GetMapping("/{id}")
    public Reponse<Porte> getById(@PathVariable Integer id) {
        Reponse<Porte> valiny = new Reponse<Porte>();
       try {
            valiny.setData(porteService.getById(id));
        } catch (Exception e) {
            valiny.setErreur(e.getMessage());
        }
        return valiny;
    }

    @PostMapping("/porte")
    public Reponse<Porte> insert(@RequestBody Porte porte) {
        Reponse<Porte> valiny = new Reponse<Porte>();
        try {
            valiny.setData(porteService.insert(porte));
        } catch (Exception e) {
            valiny.setErreur(e.getMessage());
        }
        return valiny;
    }

    @PutMapping("/{id}")
    public Reponse<Porte> update(@PathVariable Integer id, @RequestBody Porte porte) {
        Reponse<Porte> valiny = new Reponse<Porte>();
        try {
            Integer myId = Integer.valueOf(id);
            valiny.setData(porteService.update(myId, porte));
        } catch (Exception e) {
            valiny.setErreur(e.getMessage());
        }
        return valiny;
    }

    @PutMapping("/delete/{id}")
    public Reponse<Porte> delete(@PathVariable Integer id) {
        Reponse<Porte> valiny = new Reponse<Porte>();
        try {
            Integer myId = Integer.valueOf(id);
            valiny.setData(porteService.delete(myId));
        } catch (Exception e) {
            valiny.setErreur(e.getMessage());
        }
        return valiny;
    }
}
