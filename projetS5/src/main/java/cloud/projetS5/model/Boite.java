package cloud.projetS5.model;

import jakarta.persistence.*;

@Entity
public class Boite {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_boite")
    private int idBoite;
    @Column(name = "nom_boite")
    private String nomBoite;
    @Column(name = "etat")
    private int etat;

    public Boite() {
    }

    public  Boite(int idBoite, String nomBoite, int etat) {
        this.setIdboite(idBoite);
        this.setNomBoite(nomBoite);
        this.setEtat(etat);
    }

    public int getIdBoite() {
        return idBoite;
    }

    public void setIdboite(int idBoite) {
        this.idBoite = idBoite;
    }

    public String getNomboite() {
        return nomBoite;
    }

    public void setNomBoite(String nomBoite) {
        this.nomBoite = nomBoite;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }
}
