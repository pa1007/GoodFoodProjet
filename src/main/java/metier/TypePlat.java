package metier;

public class TypePlat implements Afficher {

    private int    numTypePlat;
    private String nomTypePlat;

    public TypePlat(int num, String nom) {
        this.numTypePlat = num;
        this.nomTypePlat = nom;
    }

    @Override
    public String getInfo(String column) {
        switch (column) {
            case "numTypePlat":
                return String.valueOf(numTypePlat);
            case "nomTypePlat":
                return nomTypePlat;
            case "ALL":
                return this.toString();
            default:
                return "not found";
        }
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

    @Override
    public String toString() {
        return "TypePlat{" +
               "numTypePlat=" + numTypePlat +
               ", nomTypePlat='" + nomTypePlat + '\'' +
               '}';
    }
}
