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
    public String getInfo(String column) {
        switch (column) {
            case "numSalle":
                return numSalle;
            case "nomSable":
                return nomSable;
            case "numRestaurant":
                return numRestaurant;
            case "ALL":
                return this.toString();
            default:
                return "not found";
        }
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
