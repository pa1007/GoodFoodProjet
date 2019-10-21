package dao;

import database.ConnectionSingleton;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Question1 {

    public static void getAll(){
        ConnectionSingleton cs = ConnectionSingleton.getInstance();
        Connection c = cs.getConnection();
        try {
            PreparedStatement ps = c.prepareStatement("SELECT NumCommande FROM Commande where DATEDIFF(str_TO_DATE(?,\"%Y-%m-%d\"),dateCommande) < 0 AND DATEDIFF(dateCommande,STR_TO_DATE(?,\"%Y-%m-%d\")) < 0");
            PreparedStatement ps2 = c.prepareStatement("SELECT distinct idPlat From contient where NumCommande = ?");
            PreparedStatement ps3 = c.prepareStatement("SELECT distinct libelle From Plat where idPlat = ?");
            ps.setString(1,"2014-01-09");
            ps.setString(2,"2020-01-09");
            ResultSet res = ps.executeQuery();

            while (res.next()) {
                ps2.setString(1,res.getString(1));
                ResultSet res2 = ps2.executeQuery();

                while (res2.next()){
                    int id = res2.getInt(1);
                    ps3.setInt(1,res2.getInt(1));
                    ResultSet res3 = ps3.executeQuery();

                    while (res3.next()){
                        String libelle = res3.getString(1);
                        System.out.println("plat : " + libelle + " num : " + id);
                    }
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        getAll();
    }
}
