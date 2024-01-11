package cloud.projetS5.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cloud.projetS5.model.Energie;
import cloud.projetS5.repository.EnergieRepository;

@Service
public class EnergieService {
     private EnergieRepository energieRepository;

    public EnergieService(EnergieRepository energieRepository) {
        this.energieRepository = energieRepository;
    }

    public List<Energie> getAll() {
        return energieRepository.findAll();
    }

    public Energie getById(Integer id) {
        return energieRepository.findById(id).orElse(null);
    }

    public Energie insert(Energie energie) {
        return energieRepository.save(energie);
    }

    public Energie update(Integer id, Energie energie) {
        Energie energieToUpdate = energieRepository.findById(id).orElse(null);
        if(energieToUpdate != null){
            energieToUpdate.setNomEnergie(energie.getNomEnergie());
            energieToUpdate.setEtat(energie.getEtat());
            energieRepository.save(energieToUpdate);
            return energieToUpdate;
        }else{
            return null;
        }
    }

    public Energie delete(Integer id) {
        Energie energieToDelete = energieRepository.findById(id).orElse(null);
        if(energieToDelete != null){
            energieToDelete.setEtat(10); // EN FONCTION ETAT
            energieRepository.save(energieToDelete);
            return energieToDelete;
        }else{
            return null;
        }
    }
}
