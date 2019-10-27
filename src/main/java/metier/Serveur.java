package metier;

public class Serveur {

    private String numServeur;
    private String nom;
    private String prenom;
    private String grade;

    public Serveur(String numServeur, String nom, String prenom, String grade) {
        this.numServeur = numServeur;
        this.nom = nom;
        this.prenom = prenom;
        this.grade = grade;
    }

    public String getNumServeur() {
        return numServeur;
    }

    public void setNumServeur(String numServeur) {
        this.numServeur = numServeur;
    }


    public String getNom() {
        return nom;
    }

    public void setNom(String nom) {
        this.nom = nom;
    }


    public String getPrenom() {
        return prenom;
    }

    public void setPrenom(String prenom) {
        this.prenom = prenom;
    }


    public String getGrade() {
        return grade;
    }

    public void setGrade(String grade) {
        this.grade = grade;
    }

}
