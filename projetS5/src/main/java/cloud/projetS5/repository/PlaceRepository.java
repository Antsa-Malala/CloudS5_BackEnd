package cloud.projetS5.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import cloud.projetS5.model.Place;

public interface PlaceRepository extends JpaRepository<Place, Integer> {
    Place findByValeur(int valeur);
}
