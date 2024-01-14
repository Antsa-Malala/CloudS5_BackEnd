package cloud.projetS5.repository;

import cloud.projetS5.model.Voiture;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface VoitureRepository extends JpaRepository<Voiture, String> {
    List<Voiture> findByEtatNot(Integer etat);
    Voiture findByIdVoitureAndEtatNot(String id, Integer etat);
}
