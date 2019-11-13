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
import java.util.ArrayList;
import java.util.concurrent.atomic.AtomicInteger;

public class Question5 implements Question {

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
                ArrayList<Serveur> rep = getAll(Date.valueOf(jtextArea.getValue()), Date.valueOf(jtextArea2.getValue()));
                for (Serveur serveur : rep) {
                    g.add(new Label("" + serveur.getInfo(new String[]{"nom"})), 0, nb.getAndIncrement());
                }
            }
        });
        return jButon;
    }

    public static ArrayList<Serveur> getAll(Date dateF, Date dateT) {
        ConnectionSingleton cs = ConnectionSingleton.getInstance();
        Connection c = cs.getConnection();
        ArrayList<Serveur>  resultat = new ArrayList<>();
        new Question1();
        try {
            PreparedStatement ps1 = c.prepareStatement("SELECT nom, sum(MontantTotal) From Serveur inner join affecter on numServeur = numserv inner join Commande " +
                    " on numTable = numTab where dateCommande between ? and ? group by numServeur having sum(MontantTotal) = 0");
            ps1.setDate(1, dateF);
            ps1.setDate(2, dateT);
            ResultSet res = ps1.executeQuery();
            while (res.next()) {
                resultat.add(new Serveur("x",res.getString(1),"x","x"));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultat;
    }
}