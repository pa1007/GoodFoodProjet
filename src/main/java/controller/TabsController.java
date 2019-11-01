package controller;

import dao.DAO;
import dao.RestaurantDAO;
import dao.TypePlatDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.Tab;
import javafx.scene.control.TabPane;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;
import metier.Afficher;
import java.util.List;

@SuppressWarnings("unchecked")
public class TabsController {

    @FXML
    public  TabPane tPane;
    private DAO[]   daos;

    @FXML
    private void initialize() {
        daos = new DAO[]{new TypePlatDAO(), new RestaurantDAO()};
        for (DAO d : daos) {
            Tab t = new Tab();
            tPane.getTabs().add(t);
            t.setText(d.getClass().getSimpleName().replace("DAO", ""));
            GridPane g  = new GridPane();
            GridPane g2 = new GridPane();
            g.add(g2, 0, 0);
            g.setVgap(12);
            t.setContent(g);
            g.getColumnConstraints().add(new ColumnConstraints(400));
            List<Afficher> typePlats = d.getAll();
            for (Afficher typePlat : typePlats) {
                g.add(new Label("" + typePlat.getInfo("ALL")), 0, typePlats.indexOf(typePlat));
                g.add(new Label(typePlat.getInfo(d.getPrimary())), 1, typePlats.indexOf(typePlat));
            }
        }
    }
}
