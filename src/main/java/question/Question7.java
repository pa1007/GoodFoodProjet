package question;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.ColumnConstraints;
import javafx.scene.layout.GridPane;

public class Question7 implements Question {

    @Override
    public Node[] waitInfo() {
        String   calcA = createdPLA();
        String   calcb = createdPLB();
        Label    lx    = new Label("Question 7a )");
        TextArea tx    = new TextArea(calcA);
        tx.setPrefSize(480, 600);
        tx.setEditable(false);
        Label    lx2 = new Label("Question 7b )");
        TextArea tx2 = new TextArea(calcb);
        tx2.setPrefSize(200, 600);
        tx2.setEditable(false);
        return new Node[]{lx, tx, lx2, tx2};
    }

    @Override
    public Button ask(GridPane t, int start) {
        t.getColumnConstraints().clear();
        t.getColumnConstraints().add(new ColumnConstraints(900));
        t.setHgap(1);
        return null;
    }

    private String createdPLB() {
        return "create or replace trigger quantitePlat\n"
               + "    before insert\n"
               + "    on contient\n"
               + "    for each row\n"
               + "declare\n"
               + "    nbP int ;\n"
               + "    nbQ int ;\n"
               + "    rCon contient%rowtype;\n"
               + "    idCom contient.NumCommande%type;\n"
               + "    TO_MUCH_QUANTITY_EXCEPTION exception;\n"
               + "begin\n"
               + "    rCon = : new;\n"
               + "    idCom = rCon.NumCommande;\n"
               + "    select NumCommande, sum(quantite) into nbQ from contient where NumCommande = idCom group by NumCommande;\n"
               + "    select NbPersonne into nbP from Commande where NumCommande = idCom;\n"
               + "    if nbQ > nbP then\n"
               + "        raise TO_MUCH_QUANTITY_EXCEPTION;\n"
               + "    end if;\n"
               + "end;";
    }

    private String createdPLA() {
        return "create or replace trigger ENR\n"
               + "    before insert\n"
               + "    on Commande\n"
               + "    for each row\n"
               + "declare\n"
               + "    gradeR int ;\n"
               + "    mont decimal;\n"
               + "    tRow Commande%rowtype;\n"
               + "    CURSOR calcMontant(id int) is select quantite, P.prix\n"
               + "    from contient inner join Plat P on contient.idPlat = P.idPlat\n"
               + "    where NumCommande = id;\n"
               + "begin\n"
               + "    tRow = :new;\n"
               + "    select grade into gradeR from Serveur inner join affecter on numserv = numServeur where numTab = tRow.numTable;\n"
               + "    if gradeR = 'maitre d''hotel' then\n"
               + "        if tRow.MontantTotal = 0 then\n"
               + "            for var in calcMontant(tRow.NumCommande) loop\n"
               + "                mont = var.prix * var.quantite;\n"
               + "            end loop;\n"
               + "            else\n"
               + "                mont = tRow.MontantTotal;\n"
               + "        end if;\n"
               + "        if mont / tRow.NbPersonne < 15 then\n"
               + "            insert into auditer\n"
               + "            values (tRow.NumCommande, tRow.numTable, tRow.dateCommande, tRow.NbPersonne, tRow.dateEncaissement,\n"
               + "                    tRow.MontantTotal);\n"
               + "        end if;\n"
               + "    end if;\n"
               + "end ;";
    }
}
