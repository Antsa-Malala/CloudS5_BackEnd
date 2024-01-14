package cloud.projetS5.model;

import jakarta.persistence.*;

@Entity
public class Couleur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_couleur")
    private int idCouleur;

    @Column(name = "nom_couleur", nullable = false)
    private String nomCouleur;
    @Column(name = "etat_couleur")
    private int etat;

    public int getIdCouleur() {
        return idCouleur;
    }

    public void setIdCouleur(int idCouleur) {
        this.idCouleur = idCouleur;
    }

    public String getNomCouleur() {
        return nomCouleur;
    }

    public void setNomCouleur(String nomCouleur) {
        this.nomCouleur = nomCouleur;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }

    public Couleur() {
    }

    public Couleur(int idCouleur, String nomCouleur, int etat) {
        this.setIdCouleur(idCouleur);
        this.setNomCouleur(nomCouleur);
        this.setEtat(etat);
    }
}
