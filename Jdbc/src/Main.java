import java.sql.*;

public class Main {
    public static void main(String[] args) throws SQLException {
        String url = "jdbc:mysql://localhost:3306/jocata";
        String user = "root";
        String password = "21491A1289";

            Connection conn = DriverManager.getConnection(url, user, password);
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery("SELECT * FROM student");
           Integer value = stmt.executeUpdate("INSERT INTO STUDENT VALUES(106);");


            while (rs.next()) {
                System.out.println("Column 1: " + rs.getString(1));
            }

        }
    }

