package getdata;

import checksession.CheckSession;
import jdbc.Jdbc;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

/**
 * Created by CM on 03.11.2014.
 */
public class CountUsers extends HttpServlet {
    public static Integer getCountUsers(Cookie[] coockies) {
        if (CheckSession.isSetSesion(coockies)) {
            Jdbc getCU = new Jdbc();
            Integer a = getCU.getCountsUsers();
            return a;
        } else {
            return null;
        }
    }
}
