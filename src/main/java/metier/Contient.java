package metier;

public class Contient implements Afficher {

    private String numCommande;
    private long   idPlat;
    private long   quantite;

    public Contient(String numCommande, long idPlat, long quantite) {
        this.numCommande = numCommande;
        this.idPlat = idPlat;
        this.quantite = quantite;
    }

    @Override
    public String getInfo(String[] column) {
        StringBuilder res = new StringBuilder();
        for (String col : column) {
            switch (col) {
                case "numCommande":
                    res.append(numCommande);
                    break;
                case "idPlat":
                    res.append(idPlat);
                    break;
                case "quantite":
                    res.append(quantite);
                    break;
                case "ALL":
                    return this.toString();
            }
            res.append(",");
        }
        return res.toString();
    }

    public String getNumCommande() {
        return numCommande;
    }

    public void setNumCommande(String numCommande) {
        this.numCommande = numCommande;
    }

    public long getIdPlat() {
        return idPlat;
    }

    public void setIdPlat(long idPlat) {
        this.idPlat = idPlat;
    }

    public long getQuantite() {
        return quantite;
    }

    public void setQuantite(long quantite) {
        this.quantite = quantite;
    }

    @Override
    public String toString() {
        return "Contient{" +
               "numCommande='" + numCommande + '\'' +
               ", idPlat=" + idPlat +
               ", quantite=" + quantite +
               '}';
    }
}
