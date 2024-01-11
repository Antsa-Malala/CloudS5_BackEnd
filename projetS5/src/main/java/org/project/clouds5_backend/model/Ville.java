package org.project.clouds5_backend.model;

import jakarta.persistence.*;

@Entity
public class Ville {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_ville")
    private int idVille;
    @Column(name = "nom_ville")
    private String nomVille;
    @Column(name = "etat_ville")
    private int etat;

    public Ville() {
    }

    public Ville(int idVille, String nomVille, int etat) {
        this.idVille = idVille;
        this.nomVille = nomVille;
        this.etat = etat;
    }

    public int getIdVille() {
        return idVille;
    }

    public void setIdVille(int idVille) {
        this.idVille = idVille;
    }

    public String getNomVille() {
        return nomVille;
    }

    public void setNomVille(String nomVille) {
        this.nomVille = nomVille;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }
}
