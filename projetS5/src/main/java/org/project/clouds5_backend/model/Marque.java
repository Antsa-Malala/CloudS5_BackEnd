package org.project.clouds5_backend.model;

import jakarta.persistence.*;

@Entity
public class Marque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_marque")
    private int idMarque;
    @Column(name = "nom_marque")
    private String nomMarque;
    @Column(name = "etat_marque")
    private int etat;

    public Marque() {
    }

    public Marque(int idMarque, String nomMarque, int etat) {
        this.idMarque = idMarque;
        this.nomMarque = nomMarque;
        this.etat = etat;
    }

    public int getIdMarque() {
        return idMarque;
    }

    public void setIdMarque(int idMarque) {
        this.idMarque = idMarque;
    }

    public String getNomMarque() {
        return nomMarque;
    }

    public void setNomMarque(String nomMarque) {
        this.nomMarque = nomMarque;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }
}
