package cloud.projetS5.service;

import java.util.List;

import org.springframework.stereotype.Service;

import cloud.projetS5.model.Marque;
import cloud.projetS5.repository.MarqueRepository;

@Service
public class MarqueService {
    private final MarqueRepository marqueRepository;

    public MarqueService(MarqueRepository marqueRepository) {
        this.marqueRepository = marqueRepository;
    }

    public List<Marque> getAllMarques() {
        return (List<Marque>) marqueRepository.findAll();
    }

    public Marque getMarqueById(Integer id) {
        return marqueRepository.findById(id).orElse(null);
    }

    public Marque createMarque(Marque marque) {
        return marqueRepository.save(marque);
    }

    public Marque updateMarqueById(Integer id, Marque marque) {
        Marque marqueToUpdate = marqueRepository.findById(id).orElse(null);
        if(marqueToUpdate != null){
            marqueToUpdate.setNomMarque(marque.getNomMarque());
            marqueRepository.save(marqueToUpdate);
            return marqueToUpdate;
        }else{
            return null;
        }
    }

    public Marque deleteMarqueById(Integer id) {
        Marque marqueToDelete = marqueRepository.findById(id).orElse(null);
        if(marqueToDelete != null){
            marqueToDelete.setEtat(10);
            marqueRepository.save(marqueToDelete);
            return marqueToDelete;
        }else{
            return null;
        }
    }
}
