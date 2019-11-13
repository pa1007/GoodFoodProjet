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
    public Button ask(GridPane g, int start) {
        jButon = new Button("Valider");
        AtomicInteger nb = new AtomicInteger(start);
        jButon.setOnAction(e -> {
            if (!jtextArea.getEditor().getText().isEmpty() && !jtextArea2.getEditor().getText().isEmpty()) {
                g.getColumnConstraints().add(new ColumnConstraints(400));
                List<Plat> rep = getAll(Date.valueOf(jtextArea.getValue()), Date.valueOf(jtextArea2.getValue()));
                for (Plat typePlat : rep) {
                    g.add(new Label( "" + typePlat.getInfo(new String[]{"idPlat"})), 1, nb.get());
                    g.add(new Label("" + typePlat.getInfo(new String[]{"libelle"})), 0, nb.getAndIncrement());
                }
            }
        });
        return jButon;
    }

    public static List<Plat> getAll(Date dateF, Date dateT) {
        ConnectionSingleton cs    = ConnectionSingleton.getInstance();
        Connection          c     = cs.getConnection();
        List<Integer> listID = new ArrayList<>();
        List<Plat>          plats = new ArrayList<>();
        try {
            PreparedStatement ps = c.prepareStatement("SELECT P.idPlat , P.libelle FROM Commande C inner join contient on C.NumCommande = contient.NumCommande " +
                    "inner join Plat P on contient.idPlat = P.idPlat where DATEDIFF(?,dateCommande) < 0 AND DATEDIFF(dateCommande,?) < 0");
            ps.setDate(1, dateF);
            ps.setDate(2, dateT);
            ResultSet res = ps.executeQuery();

            while (res.next()) {
                if(!listID.contains(res.getInt(1))) {
                    listID.add(res.getInt(1));
                    plats.add(new Plat(res.getString(2), res.getInt(1), 0, 0));
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return plats;
    }
}