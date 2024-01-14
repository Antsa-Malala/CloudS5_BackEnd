package cloud.projetS5.repository;

import cloud.projetS5.model.Couleur;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface CouleurRepository extends JpaRepository<Couleur, Integer> {
    List<Couleur> findByEtatNot(Integer etat);
    Couleur findByIdCouleurAndEtatNot(Integer id, Integer etat);
}
