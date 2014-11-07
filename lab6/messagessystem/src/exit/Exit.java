package exit;

import checksession.CheckSession;
import jdbc.Jdbc;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.security.NoSuchAlgorithmException;
import java.sql.*;

/**
 * Created by CM on 31.10.2014.
 */
public class Exit extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");


        try {
            if (CheckSession.isSetSesion(req.getCookies())) {

                Connection conn = null;
                try {
                    Class.forName("com.mysql.jdbc.Driver");
                    conn = DriverManager.getConnection("jdbc:mysql://localhost/jdbc", "root", "");
                } catch (Exception e) {
                    System.out.println("SQLException: " + e.getMessage());
                }

                Cookie[] coockie = req.getCookies();
                String userId = null;
                if (coockie != null) {
                    for (Cookie cock : coockie) {
                        if ("uid".equals(cock.getName())) {
                            userId = cock.getValue();
                        }
                    }
                }

                Statement snmt = conn.createStatement();
                String query = "DELETE FROM users_online WHERE secretKey = '" + userId + "'";
                snmt.executeUpdate(query);

                Cookie[] cock = req.getCookies();
                if (cock != null) {
                    for (int i = 0; i < cock.length; i++) {
                        cock[i].setValue("");
                        cock[i].setMaxAge(0);
                        resp.addCookie(cock[i]);
                    }
                }

                conn.close();
                resp.setContentType("application/json");
                PrintWriter out = resp.getWriter();
                out.print("{\"success\" : 1}");
                out.flush();
            } else {
                resp.setContentType("application/json");
                PrintWriter out = resp.getWriter();
                out.print("{\"success\" : 0}");
                out.flush();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
