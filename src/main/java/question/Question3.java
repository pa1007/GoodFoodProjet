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
import java.util.List;
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
                List<Serveur> rep = getAll(Date.valueOf(jtextArea.getValue()), Date.valueOf(jtextArea2.getValue()));
                for (Serveur serveur : rep) {
                    g.add(new Label("" + serveur.getInfo(new String[]{"numServeur"})), 0, nb.get());
                    g.add(new Label(serveur.getInfo(new String[]{"nom"})), 1, nb.getAndIncrement());
                }
            }
        });
        return jButon;
    }

    public static List<Serveur> getAll(Date dateF, Date dateT) {
        ConnectionSingleton cs    = ConnectionSingleton.getInstance();
        Connection          c     = cs.getConnection();
        List<Serveur>          serveurs = new ArrayList<>();
        new Question1();
        try {
            PreparedStatement ps = c.prepareStatement("SELECT numTable FROM Commande where DATEDIFF(?,dateCommande) < 0 AND DATEDIFF(dateCommande,?) < 0");
            PreparedStatement ps2 = c.prepareStatement("SELECT distinct numserv From affecter where numTab = ?");
            PreparedStatement ps3 = c.prepareStatement("SELECT distinct nom From Serveur where numServeur = ?");
            ps.setDate(1, dateF);
            ps.setDate(2, dateT);
            ResultSet res = ps.executeQuery();

            while (res.next()) {
                ps2.setString(1, res.getString(1));
                ResultSet res2 = ps2.executeQuery();

                while (res2.next()) {
                    String numS = res2.getString(1);
                    ps3.setString(1,numS);

                    // Verification si le serveur est pas deja ajoute
                    if(serveurs.size() > 0){
                        for(Serveur p : serveurs){
                            if(p.getNumServeur().equals(numS)){
                                ps3.setString(1,"-1");
                            }
                        }
                    }

                    ResultSet res3 = ps3.executeQuery();
                    while (res3.next()) {
                        String nom = res3.getString(1);
                        serveurs.add(new Serveur(numS, nom, "x", "x"));
                    }
                }
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return serveurs;
    }
}