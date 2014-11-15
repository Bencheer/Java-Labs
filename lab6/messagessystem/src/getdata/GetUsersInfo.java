package getdata;

import checksession.CheckSession;
import jdbc.ConntecToDb;
import org.json.simple.JSONArray;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import java.sql.*;
import java.util.ArrayList;

/**
 * Created by CM on 03.11.2014.
 */
public class GetUsersInfo extends HttpServlet{
    public static String ID = null;
    public static String name = null;
    public static String fam = null;
    public static String login = null;

    public static ArrayList<String> getInfo(Cookie[] coockie) {
        Connection conn = null;
        if (CheckSession.isSetSesion(coockie)) {
            conn = new ConntecToDb().createConnection();

            String userId = null;
            if (coockie != null) {
                for (Cookie cock : coockie) {
                    if ("uid".equals(cock.getName())) {
                        userId = cock.getValue();
                    }
                }
            }

            if (userId == null) {
                return null;
            } else {
                try {
                    Statement snmt = conn.createStatement();
                    String query = "SELECT users.id as id, users.fam as fam, users.name as name, users.login as login FROM users, users_online WHERE users.id = users_online.id_user AND users_online.secretKey = '" + userId  + "'";
                    ResultSet resS = snmt.executeQuery(query);

                    int count = 0;
                    ArrayList<String> retS = new ArrayList<String>();
                    Integer id_ = null;
                    String fam_ = null;
                    String name_ = null;
                    String login_ = null;
                    while (resS.next()) {
                        id_ = resS.getInt("id");
                        fam_ = resS.getString("fam");
                        name_ = resS.getString("name");
                        login_ = resS.getString("login");
                    }

                    ID = id_.toString();
                    name = name_;
                    fam = fam_;
                    login = login_;

                    retS.add(id_.toString());
                    retS.add( fam_);
                    retS.add(name_);
                    retS.add(login_);

                    return retS;
                } catch (SQLException e) {
                    e.printStackTrace();
                    return null;
                }

            }
        } else {
            return null;
        }
    }

    public static String getId () {
        return ID;
    }

    public static String getName () {
        return name;
    }

    public static String getFam () {
        return fam;
    }

    public static String getLogin () {
        return login;
    }
}
