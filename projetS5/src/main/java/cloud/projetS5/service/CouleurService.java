package cloud.projetS5.service;

import cloud.projetS5.model.Couleur;
import cloud.projetS5.repository.CouleurRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CouleurService {
    private final CouleurRepository couleurRepository;

    public CouleurService(CouleurRepository couleurRepository) {
        this.couleurRepository = couleurRepository;
    }

    public List<Couleur> getAllCouleurs() {
        return (List<Couleur>) couleurRepository.findAll();
    }

    public Couleur getCouleurById(Integer id) {
        return couleurRepository.findById(id).orElse(null);
    }

    public Couleur createCouleur(Couleur couleur) {
        return couleurRepository.save(couleur);
    }

    public Couleur updateCouleurById(Integer id, Couleur couleur) {
        Couleur couleurToUpdate = couleurRepository.findById(id).orElse(null);
        if(couleurToUpdate != null){
            couleurToUpdate.setNomCouleur(couleur.getNomCouleur());
            couleurRepository.save(couleurToUpdate);
            return couleurToUpdate;
        }else{
            return null;
        }
    }

    public Couleur deleteCouleurById(Integer id) {
        Couleur couleurToDelete = couleurRepository.findById(id).orElse(null);
        if(couleurToDelete != null){
            couleurToDelete.setEtat(10);
            couleurRepository.save(couleurToDelete);
            return couleurToDelete;
        }else{
            return null;
        }
    }
}
