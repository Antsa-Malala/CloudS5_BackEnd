package cloud.projetS5.service;

import java.util.List;

import cloud.projetS5.model.Categorie;
import cloud.projetS5.model.Marque;
import cloud.projetS5.repository.MarqueRepository;
import org.springframework.stereotype.Service;

import cloud.projetS5.model.Modele;
import cloud.projetS5.repository.ModeleRepository;

@Service
public class ModeleService {
    private ModeleRepository modeleRepository;

    private MarqueService marqueService;

    private CategorieService categorieService;

    public ModeleService(ModeleRepository modeleRepository, MarqueRepository marqueRepository, MarqueService marqueService, CategorieService categorieService) {
        this.modeleRepository = modeleRepository;
        this.marqueService = marqueService;
        this.categorieService = categorieService;
    }

    public List<Modele> getByCategorieMarque(Integer idCategorie, Integer idMarque){
        Categorie categorie = categorieService.getById(idCategorie);
        Marque marque = marqueService.getMarqueById(idMarque);
        if(categorie != null && marque != null){
            return modeleRepository.getByCategorieMarque(idCategorie, idMarque);
        }
        return null;
    }

    public List<Modele> getByCategorie(Integer idCategorie){
        Categorie categorie = categorieService.getById(idCategorie);
        if(categorie != null){
            return modeleRepository.findByCategorie(categorie);
        }
        return null;
    }

    public List<Modele> getByMarque(Integer idMarque){
        Marque marque = marqueService.getMarqueById(idMarque);
        if(marque != null){
            return modeleRepository.findByMarque(marque);
        }
        return null;
    }

    public List<Modele> getAll() {
        return modeleRepository.findAll();
    }

    public Modele getById(Integer id) {
        return modeleRepository.findById(id).orElse(null);
    }

    public Modele insert(Modele modele) {
        return modeleRepository.save(modele);
    }

    public Modele update(Integer id, Modele modele) {
        Modele modeleToUpdate = modeleRepository.findById(id).orElse(null);
        if(modeleToUpdate != null){
            modeleToUpdate.setNomModele(modele.getNomModele());
            modeleToUpdate.setEtat(modele.getEtat());
            modeleRepository.save(modeleToUpdate);
            return modeleToUpdate;
        }else{
            return null;
        }
    }

    public Modele delete(Integer id) {
        Modele modeleToDelete = modeleRepository.findById(id).orElse(null);
         
        if(modeleToDelete != null){
            modeleToDelete.setEtat(10); // EN FONCTION ETAT
            modeleRepository.save(modeleToDelete);
            return modeleToDelete;
        }else{
            return null;
        }
    }
}
