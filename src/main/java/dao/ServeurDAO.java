package dao;

import database.ConnectionSingleton;
import metier.Salle;
import metier.Serveur;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ServeurDAO implements DAO<Serveur, String> {

    @Override
    public List<Serveur> getAll() {
        ConnectionSingleton cs       = ConnectionSingleton.getInstance();
        Connection          c        = cs.getConnection();
        List<Serveur>       serveurs = new ArrayList<>();
        try {
            PreparedStatement ps  = c.prepareStatement("SELECT * from Serveur");
            ResultSet         res = ps.executeQuery();
            while (res.next()) {
                serveurs.add(new Serveur(
                        res.getString("numServeur"),
                        res.getString("nom"),
                        res.getString("prenom"),
                        res.getString("grade")
                ));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return serveurs;
    }

    @Override
    public Serveur find(String id) {
        ConnectionSingleton cs    = database.ConnectionSingleton.getInstance();
        Connection          c     = cs.getConnection();
        Serveur               serveur = null;
        try {
            PreparedStatement ps =
                    c.prepareStatement(
                            "SELECT numServeur, nom, prenom,grade  FROM Serveur WHERE numServeur = ?");
            ps.setString(1, id);
            ResultSet res = ps.executeQuery();
            if (res.first()) {
                serveur = new Serveur(res.getString(1), res.getString(2), res.getString(3),res.getString(4));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return serveur;
    }

    @Override
    public String[] getPrimary() {
        return new String[]{"numServeur"};
    }

    @Override
    public String[] getMainAff() {
        return new String[]{"nom","prenom","grade"};
    }
}
