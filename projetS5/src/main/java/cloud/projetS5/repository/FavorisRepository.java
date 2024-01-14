package cloud.projetS5.repository;

import cloud.projetS5.model.Boite;
import cloud.projetS5.model.Favoris;
import cloud.projetS5.model.Utilisateur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface FavorisRepository extends JpaRepository<Favoris, Integer> {
    List<Favoris> findByUtilisateur(Utilisateur utilisateur);


}
