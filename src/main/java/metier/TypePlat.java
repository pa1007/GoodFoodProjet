package metier;

public class TypePlat implements Afficher {

    private int    numTypePlat;
    private String nomTypePlat;

    public TypePlat(int num, String nom) {
        this.numTypePlat = num;
        this.nomTypePlat = nom;
    }

    @Override
    public String getAffString() {
        return getNomTypePlat();
    }

    @Override
    public String getSecondAff() {
        return String.valueOf(getNumTypePlat());
    }

    public int getNumTypePlat() {
        return numTypePlat;
    }

    public void setNumTypePlat(int numTypePlat) {
        this.numTypePlat = numTypePlat;
    }

    public String getNomTypePlat() {
        return nomTypePlat;
    }

    public void setNomTypePlat(String nomTypePlat) {
        this.nomTypePlat = nomTypePlat;
    }
}
