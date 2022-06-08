package pizza;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

public class PizzaDAO {

    private String url;

    public PizzaDAO() {
        try {
            Class.forName("org.sqlite.JDBC");
            this.url = "jdbc:sqlite:datenbank.db";
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    public Pizza findById(int id) {
        try {
            Connection conn = DriverManager.getConnection(url);
            String sql = "select * from pizza where id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            ResultSet rs = statement.executeQuery();
            rs.next();
            String name = rs.getString("name");
            String beschreibung = rs.getString("beschreibung");
            Pizza gesuchtePizza = new Pizza(id, name, beschreibung);
            conn.close();
            return gesuchtePizza;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }

    public void update(Pizza toChange) {
        try {
            Connection conn = DriverManager.getConnection(url);
            String sql = "update pizza set name=?, beschreibung=? where id=?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, toChange.getName());
            statement.setString(2, toChange.getBeschreibung());
            statement.setInt(3, toChange.getId());
            statement.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    public void save(Pizza toChange) {
        try {
            Connection conn = DriverManager.getConnection(url);
            String sql = "insert into pizza (name, beschreibung) VALUES (?, ?)";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setString(1, toChange.getName());
            statement.setString(2, toChange.getBeschreibung());
            statement.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void delete(int id) {
        try {
            Connection conn = DriverManager.getConnection(url);
            String sql = "delete from pizza where id = ?";
            PreparedStatement statement = conn.prepareStatement(sql);
            statement.setInt(1, id);
            statement.executeUpdate();
            conn.close();
        } catch (Exception e) {
            e.printStackTrace();
        }


    }
}
