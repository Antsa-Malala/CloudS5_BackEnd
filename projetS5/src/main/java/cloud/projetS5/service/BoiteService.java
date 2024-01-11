package cloud.projetS5.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cloud.projetS5.model.Boite;
import cloud.projetS5.repository.BoiteRepository;

@Service
public class BoiteService {
    private BoiteRepository boiteRepository;

    public BoiteService(BoiteRepository boiteRepository) {
        this.boiteRepository = boiteRepository;
    }

    public List<Boite> getAll() {
        return boiteRepository.findAll();
    }

    public Boite getById(Integer id) {
        return boiteRepository.findById(id).orElse(null);
    }

    public Boite insert(Boite boite) {
        return boiteRepository.save(boite);
    }

    public Boite update(Integer id, Boite boite) {
        Boite boiteToUpdate = boiteRepository.findById(id).orElse(null);
        if(boiteToUpdate != null){
            boiteToUpdate.setNomBoite(boite.getNomboite());
            boiteToUpdate.setEtat(boite.getEtat());
            boiteRepository.save(boiteToUpdate);
            return boiteToUpdate;
        }else{
            return null;
        }
    }

    public Boite delete(Integer id) {
        Boite boiteToDelete = boiteRepository.findById(id).orElse(null);
         
        if(boiteToDelete != null){
            boiteToDelete.setEtat(10); // EN FONCTION ETAT
            boiteRepository.save(boiteToDelete);
            return boiteToDelete;
        }else{
            return null;
        }
    }
}
