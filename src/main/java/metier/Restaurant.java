package metier;

public class Restaurant implements Afficher {

    private String numRestaurant;
    private String nom;

    public Restaurant(String numRestaurant, String nom) {
        this.numRestaurant = numRestaurant;
        this.nom = nom;
    }

    @Override
    public String getInfo(String column) {
        switch (column) {
            case "numRestaurant":
                return numRestaurant;
            case "nom":
                return nom;
            case "ALL":
                return this.toString();
            default:
                return "not found";
        }
    }

    public String getNumRestaurant() {
        return numRestaurant;
    }

    public void setNumRestaurant(String numRestaurant) {
        this.numRestaurant = numRestaurant;
    }

    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }

    @Override
    public String toString() {
        return "Restaurant{" +
               "numRestaurant='" + numRestaurant + '\'' +
               ", nom='" + nom + '\'' +
               '}';
    }
}
