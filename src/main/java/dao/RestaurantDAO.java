package dao;

import database.ConnectionSingleton;
import metier.Restaurant;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class RestaurantDAO implements DAO<Restaurant, String> {

    @Override
    public List<Restaurant> getAll() {
        ConnectionSingleton cs          = database.ConnectionSingleton.getInstance();
        Connection          c           = cs.getConnection();
        List<Restaurant>    restaurants = new ArrayList<>();
        try {
            PreparedStatement ps  = c.prepareStatement("SELECT * from Restaurant");
            ResultSet         res = ps.executeQuery();
            while (res.next()) {
                restaurants.add(new Restaurant(res.getString("numRestaurant"), res.getString("Nom")));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return restaurants;
    }

    @Override
    public Restaurant find(String id) {
        ConnectionSingleton cs         = ConnectionSingleton.getInstance();
        Connection          c          = cs.getConnection();
        Restaurant          restaurant = null;
        try {
            PreparedStatement ps =
                    c.prepareStatement("SELECT numrestaurant, nom  FROM Restaurant WHERE numRestaurant=?");
            ps.setString(1, id);
            ResultSet res = ps.executeQuery();
            if (res.first()) {
                restaurant = new Restaurant(res.getString(1), res.getString(2));
            }
        }
        catch (SQLException e) {
            e.printStackTrace();
        }
        return restaurant;
    }

    @Override
    public String[] getPrimary() {
        return new String[]{"numRestaurant"};
    }

    @Override
    public String[] getMainAff() {
        return new String[]{"ALL"};
    }
}
