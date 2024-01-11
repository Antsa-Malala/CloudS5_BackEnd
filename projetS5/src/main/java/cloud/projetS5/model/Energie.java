package cloud.projetS5.model;

import jakarta.persistence.*;

@Entity
public class Energie {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id_energie")
    private int idEnergie;
    @Column(name = "nom_energie")
    private String nomEnergie;
    @Column(name = "etat")
    private int etat;

    public Energie() {
    }

    public  Energie(int idEnergie, String nomEnergie, int etat) {
        this.setIdEnergie(idEnergie);
        this.setNomEnergie(nomEnergie);
        this.setEtat(etat);
    }

    public int getIdEnergie() {
        return idEnergie;
    }

    public void setIdEnergie(int idEnergie) {
        this.idEnergie = idEnergie;
    }

    public String getNomEnergie() {
        return nomEnergie;
    }

    public void setNomEnergie(String nomEnergie) {
        this.nomEnergie = nomEnergie;
    }

    public int getEtat() {
        return etat;
    }

    public void setEtat(int etat) {
        this.etat = etat;
    }
}
