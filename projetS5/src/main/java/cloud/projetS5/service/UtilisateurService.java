package cloud.projetS5.service;

import cloud.projetS5.model.Utilisateur;
import cloud.projetS5.repository.UtilisateurRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class UtilisateurService {
    private final UtilisateurRepository utilisateurRepository;

    public UtilisateurService(UtilisateurRepository utilisateurRepository) {
        this.utilisateurRepository = utilisateurRepository;
    }

    public List<Utilisateur> getAllUtilisateurs() {
        return (List<Utilisateur>) utilisateurRepository.findAll();
    }

    public Utilisateur getUtilisateurById(String id) {
        return utilisateurRepository.findById(id).orElse(null);
    }

    public Utilisateur createUtilisateur(Utilisateur utilisateur) {
        return utilisateurRepository.save(utilisateur);
    }

    public Utilisateur updateUtilisateurById(String id, Utilisateur utilisateur) {
        Utilisateur utilisateurToUpdate = utilisateurRepository.findById(id).orElse(null);
        if(utilisateurToUpdate != null){
            utilisateurToUpdate.setNom(utilisateur.getNom());
            utilisateurToUpdate.setId_ville(utilisateur.getId_ville());
            utilisateurToUpdate.setPrenom(utilisateur.getPrenom());
            utilisateurToUpdate.setAdresse(utilisateur.getAdresse());
            utilisateurToUpdate.setContact(utilisateur.getContact());
            utilisateurToUpdate.setMail(utilisateur.getMail());
            utilisateurToUpdate.setRole(utilisateur.getRole());
            utilisateurRepository.save(utilisateurToUpdate);
            return utilisateurToUpdate;
        }else{
            // throw new Exception("The table 'utilisateur' cannot be updated!");
            return null;
        }
    }

    public Utilisateur deleteUtilisateurById(String id) {
        Utilisateur utilisateurToDelete = utilisateurRepository.findById(id).orElse(null);
        if(utilisateurToDelete != null){
            utilisateurToDelete.setRole(5);
            utilisateurRepository.save(utilisateurToDelete);
            return utilisateurToDelete;
        }else{
            // throw new Exception("The 'utilisateur' table statut was not updated!");
            return null;
        }
    }
}
