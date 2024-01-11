package org.project.clouds5_backend.model;

import jakarta.persistence.*;

@Entity
public class Categorie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_categorie")
    private int idCategorie;
    @Column(name = "nom_categorie")
    private String nomCategorie;
    @Column(name = "etat_categorie")
    private int etat;

    public Categorie() {
    }

    public Categorie(int idCategorie, String nomCategorie, int etat) {
        this.idCategorie = idCategorie;
        this.nomCategorie = nomCategorie;
        this.etat = etat;
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
