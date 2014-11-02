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
            String[] listUser = getDate.getTopTenUsers();

            Map m1 = new LinkedHashMap();
            Map m2 = new HashMap();
            List l1 = new LinkedList();

            m1.put("success","1");

            JSONArray arrToret = new JSONArray();
            arrToret.add(1);

            String jsonData = "";
            for (int i = 0; i < listUser.length; i++) {
                if (listUser[i] != null) {
                    jsonData += listUser[i] + "<br>";
                }
            }

            m2.put("topUp", jsonData);
            l1.add(m1);
            l1.add(m2);
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
