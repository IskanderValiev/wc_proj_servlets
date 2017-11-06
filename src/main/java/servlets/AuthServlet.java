package servlets;

import cookies.Cookies;
import cookies.CookiesImpl;
import sessions.Sessions;
import sessions.SessionsImpl;

import javax.servlet.ServletException;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class AuthServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Cookies cookies = new CookiesImpl();
        Cookie cookie = cookies.getCookie("login", req, resp);

        Sessions sessions = new SessionsImpl();
        sessions.getSession("login", req);
        if (!"guest".equals(cookie.getValue()) || !"".equals(sessions.getSession("login", req))) {
            resp.sendRedirect("/profile");
        } else {
            resp.sendRedirect("/worldcup/index.jsp");
        }
    }
}
