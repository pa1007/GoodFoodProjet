package question;

import database.ConnectionSingleton;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import metier.Plat;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

public class Question1 implements Question {

    private DatePicker jtextArea;
    private Button     jButon;
    private DatePicker jtextArea2;

    @Override
    public Node[] waitInfo() {
        this.jtextArea = new DatePicker();
        this.jtextArea2 = new DatePicker();
        return new Node[]{jtextArea, jtextArea2};
    }

    @Override
    public Button ask(GridPane g, AtomicInteger start) {
        jButon = new Button("Valider");
        jButon.setOnAction(e -> {
            if (!jtextArea.getEditor().getText().isEmpty() && !jtextArea2.getEditor().getText().isEmpty()) {
                g.getColumnConstraints().add(new ColumnConstraints(400));
                List<Plat> rep = getAll(Date.valueOf(jtextArea.getValue()), Date.valueOf(jtextArea2.getValue()));
                for (Plat typePlat : rep) {
                    g.add(new Label("" + typePlat.getInfo(new String[]{"libelle"})), 0, start.get());
                    g.add(new Label(typePlat.getInfo(new String[]{"idPlat"})), 1, start.getAndIncrement());
                }
            }
        });
        return jButon;
    }

    public static List<Plat> getAll(Date dateF, Date dateT) {
        ConnectionSingleton cs    = ConnectionSingleton.getInstance();
        Connection          c     = cs.getConnection();
        List<Plat>          plats = new ArrayList<>();
        try {
            PreparedStatement ps = c.prepareStatement(
                    "SELECT NumCommande FROM Commande where DATEDIFF(?,dateCommande) < 0 AND DATEDIFF(dateCommande,?) < 0");
            PreparedStatement ps2 = c.prepareStatement("SELECT distinct idPlat From contient where NumCommande = ?");
            PreparedStatement ps3 = c.prepareStatement("SELECT distinct libelle From Plat where idPlat = ?");
            ps.setDate(1, dateF);
            ps.setDate(2, dateT);
            ResultSet res = ps.executeQuery();

            while (res.next()) {
                ps2.setString(1, res.getString(1));
                ResultSet res2 = ps2.executeQuery();

                while (res2.next()) {
                    int id = res2.getInt(1);
                    ps3.setInt(1, res2.getInt(1));
                    ResultSet res3 = ps3.executeQuery();

                    while (res3.next()) {
                        plats.add(new Plat(res3.getString(1), id, 0, 0));
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
