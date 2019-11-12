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
import java.util.List;
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
            PreparedStatement ps = c.prepareStatement("SELECT numTable FROM Commande where DATEDIFF(?,dateCommande) < 0 AND DATEDIFF(dateCommande,?) < 0");
            PreparedStatement ps2 = c.prepareStatement("SELECT numserv From affecter where numTab = ?");
            PreparedStatement ps3 = c.prepareStatement("SELECT nom From Serveur where numServeur = ?");
            PreparedStatement ps4 = c.prepareStatement("SELECT count(*), Sum(MontantTotal) as somme, nom From Serveur inner join affecter inner join Commande where nom = ? and DATEDIFF(?,dateCommande) < 0 AND DATEDIFF(dateCommande,?) < 0 and MontantTotal > 0 order by somme ASC");
            ps.setDate(1, dateF);
            ps.setDate(2, dateT);
            ResultSet res = ps.executeQuery();

            while (res.next()) {
                ps2.setString(1, res.getString(1));
                ResultSet res2 = ps2.executeQuery();

                while (res2.next()) {
                    String numS = res2.getString(1);
                    ps3.setString(1, numS);

                    ResultSet res3 = ps3.executeQuery();
                    while (res3.next()) {
                        String nom = res3.getString(1);

                        if(!listNom.contains(nom)){
                            listNom.add(nom);
                        }else{
                            nom = "nada";
                        }

                        ps4.setString(1, nom);
                        ps4.setDate(2, dateF);
                        ps4.setDate(3, dateT);
                        ResultSet res4 = ps4.executeQuery();

                        while (res4.next()) {
                            int nbR = res4.getInt(1);
                            int chiffreA = res4.getInt(2);
                            Serveur s = new Serveur("x",res4.getString(3),"x","x");
                            if(nbR > 0) {
                                resultat.put(s, new ArrayList<Integer>() {{
                                    add(nbR);
                                    add(chiffreA);
                                }});
                            }
                        }
                    }
                }
            }
            c.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultat;
    }
}