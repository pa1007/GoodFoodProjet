package question;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;

public interface Question {

    Node[] waitInfo();

    Button ask(GridPane t, int start);
}
