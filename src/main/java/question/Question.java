package question;

import javafx.scene.Node;
import javafx.scene.control.Button;
import javafx.scene.layout.GridPane;
import java.util.concurrent.atomic.AtomicInteger;

public interface Question {

    Node[] waitInfo();

    Button ask(GridPane t, AtomicInteger start);
}
