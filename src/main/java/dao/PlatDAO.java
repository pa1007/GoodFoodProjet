package dao;

import database.ConnectionSingleton;
import metier.Contient;
import metier.Plat;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PlatDAO implements DAO<Plat,Integer> {

    @Override
    public List<Plat> getAll() {
        ConnectionSingleton cs        = ConnectionSingleton.getInstance();
        Connection            c         = cs.getConnection();
        List<Plat>        plats = new ArrayList<>();
        try {
            PreparedStatement ps  = c.prepareStatement("SELECT * from Plat");
            ResultSet         res = ps.executeQuery();
            while (res.next()) {
                plats.add(new Plat(
                        res.getString("libelle"),
                        res.getInt("idPlat"),
                        res.getDouble("prix"),
                        res.getInt("numType")
                ));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return plats;
    }

    @Override
    public Plat find(Integer id) {
        ConnectionSingleton cs         = ConnectionSingleton.getInstance();
        Connection          c          = cs.getConnection();
        Plat            restaurant = null;
        try {
            PreparedStatement ps =
                    c.prepareStatement(
                            "SELECT libelle,idPlat,prix,numtype  FROM Plat WHERE idPlat = ?");
            ps.setInt(1, id);
            ResultSet res = ps.executeQuery();
            if (res.first()) {
                restaurant = new Plat(res.getString(1), res.getInt(2), res.getDouble(3),res.getInt(4));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return restaurant;
    }

    @Override
    public String[] getPrimary() {
        return new String[]{"idPlat"};
    }

    @Override
    public String[] getMainAff() {
        return new String[]{"libelle","prix"};
    }
}
