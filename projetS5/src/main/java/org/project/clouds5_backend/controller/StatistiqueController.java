package org.project.clouds5_backend.controller;

import org.project.clouds5_backend.model.Reponse;
import org.project.clouds5_backend.model.Statistique;
import org.project.clouds5_backend.service.StatistiqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("statistiques")
public class StatistiqueController {
    private final StatistiqueService statistiqueService;

    @Autowired
    public StatistiqueController(StatistiqueService statistiqueService) {
        this.statistiqueService = statistiqueService;
    }

    @GetMapping("/nbUtilisateurs")
    public Reponse<Statistique> getNbUtilisateurs() {
        Statistique statistique = statistiqueService.getNbUtilisateurs();
        Reponse<Statistique> reponse = new Reponse<>();
        try{
            reponse.setData(statistique);
            reponse.setRemarque("Nombre d'utilisateurs");
        }catch (Exception e) {
            reponse.setErreur(e.getMessage());
        }
        return reponse;
    }

    @GetMapping("/venduByPrix")
    public Reponse<Statistique> getVenduByPrix(@RequestParam("prix1") double prix1,@RequestParam("prix2") double prix2) {
        Statistique statistique = statistiqueService.getVenduByPrix(prix1, prix2);
        Reponse<Statistique> reponse = new Reponse<>();
        try{
            reponse.setData(statistique);
            reponse.setRemarque("Nombre de produits vendus entre " + prix1 + " et " + prix2);
        }catch (Exception e) {
            reponse.setErreur(e.getMessage());
        }
        return reponse;
    }

    @GetMapping("/annonceByMarque")
    public Reponse<Statistique> getAnnonceByMarque(@RequestParam("marque") String marque) {
        Statistique statistique = statistiqueService.getAnnonceByMarque(marque);
        Reponse<Statistique> reponse = new Reponse<>();
        try{
            if(statistique != null) {
                reponse.setData(statistique);
                reponse.setRemarque("Nombre d'annonce de la marque " + marque);
            }else{
                reponse.setErreur("Marque non trouvee");
            }
        }catch (Exception e) {
            reponse.setErreur(e.getMessage());
        }
        return reponse;
    }

    @GetMapping("/beneficeByMois")
    public Reponse<Statistique> getBeneficeByMois(@RequestParam("mois") int mois,@RequestParam("annee") int annee) {
        Statistique statistique = statistiqueService.getBeneficeByMois(mois, annee);
        Reponse<Statistique> reponse = new Reponse<>();
        try{
            reponse.setData(statistique);
            reponse.setRemarque("Bénéfice du mois " + mois + " de l'année " + annee);
        }catch (Exception e) {
            reponse.setErreur(e.getMessage());
        }
        return reponse;
    }
}
