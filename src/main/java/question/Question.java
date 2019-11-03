package question;

import metier.Afficher;
import java.util.List;

public interface Question<T extends Afficher> {

    String[] getMainAff();

    String[] getPrimary();

    List<T> getInfos();
}
