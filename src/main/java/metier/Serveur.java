package metier;

public class Serveur implements Afficher {

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

    @Override
    public String getInfo(String[] column) {
        StringBuilder res = new StringBuilder();
        for (String col : column) {
            switch (col) {
                case "numServeur":
                    res.append(numServeur);
                    break;
                case "nom":
                    res.append(nom);
                    break;
                case "prenom":
                    res.append(prenom);
                    break;
                case "grade":
                    res.append(grade);
                    break;
                case "ALL":
                    return this.toString();
            }
            res.append(",");
        }
        return res.toString();
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

    @Override
    public String toString() {
        return "Serveur{" +
               "numServeur='" + numServeur + '\'' +
               ", nom='" + nom + '\'' +
               ", prenom='" + prenom + '\'' +
               ", grade='" + grade + '\'' +
               '}';
    }
}
