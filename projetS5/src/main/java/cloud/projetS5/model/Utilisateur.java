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
    @ManyToOne
    @JoinColumn(name = "id_ville", referencedColumnName = "id_ville")
    private Ville ville;

    public Utilisateur() {
    }



    public Utilisateur(String id_utilisateur, String nom, Ville ville, String prenom, String adresse, String contact, String mail, String mot_de_passe, int role) {
        this.setId_utilisateur(id_utilisateur);
        this.setNom(nom);
        this.setPrenom(prenom);
        this.setAdresse(adresse);
        this.setContact(contact);
        this.setMail(mail);
        this.setMot_de_passe(mot_de_passe);
        this.setRole(role);
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

    public Ville getVille() {
        return ville;
    }

    public void setVille(Ville ville) {
        this.ville = ville;
    }
}
