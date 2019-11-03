package question;

import database.ConnectionSingleton;
import metier.Afficher;
import metier.Plat;
import metier.TypePlat;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class Question1 implements Question<Plat> {

    @Override
    public String[] getMainAff() {
        return new String[]{"libelle"};
    }

    @Override
    public String[] getPrimary() {
        return new String[]{"idPlat"};
    }

    @Override
    public List<Plat> getInfos() {
        return getAll();
    }

    public static List<Plat> getAll() {
        ConnectionSingleton cs        = ConnectionSingleton.getInstance();
        Connection          c         = cs.getConnection();
        List<Plat>      plats = new ArrayList<>();
        try {
            PreparedStatement ps  = c.prepareStatement(
                    "SELECT NumCommande FROM Commande where DATEDIFF(str_TO_DATE(?,\"%Y-%m-%d\"),dateCommande) < 0 AND DATEDIFF(dateCommande,STR_TO_DATE(?,\"%Y-%m-%d\")) < 0");
            PreparedStatement ps2 = c.prepareStatement("SELECT distinct idPlat From contient where NumCommande = ?");
            PreparedStatement ps3 = c.prepareStatement("SELECT distinct libelle From Plat where idPlat = ?");
            ps.setString(1, "2014-01-09");
            ps.setString(2, "2020-01-09");
            ResultSet res = ps.executeQuery();

            while (res.next()) {
                ps2.setString(1, res.getString(1));
                ResultSet res2 = ps2.executeQuery();

                while (res2.next()) {
                    int id = res2.getInt(1);
                    ps3.setInt(1, res2.getInt(1));
                    ResultSet res3 = ps3.executeQuery();

                    while (res3.next()) {
                        plats.add(new Plat(res3.getString(1),id,0,0));
                    }
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return plats;
    }
}
