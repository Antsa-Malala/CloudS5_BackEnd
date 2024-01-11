package cloud.projetS5.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cloud.projetS5.model.Place;
import cloud.projetS5.model.Porte;
import cloud.projetS5.model.Reponse;
import cloud.projetS5.service.PlaceService;


@RequestMapping("apiPlace")
@RestController
public class PlaceController {
     private final PlaceService placeService;

    public PlaceController(PlaceService placeService) {
        this.placeService = placeService;
    }

    @GetMapping("/places")
    public Reponse<List<Place>> getAll() {
        Reponse<List<Place>> valiny = new Reponse<List<Place>>();
        try {
            valiny.setData(placeService.getAll());
        } catch (Exception e) {
            valiny.setErreur(e.getMessage());
        }
        return valiny;
    }

    @GetMapping("/{id}")
    public Reponse<Place> getById(@PathVariable Integer id) {
        Reponse<Place> valiny = new Reponse<Place>();
       try {
            valiny.setData(placeService.getById(id));
        } catch (Exception e) {
            valiny.setErreur(e.getMessage());
        }
        return valiny;
    }

    @PostMapping("/place")
    public Reponse<Place> insert(@RequestBody Place place) {
        Reponse<Place> valiny = new Reponse<Place>();
        try {
            valiny.setData(placeService.insert(place));
        } catch (Exception e) {
            valiny.setErreur(e.getMessage());
        }
        return valiny;
    }

    @PutMapping("/{id}")
    public Reponse<Place> update(@PathVariable Integer id, @RequestBody Place place) {
        Reponse<Place> valiny = new Reponse<Place>();
        try {
            Integer myId = Integer.valueOf(id);
            valiny.setData(placeService.update(myId, place));
        } catch (Exception e) {
            valiny.setErreur(e.getMessage());
        }
        return valiny;
    }

    @PutMapping("/delete/{id}")
    public Reponse<Place> delete(@PathVariable Integer id) {
        Reponse<Place> valiny = new Reponse<Place>();
        try {
            Integer myId = Integer.valueOf(id);
            valiny.setData(placeService.delete(myId));
        } catch (Exception e) {
            valiny.setErreur(e.getMessage());
        }
        return valiny;
    }
}
