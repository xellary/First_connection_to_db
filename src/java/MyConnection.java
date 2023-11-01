import java.sql.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MyConnection {

    private static final String DB_USERNAME = "postgres";
    private static final String DB_PASSWORD = "postgres";
    private static final String DB_URL = "jdbc:postgresql://localhost:5432/training_hw_5";

    public Map<String, List<String>> executeSelect(String select) {
        try (
                Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
                Statement statement = connection.createStatement()
        ) {
            ResultSet result = statement.executeQuery(select);
            Map<String, List<String>> obj = new HashMap<>();
            while (result.next()) {
                obj.put(result.getString(1), List.of(result.getString(2), result.getString(3)));
            }
            return obj;
        } catch (SQLException ex) {
            System.out.println("Cannot connect tot DB: " + ex.getMessage());
            return Map.of();
        }
    }

    public List<String> selectColumnsNames(String select) {
        try (
                Connection connection = DriverManager.getConnection(DB_URL, DB_USERNAME, DB_PASSWORD);
                Statement statement = connection.createStatement()
        ) {
            ResultSet result = statement.executeQuery(select);
            List<String> columnsNames = new ArrayList<>();

            int columnsNumber = result.getMetaData().getColumnCount();
            for (int i = 1; i <= columnsNumber; i++) {
                columnsNames.add(result.getMetaData().getColumnName(i));
            }
            return columnsNames;
        } catch (SQLException ex) {
            System.out.println("Cannot connect tot DB: " + ex.getMessage());
            return null;
        }
    }
}
