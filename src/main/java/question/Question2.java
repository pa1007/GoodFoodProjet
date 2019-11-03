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

public class Question2 implements Question {

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
                    g.add(new Label("" + typePlat.getInfo(new String[]{"libelle"})), 0, nb.get());
                    g.add(new Label(typePlat.getInfo(new String[]{"idPlat"})), 1, nb.getAndIncrement());
                }
            }
        });
        return jButon;
    }

    public static List<Plat> getAll(Date dateF, Date dateT) {
        ConnectionSingleton cs    = ConnectionSingleton.getInstance();
        Connection          c     = cs.getConnection();
        List<Plat>          plats = new ArrayList<>();
        new Question1();
        List<Plat>          platsPeriode = Question1.getAll(dateF,dateT);
        try {
            PreparedStatement ps = c.prepareStatement("SELECT NumCommande FROM Commande where DATEDIFF(?,dateCommande) >= 0 OR DATEDIFF(dateCommande,?) >= 0");
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
                    // Verification si le plat a deja ete commande
                    if(plats.size() > 0){
                        for(Plat p : plats){
                            if(p.getIdPlat() == id){
                                ps3.setInt(1, -1);
                            }
                        }
                    }
                    // Verification si le plat a ete commande pendant la periode
                    if(platsPeriode.size() > 0){
                        for(Plat p : platsPeriode){
                            if(p.getIdPlat() == id){
                                ps3.setInt(1, -1);
                            }
                        }
                    }
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