package id.app.Controller;

import id.app.Data.Foods;
import id.app.Connector.DatabaseConnector;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class FoodsController {
    private static List<Foods> foodsDatabase = new ArrayList<>();

    public static void loadAllFoods() {
        String sql = "SELECT * FROM foods";
        try (Connection conn = DatabaseConnector.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql);
             ResultSet rs = pstmt.executeQuery()) {

            while (rs.next()) {
                int id = rs.getInt("id");
                String name = rs.getString("name");
                int provinsiId = rs.getInt("provinsi_id");
                String asal = rs.getString("asal");
                String deskripsi = rs.getString("deskripsi");

                Foods food = new Foods(provinsiId, name, asal, deskripsi);
                foodsDatabase.add(food);
            }
            System.out.println("Foods loaded from database: " + foodsDatabase.size()); // Debug log
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static String getProvinsiNameById(int provinsiId) {
        String provinsiName = null;
        String sql = "SELECT name FROM provinsi WHERE id=?";
        try (Connection conn = DatabaseConnector.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setInt(1, provinsiId);
            ResultSet rs = pstmt.executeQuery();
            if (rs.next()) {
                provinsiName = rs.getString("name");
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return provinsiName;
    }

    public static Foods getProvinsi(String asal) {
        Foods food = null;
        String sql = "SELECT * FROM foods WHERE asal=?";
        try (Connection conn = DatabaseConnector.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, asal);
            ResultSet rse = pstmt.executeQuery();
            while (rse.next()) {
                String name = rse.getString("name");
                int id = rse.getInt("id");
                int provinsiId = rse.getInt("provinsi_id");
                String deskripsi = rse.getString("deskripsi");
                food = new Foods(provinsiId, name, asal, deskripsi);
            }
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return food;
    }

    public static List<Foods> getFoodsByProvinsiId(int provinsiId) {
        List<Foods> foodsByProvinsiId = new ArrayList<>();
        for (Foods food : foodsDatabase) {
            if (food.getProvinsiId() == provinsiId) {
                foodsByProvinsiId.add(food);
            }
        }
        return foodsByProvinsiId;
    }

    public static Foods getFoodById(String name) {
        for (Foods food : foodsDatabase) {
            if (food.getNama().equals(name)) {
                return food;
            }
        }
        return null;
    }

    public static void addFood(Foods food) {
        String sql = "INSERT INTO foods (name, provinsi_id, asal, deskripsi) VALUES (?, ?, ?, ?)";
        try (Connection conn = DatabaseConnector.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, food.getNama());
            pstmt.setInt(2, food.getProvinsiId());
            pstmt.setString(3, food.getAsal());
            pstmt.setString(4, food.getDeskripsi());
            pstmt.executeUpdate();
            foodsDatabase.add(food);
            System.out.println("Food added to database: " + food.getNama()); // Debug log
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void updateFood(Foods food) {
        String sql = "UPDATE foods SET name=?, asal=?, deskripsi=? WHERE provinsi_id=?";
        try (Connection conn = DatabaseConnector.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, food.getNama());
            pstmt.setString(2, food.getAsal());
            pstmt.setString(3, food.getDeskripsi());
            pstmt.setInt(4, food.getProvinsiId());
            pstmt.executeUpdate();
            System.out.println("Food updated in database: " + food.getNama()); // Debug log
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }

    public static void deleteFood(Foods food) {
        String sql = "DELETE FROM foods WHERE name=?";
        try (Connection conn = DatabaseConnector.connect();
             PreparedStatement pstmt = conn.prepareStatement(sql)) {
            pstmt.setString(1, food.getNama());
            pstmt.executeUpdate();
            foodsDatabase.remove(food);
            System.out.println("Food deleted from database: " + food.getNama()); // Debug log
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}
