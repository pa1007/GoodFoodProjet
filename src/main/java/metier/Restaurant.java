package metier;

public class Restaurant {

    private String numRestaurant;
    private String nom;

    public Restaurant(String numRestaurant, String nom) {
        this.numRestaurant = numRestaurant;
        this.nom = nom;
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

}
