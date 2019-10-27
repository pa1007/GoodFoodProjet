package controller;

import dao.DAO;
import dao.TypePlatDAO;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;
import metier.Afficher;
import java.util.List;

public class TypePlatController {

    @FXML
    GridPane GP_Layout;
    private DAO[] daos;

    @FXML
    private void initialize() {
        daos = new DAO[]{new TypePlatDAO()};
        for (DAO d : daos) {
            List<Afficher> typePlats = d.getAll();
            for (Afficher typePlat : typePlats) {
                GP_Layout.add(new Label("" + typePlat.getAffString()), 0, typePlats.indexOf(typePlat));
                GP_Layout.add(new Label(typePlat.getAffString()), 1, typePlats.indexOf(typePlat));
            }
        }
    }
}
