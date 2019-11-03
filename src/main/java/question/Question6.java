package question;

import dao.CommandeDAO;
import database.ConnectionSingleton;
import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import metier.Commande;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class Question6 implements Question {

    private TextField textF;

    @Override
    public Node[] waitInfo() {
        this.textF = new TextField();
        return new Node[]{textF};
    }

    @Override
    public Button ask(GridPane t, int start) {
        Button b = new Button("Valider");

        b.setOnAction(event -> {
            Commande c = null;
            try {
                c = calc(textF.getText());
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
            if (c == null) {
                t.add(new TextField("Not found !"), 1, start);
            }
            else {
                t.add(new TextField("Commande "
                                    + c.getNumCommande()
                                    + " Mise a jour avec le montant "
                                    + c.getMontantTotal()), 0, start);
            }
        });

        return b;
    }

    public Commande calc(String numCommande) throws SQLException {
        Connection conn = ConnectionSingleton.getInstance().getConnection();
        if (!numCommande.isEmpty()) {
            PreparedStatement ps = conn.prepareStatement(
                    "select quantite, P.prix from contient inner join Plat P on contient.idPlat = P.idPlat where NumCommande = ?");
            ps.setString(1, numCommande);
            ResultSet rs = ps.executeQuery();
            double    r  = 0;
            while (rs.next()) {
                r += rs.getDouble(1) * rs.getDouble(2);
            }
            PreparedStatement comPS =
                    conn.prepareStatement("update Commande set MontantTotal = ? where NumCommande = ?");
            comPS.setDouble(1, r);
            comPS.setString(2, numCommande);
            comPS.executeUpdate();
            return new CommandeDAO().find(numCommande);
        }

        return null;
    }
}
