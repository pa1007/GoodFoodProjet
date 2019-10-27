package dao;

import metier.Afficher;
import java.util.List;

public interface DAO<T extends Afficher, K> {

    List<T> getAll();

    T find(K id);
}
