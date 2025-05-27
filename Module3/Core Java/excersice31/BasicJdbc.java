import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class BasicJdbc {
    public static void main(String[] args) {
        // JDBC URL, username, and password of MySQL server
        String url = "jdbc:mysql://localhost:3306/school";
        String user = "root";
        String password = "your_password";

        try {
            // Register JDBC driver
            Class.forName("com.mysql.cj.jdbc.Driver");

            // Open a connection and create statement using try-with-resources
            System.out.println("Connecting to database...");
            String sql = "SELECT * FROM students";
            try (Connection conn = DriverManager.getConnection(url, user, password);
                 Statement stmt = conn.createStatement();
                 ResultSet rs = stmt.executeQuery(sql)) {

                // Process the results
                System.out.println("\nStudent Records:");
                System.out.println("ID\tName\t\tAge");
                System.out.println("------------------------");
                while (rs.next()) {
                    int id = rs.getInt("id");
                    String name = rs.getString("name");
                    int age = rs.getInt("age");
                    System.out.println(id + "\t" + name + "\t\t" + age);
                }
            }
        } catch (ClassNotFoundException | java.sql.SQLException e) {
            System.out.println(e.getMessage());
        }
    }
}