package dao;

import database.ConnectionSingleton;
import metier.Affecter;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class AffecterDAO implements DAO<Affecter, Integer> {

    @Override
    public List<Affecter> getAll() {
        ConnectionSingleton cs        = ConnectionSingleton.getInstance();
        Connection          c         = cs.getConnection();
        List<Affecter>      affecters = new ArrayList<>();
        try {
            PreparedStatement ps  = c.prepareStatement("SELECT * from affecter");
            ResultSet         res = ps.executeQuery();
            while (res.next()) {
                affecters.add(new Affecter(res.getLong("numTab"), res.getDate("dataff"), res.getLong("numserv")));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return affecters;
    }

    @Override
    public Affecter find(Integer id) {
        ConnectionSingleton cs        = ConnectionSingleton.getInstance();
        Connection          c         = cs.getConnection();
        Affecter            affecters = null;
        try {
            PreparedStatement ps =
                    c.prepareStatement("SELECT numTab,numserv,dataff FROM affecter WHERE numTab=?");
            ps.setInt(1, id);
            ResultSet res = ps.executeQuery();
            if (res.first()) {
                affecters = new Affecter(res.getLong(1), res.getDate(3), res.getLong(2));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return affecters;
    }

    @Override
    public String[] getPrimary() {
        return new String[]{"numTab", "dataff"};
    }

    @Override
    public String[] getMainAff() {
        return new String[]{"ALL"};
    }
}
