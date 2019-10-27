package metier;

public class Contient {

    private String numCommande;
    private long   idPlat;
    private long   quantite;

  public Contient(String numCommande, long idPlat, long quantite) {
    this.numCommande = numCommande;
    this.idPlat = idPlat;
    this.quantite = quantite;
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

}
