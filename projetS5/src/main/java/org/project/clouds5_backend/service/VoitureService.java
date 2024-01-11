package org.project.clouds5_backend.service;

import org.project.clouds5_backend.model.Voiture;
import org.project.clouds5_backend.repository.VoitureRepository;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

@Service
public class VoitureService {
    private final VoitureRepository voitureRepository;

    public VoitureService(VoitureRepository voitureRepository) {
        this.voitureRepository = voitureRepository;
    }

    public List<Voiture> getAllVoitures() {
        List<Voiture> voitures = voitureRepository.findByEtatNot(10);
        if(voitures.isEmpty()) {
            return Collections.emptyList();
        }else{
            return voitures;
        }
    }

    public Voiture getVoitureById(String id) {
        Voiture voiture = voitureRepository.findByIdVoitureAndEtatNot(id, 10);
        if(voiture == null) {
            return null;
        }else{
            return voiture;
        }
    }

    public Voiture createVoiture(Voiture voiture) {
        try{
            return voitureRepository.save(voiture);
        }catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public Voiture updateVoitureById(String id, Voiture voiture) {
        Optional<Voiture> optionalVoiture = Optional.ofNullable(voitureRepository.findByIdVoitureAndEtatNot(id, 10));
        if(optionalVoiture.isPresent()){
            Voiture voitureToUpdate = optionalVoiture.get();
            voitureToUpdate.setCategorie(voiture.getCategorie());
            voitureToUpdate.setMarque(voiture.getMarque());
            voitureToUpdate.setModele(voiture.getModele());
            voitureToUpdate.setEnergie(voiture.getEnergie());
            voitureToUpdate.setBoite(voiture.getBoite());
            voitureToUpdate.setConsommation(voiture.getConsommation());
            voitureToUpdate.setPlace(voiture.getPlace());
            voitureToUpdate.setPorte(voiture.getPorte());
            voitureToUpdate.setKilometrage(voiture.getKilometrage());
            voitureToUpdate.setCouleur(voiture.getCouleur());
            voitureRepository.save(voitureToUpdate);
            return voitureToUpdate;
        }else{
            throw new RuntimeException("Voiture non trouvee");
        }
    }

    public Voiture deleteVoitureById(String id) {
        Optional<Voiture> optionalVoiture = Optional.ofNullable(voitureRepository.findByIdVoitureAndEtatNot(id, 10));
        if(optionalVoiture.isPresent()){
            Voiture voitureToDelete = optionalVoiture.get();
            voitureToDelete.setEtat(10);
            voitureRepository.save(voitureToDelete);
            return voitureToDelete;
        }else{
            throw new RuntimeException("Voiture non trouvee");
        }
    }
}
