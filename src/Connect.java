import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class Connect {
    private final String url = "jdbc:postgresql://localhost:5432/";
    private final String user = "postgres";
    private final String password = "123";

    public Connection connect() {
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, user, password);
            System.out.println("Connected successfully to database");
        } catch (SQLException e) {
            System.out.println(e.getMessage());
        }
        return conn;
    }

    // 1. Создание нового склада
    public void insertWarehouse(Warehouse warehouse) {
        String SQL = "INSERT INTO \"it-academy\".warehouses" +
                " (address, name_of_products, quantity)" +
                " VALUES (?, ?, ?); ";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(SQL)) {
            stmt.setString(2, warehouse.getName_of_products());
            stmt.setInt(3, warehouse.getQuantity());
            stmt.executeQuery();
            ResultSet rs = stmt.getResultSet();
            rs.next();
            System.out.println("New warehouse is successfully created");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //4. Удаление товара по названию
    public void deleteProduct(Warehouse warehouse) {
        String SQL = "DELETE FROM \"it-academy\".warehouses" +
                "set name = ?";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(SQL)) {
            stmt.setString(2, warehouse.getName_of_products());
            stmt.executeQuery();
            ResultSet rs = stmt.getResultSet();
            rs.next();
            System.out.println("Product is successfully deleted");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    //5. Удаление склада
    public void deleteWarehouse(Warehouse warehouse) {
        String SQL = "DELETE FROM \"it-academy\".warehouses" +
                " (address, name_of_products, quantity)" +
                " VALUES (?, ?, ?); ";
        try (Connection conn = connect();
             PreparedStatement stmt = conn.prepareStatement(SQL)) {
            stmt.setString(2, warehouse.getName_of_products());
            stmt.setInt(3, warehouse.getQuantity());
            stmt.executeQuery();
            ResultSet rs = stmt.getResultSet();
            rs.next();
            System.out.println("Warehouse is successfully deleted");
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}