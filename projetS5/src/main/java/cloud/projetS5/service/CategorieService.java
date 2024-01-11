package cloud.projetS5.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cloud.projetS5.model.Categorie;
import cloud.projetS5.repository.CategorieRepository;

@Service
public class CategorieService {
    private CategorieRepository categorieRepository;

    public CategorieService(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }

    public List<Categorie> getAll() {
        return categorieRepository.findAll();
    }

    public Categorie getById(Integer id) {
        return categorieRepository.findById(id).orElse(null);
    }

    public Categorie insert(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    public Categorie update(Integer id, Categorie categorie) {
        Categorie categorieToUpdate = categorieRepository.findById(id).orElse(null);
        if(categorieToUpdate != null){
            categorieToUpdate.setNomCategorie(categorie.getNomCategorie());
            categorieToUpdate.setEtat(categorie.getEtat());
            categorieRepository.save(categorieToUpdate);
            return categorieToUpdate;
        }else{
            return null;
        }
    }

    public Categorie delete(Integer id) {
        Categorie categorieToDelete = categorieRepository.findById(id).orElse(null);
         
        if(categorieToDelete != null){
            categorieToDelete.setEtat(10); // EN FONCTION ETAT
            categorieRepository.save(categorieToDelete);
            return categorieToDelete;
        }else{
            return null;
        }
    }
}
