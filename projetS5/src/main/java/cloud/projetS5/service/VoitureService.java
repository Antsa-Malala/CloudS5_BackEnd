package cloud.projetS5.service;

import cloud.projetS5.model.Place;
import cloud.projetS5.model.Voiture;
import cloud.projetS5.repository.*;

import java.util.Collections;
import java.util.List;
import java.util.Optional;

public class VoitureService {
    private final VoitureRepository voitureRepository;
    private final CategorieRepository categorieRepository;
    private final MarqueRepository marqueRepository;
    private final ModeleRepository modeleRepository;
    private final EnergieRepository energieRepository;
    private final BoiteRepository boiteRepository;
    private final PorteRepository porteRepository;
    private final CouleurRepository couleurRepository;

    public final PlaceRepository placeRepository;

    public VoitureService(VoitureRepository voitureRepository, CategorieRepository categorieRepository, MarqueRepository marqueRepository, ModeleRepository modeleRepository, EnergieRepository energieRepository, BoiteRepository boiteRepository, PorteRepository porteRepository, CouleurRepository couleurRepository, PlaceRepository placeRepository) {
        this.voitureRepository = voitureRepository;
        this.categorieRepository = categorieRepository;
        this.marqueRepository = marqueRepository;
        this.modeleRepository = modeleRepository;
        this.energieRepository = energieRepository;
        this.boiteRepository = boiteRepository;
        this.porteRepository = porteRepository;
        this.couleurRepository = couleurRepository;
        this.placeRepository = placeRepository;
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
            Place place = placeRepository.findByValeur(voiture.getNbplace());
            if(place == null){
                Place new_place = new Place();
                new_place.setValeur(voiture.getNbplace());
                new_place.setEtat(0);
                placeRepository.save(place);
            }
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
            voitureToUpdate.setNbplace(voiture.getNbplace());
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
