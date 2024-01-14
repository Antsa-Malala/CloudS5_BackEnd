package cloud.projetS5.service;

import cloud.projetS5.model.Annonce;
import cloud.projetS5.model.Favoris;
import cloud.projetS5.model.Utilisateur;
import cloud.projetS5.repository.FavorisRepository;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class FavorisService {
    private FavorisRepository favorisRepository;

    public FavorisService(FavorisRepository favorisRepository) {
        this.favorisRepository = favorisRepository;
    }

    public Favoris deleteFavoris(Integer id){
        Optional<Favoris> optionalFavoris = favorisRepository.findById(id);
        if (optionalFavoris.isPresent()) {
            Favoris favoris = optionalFavoris.get();
            favorisRepository.delete(favoris);
            return favoris;
        }
        return null;
    }

    public Favoris addToFav(Favoris favoris){
        try {
            return favorisRepository.save(favoris);
        } catch (Exception e) {
            throw new RuntimeException(e.getMessage());
        }
    }

    public List<Favoris> getFavorisByUser(Utilisateur utilisateur){
        return favorisRepository.findByUtilisateur(utilisateur);
    }
}
