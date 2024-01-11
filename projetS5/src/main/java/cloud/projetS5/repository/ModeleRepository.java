package cloud.projetS5.repository;

import cloud.projetS5.model.Categorie;
import cloud.projetS5.model.Marque;
import org.springframework.data.jpa.repository.JpaRepository;

import cloud.projetS5.model.Modele;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface ModeleRepository extends JpaRepository<Modele, Integer> {
    List<Modele> findByMarque(Marque marque);

    List<Modele> findByCategorie(Categorie categorie);

    @Query("SELECT m FROM Modele m WHERE m.categorie.idCategorie = :idCategorie AND m.marque.idMarque = :idMarque")
    List<Modele> getByCategorieMarque(@Param("idCategorie") Integer idCategorie, @Param("idMarque") Integer idMarque);
}

