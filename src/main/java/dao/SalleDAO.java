package dao;

import database.ConnectionSingleton;
import metier.Salle;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class SalleDAO implements DAO<Salle, String> {

    @Override
    public List<Salle> getAll() {
        ConnectionSingleton cs     = ConnectionSingleton.getInstance();
        Connection          c      = cs.getConnection();
        List<Salle>         salles = new ArrayList<>();
        try {
            PreparedStatement ps  = c.prepareStatement("SELECT * from Salle");
            ResultSet         res = ps.executeQuery();
            while (res.next()) {
                salles.add(new Salle(
                        res.getString("numSalle"),
                        res.getString("nomSalle"),
                        res.getString("NumRestaurant")
                ));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return salles;
    }

    @Override
    public Salle find(String id) {
        ConnectionSingleton cs    = database.ConnectionSingleton.getInstance();
        Connection          c     = cs.getConnection();
        Salle               salle = null;
        try {
            PreparedStatement ps =
                    c.prepareStatement(
                            "SELECT numsalle, nomSalle, numrestaurant  FROM Salle WHERE numSalle = ?");
            ps.setString(1, id);
            ResultSet res = ps.executeQuery();
            if (res.first()) {
                salle = new Salle(res.getString(1), res.getString(2), res.getString(3));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return salle;
    }

    @Override
    public String[] getPrimary() {
        return new String[]{"numSalle"};
    }

    @Override
    public String[] getMainAff() {
        return new String[]{"nomSalle"};
    }
}
