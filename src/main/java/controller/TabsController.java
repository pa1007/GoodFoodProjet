package controller;

import dao.*;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import metier.Afficher;
import question.*;
import java.util.List;

@SuppressWarnings("unchecked")
public class TabsController {

    @FXML
    public  TabPane    tPane;
    private DAO[]      daos;
    private Question[] questions;

    @FXML
    private void initialize() {
        daos = new DAO[]{
                new TypePlatDAO(),
                new RestaurantDAO(),
                new AffecterDAO(),
                new CommandeDAO(),
                new ContientDAO(),
                new PlatDAO(),
                new SalleDAO(),
                new ServeurDAO(),
                new TableDAO()
        };
        for (DAO d : daos) {
            Tab t = new Tab();
            tPane.getTabs().add(t);
            t.setClosable(false);
            t.setText(d.getClass().getSimpleName().replace("DAO", ""));
            GridPane g  = new GridPane();
            GridPane g2 = new GridPane();
            g.add(g2, 0, 0);
            g.setVgap(12);
            t.setContent(g);
            g.getColumnConstraints().add(new ColumnConstraints(400));
            List<Afficher> typePlats = d.getAll();
            for (Afficher typePlat : typePlats) {
                g.add(new Label("" + typePlat.getInfo(d.getMainAff())), 0, typePlats.indexOf(typePlat));
                g.add(new Label(typePlat.getInfo(d.getPrimary())), 1, typePlats.indexOf(typePlat));
            }
        }
        questions = new Question[]{new Question1(), new Question2(), new Question3(), new Question6()};
        for (Question q : questions) {
            Tab t = new Tab();
            tPane.getTabs().add(t);
            t.setClosable(false);
            t.setText(q.getClass().getSimpleName());

            GridPane g = new GridPane();
            g.setVgap(12);
            t.setContent(g);
            g.getColumnConstraints().add(new ColumnConstraints(400));
            int i = 0;
            for (Node c : q.waitInfo()) {
                g.add(c, 0, i);
                i++;
            }

            g.add(q.ask(g, i + 1), 0, i++);

        }
    }
}
