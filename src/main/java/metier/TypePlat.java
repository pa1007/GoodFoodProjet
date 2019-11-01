package metier;

public class TypePlat implements Afficher {

    private int    numTypePlat;
    private String nomTypePlat;

    public TypePlat(int num, String nom) {
        this.numTypePlat = num;
        this.nomTypePlat = nom;
    }

    @Override
    public String getInfo(String[] column) {
        StringBuilder res = new StringBuilder();
        for (String col : column) {
            switch (col) {
                case "numTypePlat":
                    res.append(numTypePlat);
                    break;
                case "nomTypePlat":
                    res.append(nomTypePlat);
                    break;
                case "ALL":
                    return this.toString();
            }
            res.append(",");
        }
        return res.toString();
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
