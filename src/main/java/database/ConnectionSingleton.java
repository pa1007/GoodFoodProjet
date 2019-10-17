package database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;


public class ConnectionSingleton {

    private static ConnectionSingleton s;
    private        Connection          c;

    private ConnectionSingleton() {
        try {
            String url = "jdbc:mysql://pa1007.fr/GoodFood";
            c = DriverManager.getConnection(url, "goodFoodAdmin", "as5Y4xSevzVLRFM4");
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
    }

    public Connection getConnection() {
        return c;
    }

    public static ConnectionSingleton getInstance() {
        if (s == null) {
            s = new ConnectionSingleton();
        }
        else {
            try {
                if (s.c != null && s.c.isClosed()) {
                    s = new ConnectionSingleton();
                }
            }
            catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return s;
    }
}
