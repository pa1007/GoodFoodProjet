package controller;

import dao.TypePlatDAO;
import metier.TypePlat;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.layout.GridPane;

import java.util.ArrayList;

public class TypePlatController {

    @FXML
    GridPane GP_Layout;

    @FXML
    private void initialize()
    {
        TypePlatDAO typePlatDAO = new TypePlatDAO();
        ArrayList<TypePlat> typePlats = (ArrayList<TypePlat>) typePlatDAO.getAll();
        for (TypePlat typePlat: typePlats
             ) {
            GP_Layout.add(new Label(""+typePlat.getNumTypePlat()), 0, typePlats.indexOf(typePlat));
            GP_Layout.add(new Label(typePlat.getNomTypePlat()), 1, typePlats.indexOf(typePlat));
        }
    }
}
