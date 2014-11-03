package getdata;

import checksession.CheckSession;
import jdbc.Jdbc;
import org.json.simple.JSONArray;
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
public class SendMessage extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (CheckSession.isSetSesion(req.getCookies())) {
            Jdbc addMess = new Jdbc();

            addMess.addNewMessage(req.getParameter("text"), Integer.parseInt(GetUsersInfo.getId()));

            System.out.println(req.getParameter("text"));

            Map m1 = new LinkedHashMap();
            List l1 = new LinkedList();

            m1.put("success","1");
            l1.add(m1);
            String jsonString = JSONValue.toJSONString(l1);

            resp.setContentType("application/json");
            PrintWriter out = resp.getWriter();
            out.print(jsonString);
            out.flush();

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
