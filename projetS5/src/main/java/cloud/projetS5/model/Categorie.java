package cloud.projetS5.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categorie")
    private int idCategorie;
    @Column(name = "nom_categorie")
    private String nomCategorie;
    @Column(name = "etat")
    private int etat;

    public Categorie() {
    }

    public  Categorie(int idCategorie, String nomCategorie, int etat) {
        this.setIdCategorie(idCategorie);
        this.setNomCategorie(nomCategorie);
        this.setEtat(etat);
    }

    public int getIdCategorie() {
        return idCategorie;
    }

    public void setIdCategorie(int idCategorie) {
        this.idCategorie = idCategorie;
    }

    public String getNomCategorie() {
        return nomCategorie;
    }

    public void setNomCategorie(String nomCategorie) {
        this.nomCategorie = nomCategorie;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }
}
