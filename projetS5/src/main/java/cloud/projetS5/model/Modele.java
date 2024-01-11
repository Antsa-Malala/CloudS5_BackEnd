package cloud.projetS5.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;

@Entity
public class Modele {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_modele")
    private int idModele;
    @Column(name = "nom_modele")
    private String nomModele;

    @ManyToOne
    @JoinColumn(name = "id_marque", referencedColumnName = "id_marque", nullable = false)
    private Marque marque;

    @ManyToOne
    @JoinColumn(name = "id_categorie", referencedColumnName = "id_categorie", nullable = false)
    private Categorie categorie;

    @Column(name = "etat")
    private int etat;

    public Modele() {
    }

    public Modele(int idModele, String nomModele, Marque marque, Categorie categorie, int etat) {
        this.idModele = idModele;
        this.nomModele = nomModele;
        this.marque = marque;
        this.categorie = categorie;
        this.etat = etat;
    }

    public int getIdModele() {
        return idModele;
    }

    public void setIdModele(int idModele) {
        this.idModele = idModele;
    }

    public String getNomModele() {
        return nomModele;
    }

    public void setNomModele(String nomModele) {
        this.nomModele = nomModele;
    }

    public void setMarque(Marque marque) {
        this.marque = marque;
    }

    public Marque getMarque() {
        return this.marque;
    }

    public void setCategorie(Categorie categorie) {
        this.categorie = categorie;
    }

    public Categorie getCategorie() {
        return this.categorie;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }
}
