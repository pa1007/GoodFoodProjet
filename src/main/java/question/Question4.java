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
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicInteger;

public class Question4 implements Question {

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
                HashMap<Serveur,ArrayList<Integer>> rep = getAll(Date.valueOf(jtextArea.getValue()), Date.valueOf(jtextArea2.getValue()));
                for (Serveur serveur : rep.keySet()) {
                    g.add(new Label("" + serveur.getInfo(new String[]{"nom"})), 0, nb.get());
                    g.add(new Label("" + rep.get(serveur).get(0)) , 1 , nb.get());
                    g.add(new Label("" + rep.get(serveur).get(1)) , 2 , nb.getAndIncrement());
                }
            }
        });
        return jButon;
    }

    public static HashMap<Serveur,ArrayList<Integer>> getAll(Date dateF, Date dateT) {
        ConnectionSingleton cs = ConnectionSingleton.getInstance();
        Connection c = cs.getConnection();
        HashMap<Serveur,ArrayList<Integer>> resultat = new HashMap<>();
        ArrayList<String> listNom = new ArrayList<>();
        new Question1();
        try {
            PreparedStatement ps1 = c.prepareStatement("SELECT count(numTable), sum(MontantTotal) as x, nom From Serveur inner join affecter on numServeur = numserv inner join Commande " +
                    " on numTable = numTab where dateCommande between ? and ? group by nom having sum(MontantTotal) > 0 order by x");
            ps1.setDate(1, dateF);
            ps1.setDate(2, dateT);
            ResultSet res = ps1.executeQuery();

            while (res.next()) {
                int nbR = res.getInt(1);
                int chiffreA = res.getInt(2);
                Serveur s = new Serveur("x",res.getString(3),"x","x");
                    resultat.put(s, new ArrayList<Integer>() {{
                        add(nbR);
                        add(chiffreA);
                    }});
                }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultat;
    }
}