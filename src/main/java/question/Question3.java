package question;

import database.ConnectionSingleton;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import metier.Serveur;

import java.sql.*;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Question3 implements Question {

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
                HashMap<Serveur,String> rep = getAll(Date.valueOf(jtextArea.getValue()), Date.valueOf(jtextArea2.getValue()));
                for (Serveur serveur : rep.keySet()) {
                    g.add(new Label(serveur.getInfo(new String[]{"nom"})), 0, nb.get());
                    g.add(new Label(rep.get(serveur)),1, nb.getAndIncrement());
                }
            }
        });
        return jButon;
    }

    public static HashMap<Serveur,String> getAll(Date dateF, Date dateT) {
        ConnectionSingleton cs = ConnectionSingleton.getInstance();
        Connection c = cs.getConnection();
        HashMap<Serveur,String> serveurs = new HashMap<>();
        new Question1();
        try {
            PreparedStatement ps = c.prepareStatement("SELECT nom, affecter.dataff FROM Commande inner join affecter on numTable = numTab" +
                    " inner join Serveur on numserv = numServeur where numTable = ? and DATEDIFF(?,dateCommande) < 0 AND " +
                    "DATEDIFF(dateCommande,?) < 0 group by affecter.dataff");
            ps.setInt(1,10);
            ps.setDate(2, dateF);
            ps.setDate(3, dateT);
            ResultSet res = ps.executeQuery();

            while (res.next()) {
                while (res.next()) {
                    String nom = res.getString(1);
                    String date = res.getString(2);
                    serveurs.put(new Serveur("x", nom, "x", "x"), date);
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return serveurs;
    }
}