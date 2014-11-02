package checksession;

import javax.servlet.http.Cookie;
import java.sql.*;

/**
 * Created by CM on 02.11.2014.
 */
public class CheckSession {
    public static boolean isSetSesion(Cookie[] coockie) {
        Connection conn;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection("jdbc:mysql://localhost/jdbc", "root", "");
        } catch (Exception e) {
            System.out.println("SQLException: " + e.getMessage());
            return false;
        }

        String userId = null;
        if (coockie != null) {
            for (Cookie cock : coockie) {
                if ("uid".equals(cock.getName())) {
                    userId = cock.getValue();
                }
            }
        }

        if (userId == null) {
            return false;
        } else {
            try {
                Statement snmt = conn.createStatement();
                String query = "SELECT * FROM users_online WHERE secretKey = '" + userId.substring(0, 29) + "'";
                ResultSet res = snmt.executeQuery(query);
                Integer countR = 0;

                while (res.next()) {
                    countR++;
                }

                if (countR.equals(1)) {
                    query = "UPDATE users_online SET time = NULL WHERE secretKey = '" + userId.substring(0, 29) + "'";
                    snmt.executeUpdate(query);
                    return true;
                } else {
                    System.out.println("SESSION " + userId);
                    query = "DELETE FROM users_online WHERE secretKey = '" + userId.substring(0, 29) + "'";
                    snmt.executeUpdate(query);
                    return false;
                }
            } catch (SQLException e) {
                e.printStackTrace();
                return false;
            }
        }
    }
}
