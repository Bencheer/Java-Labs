package auth;

import jdbc.Jdbc;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by CM on 30.10.2014.
 */
public class Authorise extends HttpServlet {
    @Override
    public void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String login = req.getParameter("login");
        String password = req.getParameter("password");

        Jdbc user = new Jdbc();
        if (user.loginInProjec(login, password, req.getRequestedSessionId())) {
            Cookie coockie = new Cookie("uid", req.getRequestedSessionId().substring(0, 29));
            coockie.setMaxAge(7 * 24 * 60 * 60);
            resp.addCookie(coockie);

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
    }
}
