package cloud.projetS5.model;

import jakarta.persistence.*;

@Entity
public class Utilisateur {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_utilisateur")
    private String id_utilisateur;
    @Column(name = "nom")
    private String nom;
    @Column(name = "id_ville")
    private int id_ville;
    @Column(name = "prenom")
    private String prenom;
    @Column(name = "adresse")
    private String adresse;
    @Column(name = "contact")
    private String contact;
    @Column(name = "mail")
    private String mail;
    @Column(name = "mot_de_passe")
    private String mot_de_passe;    
    @Column(name = "role")
    private int role;

    public Utilisateur() {
    }



    public Utilisateur(String id_utilisateur, String nom, int id_ville, String prenom, String adresse, String contact, String mail, String mot_de_passe, int role) {
        this.id_utilisateur = id_utilisateur;
        this.nom = nom;
        this.id_ville = id_ville;
        this.prenom = prenom;
        this.adresse = adresse;
        this.contact = contact;
        this.mail = mail;
        this.mot_de_passe = mot_de_passe;
        this.role = role;
    }


    public String getId_utilisateur() {
        return this.id_utilisateur;
    }

    public void setId_utilisateur(String id_utilisateur) {
        this.id_utilisateur = id_utilisateur;
    }

    public String getNom() {
        return this.nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    public int getId_ville() {
        return this.id_ville;
    }

    public void setId_ville(int id_ville) {
        this.id_ville = id_ville;
    }

    public String getPrenom() {
        return this.prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }

    public String getAdresse() {
        return this.adresse;
    }

    public void setAdresse(String adresse) {
        this.adresse = adresse;
    }

    public String getContact() {
        return this.contact;
    }

    public void setContact(String contact) {
        this.contact = contact;
    }

    public String getMail() {
        return this.mail;
    }

    public void setMail(String mail) {
        this.mail = mail;
    }

    public String getMot_de_passe() {
        return this.mot_de_passe;
    }

    public void setMot_de_passe(String mot_de_passe) {
        this.mot_de_passe = mot_de_passe;
    }

    public int getRole() {
        return this.role;
    }

    public void setRole(int role) {
        this.role = role;
    }

}
