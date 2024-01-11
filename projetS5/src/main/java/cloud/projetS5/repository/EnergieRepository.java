package cloud.projetS5.repository;
import org.springframework.data.jpa.repository.JpaRepository;

import cloud.projetS5.model.Energie;

public interface EnergieRepository extends JpaRepository<Energie, Integer> {
}

