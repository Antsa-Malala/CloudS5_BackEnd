package org.project.clouds5_backend.model;

import jakarta.persistence.*;

import java.sql.Date;

@Entity
public class Annonce {
    @Id
    @Column(name = "id_annonce", length = 10)
    private String idAnnonce;
    @Column(name = "date_annonce", nullable = false)
    private Date dateAnnonce;
    @Column(name = "prix", precision = 12, scale = 2, nullable = false)
    private double prix;
    @OneToOne
    @JoinColumn(name = "id_voiture", referencedColumnName = "id_voiture")
    private Voiture voiture;
    @Column(name = "id_ville")
    private String idVille;
    @Column(name ="description", nullable = false)
    private String description;
    private int etat;
    @Column(name = "id_utilisateur", length = 10)
    private String idUtilisateur;
}
