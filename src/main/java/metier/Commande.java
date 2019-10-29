package metier;

import java.sql.Timestamp;

public class Commande implements Afficher {

    private String    numCommande;
    private Timestamp dateCommande;
    private Timestamp dateEncaissement;
    private double    montantTotal;
    private long      nbPersonne;
    private String    numTable;
    private String    modePaiement;

    public Commande(
            String numCommande,
            Timestamp dateCommande,
            Timestamp dateEncaissement,
            double montantTotal,
            long nbPersonne,
            String numTable,
            String modePaiement
    ) {
        this.numCommande = numCommande;
        this.dateCommande = dateCommande;
        this.dateEncaissement = dateEncaissement;
        this.montantTotal = montantTotal;
        this.nbPersonne = nbPersonne;
        this.numTable = numTable;
        this.modePaiement = modePaiement;
    }

    @Override
    public String getInfo(String column) {
        switch (column) {
            case "numCommande":
                return numCommande;
            case "dateCommande":
                return String.valueOf(dateCommande);
            case "dateEncaissement":
                return String.valueOf(dateEncaissement);
            case "montantTotal":
                return String.valueOf(montantTotal);
            case "nbPersonne":
                return String.valueOf(nbPersonne);
            case "numTable":
                return numTable;
            case "modePaiement":
                return modePaiement;
            case "ALL":
                return this.toString();
            default:
                return "not found";
        }
    }

    public String getNumCommande() {
        return numCommande;
    }

    public void setNumCommande(String numCommande) {
        this.numCommande = numCommande;
    }

    public Timestamp getDateCommande() {
        return dateCommande;
    }

    public void setDateCommande(Timestamp dateCommande) {
        this.dateCommande = dateCommande;
    }

    public Timestamp getDateEncaissement() {
        return dateEncaissement;
    }

    public void setDateEncaissement(Timestamp dateEncaissement) {
        this.dateEncaissement = dateEncaissement;
    }

    public double getMontantTotal() {
        return montantTotal;
    }

    public void setMontantTotal(double montantTotal) {
        this.montantTotal = montantTotal;
    }

    public long getNbPersonne() {
        return nbPersonne;
    }

    public void setNbPersonne(long nbPersonne) {
        this.nbPersonne = nbPersonne;
    }

    public String getNumTable() {
        return numTable;
    }

    public void setNumTable(String numTable) {
        this.numTable = numTable;
    }

    public String getModePaiement() {
        return modePaiement;
    }

    public void setModePaiement(String modePaiement) {
        this.modePaiement = modePaiement;
    }

    @Override
    public String toString() {
        return "Commande{" +
               "numCommande='" + numCommande + '\'' +
               ", dateCommande=" + dateCommande +
               ", dateEncaissement=" + dateEncaissement +
               ", montantTotal=" + montantTotal +
               ", nbPersonne=" + nbPersonne +
               ", numTable='" + numTable + '\'' +
               ", modePaiement='" + modePaiement + '\'' +
               '}';
    }
}
