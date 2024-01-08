package org.project.clouds5_backend.service;

import org.project.clouds5_backend.model.Ville;
import org.project.clouds5_backend.repository.VilleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VilleService {
    private final VilleRepository villeRepository;

    public VilleService(VilleRepository villeRepository) {
        this.villeRepository = villeRepository;
    }

    public List<Ville> getAllVilles() {
        return (List<Ville>) villeRepository.findAll();
    }

    public Ville getVilleById(Integer id) {
        return villeRepository.findById(id).orElse(null);
    }

    public Ville createVille(Ville ville) {
        return villeRepository.save(ville);
    }

    public Ville updateVilleById(Integer id, Ville ville) {
        Ville villeToUpdate = villeRepository.findById(id).orElse(null);
        if(villeToUpdate != null){
            villeToUpdate.setNomVille(ville.getNomVille());
            villeRepository.save(villeToUpdate);
            return villeToUpdate;
        }else{
            return null;
        }
    }

    public Ville deleteVilleById(Integer id) {
        Ville villeToDelete = villeRepository.findById(id).orElse(null);
        if(villeToDelete != null){
            villeRepository.delete(villeToDelete);
            return villeToDelete;
        }else{
            return null;
        }
    }
}