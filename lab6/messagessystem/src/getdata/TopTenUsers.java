package getdata;

import checksession.CheckSession;
import jdbc.Jdbc;

import org.json.simple.JSONArray;
import org.json.simple.JSONObject;
import org.json.simple.JSONValue;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.*;

/**
 * Created by CM on 02.11.2014.
 */
public class TopTenUsers extends HttpServlet {

    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (CheckSession.isSetSesion(req.getCookies())) {
            Jdbc getDate = new Jdbc();
            ArrayList<String[]> listUser = getDate.getTopTenUsers();

            Map m1 = new LinkedHashMap();

            Map fam = new LinkedHashMap();
            Map name = new LinkedHashMap();
            Map login = new LinkedHashMap();
            Map time = new LinkedHashMap();

            List l1 = new LinkedList();

            m1.put("success","1");

            JSONArray arrToret = new JSONArray();
            arrToret.add(1);

            for (int i = 0; i < listUser.size(); i++) {
                for (int j = 0; j < listUser.get(i).length; j++) {
                    if (listUser.get(i)[j] != null) {
                        if (i == 0) {
                            fam.put(j, listUser.get(i)[j]);
                        }
                        if (i == 1) {
                            name.put(j, listUser.get(i)[j]);
                        }
                        if (i == 2) {
                            login.put(j, listUser.get(i)[j]);
                        }
                        if (i == 3) {
                            time.put(j, listUser.get(i)[j]);
                        }
                    } else {
                        break;
                    }
                }
            }

            l1.add(m1);
            l1.add(fam);
            l1.add(name);
            l1.add(login);
            l1.add(time);
            String jsonString = JSONValue.toJSONString(l1);

            resp.setContentType("application/json");
            PrintWriter out = resp.getWriter();
            out.print(jsonString);
            out.flush();
        } else {
            Map m1 = new LinkedHashMap();
            List l1 = new LinkedList();

            m1.put("success","0");
            String jsonString = JSONValue.toJSONString(l1);

            resp.setContentType("application/json");
            PrintWriter out = resp.getWriter();
            out.print(jsonString);
            out.flush();
        }
    }
}
