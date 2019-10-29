package metier;

public class Plat implements Afficher {

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

    @Override
    public String getInfo(String column) {
        switch (column) {
            case "libelle":
                return libelle;
            case "idPlat":
                return String.valueOf(idPlat);
            case "prix":
                return String.valueOf(prix);
            case "numtype":
                return String.valueOf(numtype);
            case "ALL":
                return this.toString();
            default:
                return "not found";
        }
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

    @Override
    public String toString() {
        return "Plat{" +
               "libelle='" + libelle + '\'' +
               ", idPlat=" + idPlat +
               ", prix=" + prix +
               ", numtype=" + numtype +
               '}';
    }

}
