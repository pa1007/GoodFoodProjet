package metier;

public class Salle implements Afficher {

    private String numSalle;
    private String nomSable;
    private String numRestaurant;

    public Salle(String numSalle, String nomSable, String numRestaurant) {
        this.numSalle = numSalle;
        this.nomSable = nomSable;
        this.numRestaurant = numRestaurant;
    }

    @Override
    public String getInfo(String[] column) {
        StringBuilder res = new StringBuilder();
        for (String col : column) {
            switch (col) {
                case "numSalle":
                    res.append(numSalle);
                    break;
                case "nomSable":
                    res.append(nomSable);
                    break;
                case "numRestaurant":
                    res.append(numRestaurant);
                    break;
                case "ALL":
                    return this.toString();
            }
            res.append(",");
        }
        return res.toString();
    }

    public String getNumSalle() {
        return numSalle;
    }

    public void setNumSalle(String numSalle) {
        this.numSalle = numSalle;
    }

    public String getNomSable() {
        return nomSable;
    }

    public void setNomSable(String nomSable) {
        this.nomSable = nomSable;
    }

    public String getNumRestaurant() {
        return numRestaurant;
    }

    public void setNumRestaurant(String numRestaurant) {
        this.numRestaurant = numRestaurant;
    }

    @Override
    public String toString() {
        return "Salle{" +
               "numSalle='" + numSalle + '\'' +
               ", nomSable='" + nomSable + '\'' +
               ", numRestaurant='" + numRestaurant + '\'' +
               '}';
    }
}
