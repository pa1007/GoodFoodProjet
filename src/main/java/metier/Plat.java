package metier;

public class Plat {

    private String libelle;
    private long   idPlat;
    private double prix;
    private long   numtype;

    public Plat(String libelle, long idPlat, double prix, long numtype) {
        this.libelle = libelle;
        this.idPlat = idPlat;
        this.prix = prix;
        this.numtype = numtype;
    }

    public String getLibelle() {
        return libelle;
    }

    public void setLibelle(String libelle) {
        this.libelle = libelle;
    }


    public long getIdPlat() {
        return idPlat;
    }

    public void setIdPlat(long idPlat) {
        this.idPlat = idPlat;
    }


    public double getPrix() {
        return prix;
    }

    public void setPrix(double prix) {
        this.prix = prix;
    }


    public long getNumtype() {
        return numtype;
    }

    public void setNumtype(long numtype) {
        this.numtype = numtype;
    }

}
