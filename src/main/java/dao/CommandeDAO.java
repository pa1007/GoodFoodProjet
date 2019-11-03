package dao;

import database.ConnectionSingleton;
import metier.Commande;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class CommandeDAO implements DAO<Commande, String> {

    @Override
    public List<Commande> getAll() {
        ConnectionSingleton cs        = ConnectionSingleton.getInstance();
        Connection          c         = cs.getConnection();
        List<Commande>      commandes = new ArrayList<>();
        try {
            PreparedStatement ps  = c.prepareStatement("SELECT * from Commande");
            ResultSet         res = ps.executeQuery();
            while (res.next()) {
                commandes.add(new Commande(
                        res.getString("NumCommande"),
                        res.getTimestamp("dateCommande"),
                        res.getTimestamp("dateEncaissement"),
                        res.getDouble("MontantTotal"),
                        res.getLong("NbPersonne"),
                        res.getString("numTable"),
                        res.getString("modePaiement")
                ));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return commandes;
    }

    @Override
    public Commande find(String id) {
        ConnectionSingleton cs       = ConnectionSingleton.getInstance();
        Connection          c        = cs.getConnection();
        Commande            commande = null;
        try {
            PreparedStatement ps =
                    c.prepareStatement(
                            "SELECT NumCommande, dateCommande, dateEncaissement, MontantTotal, NbPersonne, numTable, modePaiement FROM Commande WHERE NumCommande=?");
            ps.setString(1, id);
            ResultSet res = ps.executeQuery();
            if (res.first()) {
                commande = new Commande(
                        res.getString(1),
                        res.getTimestamp(2),
                        res.getTimestamp(3),
                        res.getDouble(4),
                        res.getLong(5),
                        res.getString(6),
                        res.getString(7)
                );
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return commande;
    }

    @Override
    public String[] getPrimary() {
        return new String[]{"numCommande"};
    }

    @Override
    public String[] getMainAff() {
        return new String[]{"dateCommande", "NbPersonne", "numTable"};
    }
}
