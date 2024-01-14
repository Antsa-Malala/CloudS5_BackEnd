package cloud.projetS5.repository;

import cloud.projetS5.model.Annonce;
import cloud.projetS5.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface AnnonceRepository extends JpaRepository<Annonce, String> {

    List<Annonce> findByUtilisateurOrderByDateAnnonceDesc(Utilisateur utilisateur);

    List<Annonce> findByEtatNot(Integer etat);

    Annonce findByIdAnnonceAndEtatNot(String id, Integer etat);
}
