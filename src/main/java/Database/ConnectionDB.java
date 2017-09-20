package Database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

public class ConnectionDB {
    final static String DATA_BASE_NAME = "Nash";
    public static void main(String[] args) throws SQLException {

    }

    public static Connection getConnection() throws SQLException {
        Connection conn = DriverManager.getConnection("jdbc:mysql://localhost:3306/"+DATA_BASE_NAME,
                "root", "coderslab");
        Statement stmt = conn.createStatement();
        //stmt.execute();
        return conn;
    }
}
