package jdbc;

import java.sql.Connection;
import java.sql.DriverManager;

/**
 * Created by CM on 15.11.2014.
 */
public class ConntecToDb {
    public Connection createConnection() {
        try {
            Class.forName("com.mysql.jdbc.Driver");
            Connection conn = null;
            conn = DriverManager.getConnection("jdbc:mysql://localhost/jdbc", "root", "");
            return conn;
        } catch (Exception e) {
            System.out.println("SQLException: " + e.getMessage());
            return null;
        }
    }
}
