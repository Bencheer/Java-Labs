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
 * Created by CM on 03.11.2014.
 */
public class GetMessages extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (CheckSession.isSetSesion(req.getCookies())) {
            Jdbc getDate = new Jdbc();
            ArrayList<ArrayList<String>> listMessages = getDate.getAllMessages(Integer.parseInt(req.getParameter("lastId")));
            if (listMessages.get(0).get(0) == null) {
                Map m1 = new LinkedHashMap();
                List l1 = new LinkedList();

                m1.put("success","0");
                l1.add(m1);
                String jsonString = JSONValue.toJSONString(l1);

                resp.setContentType("application/json");
                PrintWriter out = resp.getWriter();
                out.print(jsonString);
                out.flush();
            } else {
                Map m1 = new LinkedHashMap();

                List l1 = new LinkedList();

                m1.put("success", 1);

                JSONArray a = new JSONArray();

                for (int i = 0; i < listMessages.get(0).size(); i++) {
                    LinkedHashMap messParam = new LinkedHashMap();
                    messParam.put("name" , listMessages.get(0).get(i));
                    System.out.println(listMessages.get(0).get(i));
                    messParam.put("fam", listMessages.get(1).get(i));
                    messParam.put("mid" , listMessages.get(2).get(i));
                    messParam.put("iduser" , listMessages.get(3).get(i));
                    messParam.put("text" , listMessages.get(4).get(i));
                    messParam.put("time" , listMessages.get(5).get(i));
                    a.add(messParam);
                }

                a.add(m1);

                //String jsonString = JSONValue.toJSONString(l1);
                //a.add(l1);

                resp.setContentType("application/json");
                PrintWriter out = resp.getWriter();
                out.print(a);
                out.flush();
            }
        } else {
            Map m1 = new LinkedHashMap();
            List l1 = new LinkedList();

            m1.put("success","0");
            l1.add(m1);
            String jsonString = JSONValue.toJSONString(l1);

            resp.setContentType("application/json");
            PrintWriter out = resp.getWriter();
            out.print(jsonString);
            out.flush();
        }
    }
}
