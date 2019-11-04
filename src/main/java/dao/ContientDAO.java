package dao;

import database.ConnectionSingleton;
import metier.Contient;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class ContientDAO implements DAO<Contient, Couple<String, Integer>> {

    @Override
    public List<Contient> getAll() {
        ConnectionSingleton cs        = ConnectionSingleton.getInstance();
        Connection          c         = cs.getConnection();
        List<Contient>      contients = new ArrayList<>();
        try {
            PreparedStatement ps  = c.prepareStatement("SELECT * from contient");
            ResultSet         res = ps.executeQuery();
            while (res.next()) {
                contients.add(new Contient(
                        res.getString("NumCommande"),
                        res.getInt("idPlat"),
                        res.getInt("quantite")
                ));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return contients;
    }

    @Override
    public Contient find(Couple<String, Integer> id) {
        ConnectionSingleton cs         = ConnectionSingleton.getInstance();
        Connection          c          = cs.getConnection();
        Contient            restaurant = null;
        try {
            PreparedStatement ps =
                    c.prepareStatement(
                            "SELECT NumCommande,idPlat,quantite  FROM contient WHERE NumCommande=? and idPlat = ?");
            ps.setString(1, id.getPrim1());
            ps.setInt(2, id.getPrim2());
            ResultSet res = ps.executeQuery();
            if (res.first()) {
                restaurant = new Contient(res.getString(1), res.getInt(2), res.getInt(3));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return restaurant;
    }


    @Override
    public String[] getPrimary() {
        return new String[]{"numCommande", "idPlat"};
    }

    @Override
    public String[] getMainAff() {
        return new String[]{"ALL"};
    }
}
