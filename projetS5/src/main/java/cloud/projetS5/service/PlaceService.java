package cloud.projetS5.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cloud.projetS5.model.Place;
import cloud.projetS5.repository.PlaceRepository;

@Service
public class PlaceService {
    private final PlaceRepository placeRepository;

    public PlaceService(PlaceRepository placeRepository) {
        this.placeRepository = placeRepository;
    }

    public List<Place> getAll() {
        return (List<Place>) placeRepository.findAll();
    }

    public Place getById(Integer id) {
        return placeRepository.findById(id).orElse(null);
    }

    public Place insert(Place place) {
        return placeRepository.save(place);
    }

    public Place update(Integer id, Place place) {
        Place placeToUpdate = placeRepository.findById(id).orElse(null);
        if (placeToUpdate != null) {
            placeToUpdate.setValeur(place.getValeur());
            placeRepository.save(placeToUpdate);
            return placeToUpdate;
        } else {
            return null;
        }
    }

    public Place delete(Integer id) {
        Place placeToDelete = placeRepository.findById(id).orElse(null);
        if (placeToDelete != null) {
            placeToDelete.setEtat(10);
            return placeRepository.save(placeToDelete);
        } else {
            return null;
        }
    }
}
