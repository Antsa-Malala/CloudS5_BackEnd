package org.project.clouds5_backend.service;

import org.project.clouds5_backend.model.Categorie;
import org.project.clouds5_backend.repository.CategorieRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CategorieService {
    private final CategorieRepository categorieRepository;

    public CategorieService(CategorieRepository categorieRepository) {
        this.categorieRepository = categorieRepository;
    }

    public List<Categorie> getAllCategories() {
        return categorieRepository.findAll();
    }

    public Categorie getCategorieById(Integer id) {
        return categorieRepository.findById(id).orElse(null);
    }

    public Categorie createCategorie(Categorie categorie) {
        return categorieRepository.save(categorie);
    }

    public Categorie updateCategorieById(Integer id, Categorie categorie) {
        Categorie categorieToUpdate = categorieRepository.findById(id).orElse(null);
        if(categorieToUpdate != null){
            categorieToUpdate.setNomCategorie(categorie.getNomCategorie());
            categorieRepository.save(categorieToUpdate);
            return categorieToUpdate;
        }else{
            return null;
        }
    }

    public Categorie deleteCategorieById(Integer id) {
        Categorie categorieToDelete = categorieRepository.findById(id).orElse(null);
        if(categorieToDelete != null){
            categorieToDelete.setEtat(10);
            categorieRepository.save(categorieToDelete);
            return categorieToDelete;
        }else{
            return null;
        }
    }
}
