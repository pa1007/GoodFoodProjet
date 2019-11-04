package dao;

import database.ConnectionSingleton;
import metier.Table;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class TableDAO implements DAO<Table, String> {

    @Override
    public List<Table> getAll() {
        ConnectionSingleton cs     = ConnectionSingleton.getInstance();
        Connection          c      = cs.getConnection();
        List<Table>         tables = new ArrayList<>();
        try {
            PreparedStatement ps  = c.prepareStatement("SELECT * from `Table`");
            ResultSet         res = ps.executeQuery();
            while (res.next()) {
                tables.add(new Table(
                        res.getString("NumTable"),
                        res.getInt("PlaceMax"),
                        res.getString("NumSalle")
                ));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return tables;
    }

    @Override
    public Table find(String id) {
        ConnectionSingleton cs    = database.ConnectionSingleton.getInstance();
        Connection          c     = cs.getConnection();
        Table               table = null;
        try {
            PreparedStatement ps =
                    c.prepareStatement(
                            "SELECT NumTable, PlaceMax, NumSalle  FROM `Table` WHERE NumTable = ?");
            ps.setString(1, id);
            ResultSet res = ps.executeQuery();
            if (res.first()) {
                table = new Table(res.getString(1), res.getInt(2), res.getString(3));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return table;
    }

    @Override
    public String[] getPrimary() {
        return new String[0];
    }

    @Override
    public String[] getMainAff() {
        return new String[0];
    }
}
