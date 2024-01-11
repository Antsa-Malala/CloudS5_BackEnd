package cloud.projetS5.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

@Entity
public class Porte {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_porte")
    private int idPorte;
    @Column(name = "valeur")
    private int valeur;
    @Column(name = "etat")
    private int etat;

    public Porte() {
    }

    public Porte(int idPorte, int valeur, int etat) {
        this.setIdPorte(idPorte);
        this.setValeur(valeur);
        this.setEtat(etat);
    }

    public int getIdPorte() {
        return idPorte;
    }

    public void setIdPorte(int idPorte) {
        this.idPorte = idPorte;
    }

    public int getValeur() {
        return valeur;
    }

    public void setValeur(int valeur) {
        this.valeur = valeur;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }
}
