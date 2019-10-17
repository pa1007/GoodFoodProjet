package dao;

import database.ConnectionSingleton;
import metier.TypePlat;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TypePlatDAO {

    public TypePlatDAO() {

    }

    public List<TypePlat> getAll() {
        ConnectionSingleton cs      = ConnectionSingleton.getInstance();
        Connection          c       = cs.getConnection();
        List<TypePlat>      allPlat = new ArrayList<>();
        try {
            PreparedStatement ps  = c.prepareStatement("SELECT * from type");
            ResultSet         res = ps.executeQuery();
            while (res.next()) {
                allPlat.add(new TypePlat(res.getInt("numTypePlat"), res.getString("nomTypePlat")));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return allPlat;
    }

    public TypePlat find(int id) {
        ConnectionSingleton cs       = ConnectionSingleton.getInstance();
        Connection          c        = cs.getConnection();
        TypePlat            typePlat = null;
        try {
            PreparedStatement ps = c.prepareStatement("SELECT idtype,nomtype FROM type WHERE idtype=?");
            ps.setInt(1, id);
            ResultSet res = ps.executeQuery();
            if (res.first()) {
                typePlat = new TypePlat(res.getInt(1), res.getString(2));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return typePlat;
    }

}
