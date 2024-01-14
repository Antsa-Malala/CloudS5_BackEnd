package cloud.projetS5.model;

import jakarta.persistence.*;

@Entity
public class Favoris {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_favoris")
    private int idFavoris;

    @ManyToOne
    @JoinColumn(name = "id_utilisateur", referencedColumnName = "id_utilisateur")
    private Utilisateur utilisateur;

    @ManyToOne
    @JoinColumn(name = "id_annonce", referencedColumnName = "id_annonce")
    private Annonce annonce;

    // GETTERS AND SETTERS
    public int getIdFavoris() {
        return idFavoris;
    }

    public void setIdFavoris(int idFavoris) {
        this.idFavoris = idFavoris;
    }

    public Utilisateur getUtilisateur() {
        return utilisateur;
    }

    public void setUtilisateur(Utilisateur utilisateur) {
        this.utilisateur = utilisateur;
    }

    public Annonce getAnnonce() {
        return annonce;
    }

    public void setAnnonce(Annonce annonce) {
        this.annonce = annonce;
    }
}
