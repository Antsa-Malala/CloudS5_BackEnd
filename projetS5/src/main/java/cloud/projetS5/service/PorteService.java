package cloud.projetS5.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cloud.projetS5.model.Porte;
import cloud.projetS5.repository.PorteRepository;

@Service
public class PorteService {
    private final PorteRepository porteRepository;

    public PorteService(PorteRepository porteRepository) {
        this.porteRepository = porteRepository;
    }

    public List<Porte> getAll() {
        return (List<Porte>) porteRepository.findAll();
    }

    public Porte getById(Integer id) {
        return porteRepository.findById(id).orElse(null);
    }

    public Porte insert(Porte porte) {
        return porteRepository.save(porte);
    }

    public Porte update(Integer id, Porte porte) {
        Porte porteToUpdate = porteRepository.findById(id).orElse(null);
        if (porteToUpdate != null) {
            porteToUpdate.setValeur(porte.getValeur());
            porteRepository.save(porteToUpdate);
            return porteToUpdate;
        } else {
            return null;
        }
    }

    public Porte delete(Integer id) {
        Porte porteToDelete = porteRepository.findById(id).orElse(null);
        if (porteToDelete != null) {
            porteToDelete.setEtat(10);
            return porteRepository.save(porteToDelete);
        } else {
            return null;
        }
    }
}
