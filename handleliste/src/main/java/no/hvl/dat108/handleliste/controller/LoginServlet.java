package no.hvl.dat108.handleliste.controller;

import no.hvl.dat108.handleliste.Handleliste.Loc;
import no.hvl.dat108.handleliste.Handleliste.UrlPattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends HttpServlet {

    private static String HANDLELISTE_PASSORD;

    @Override
    public void init() throws ServletException {
        HANDLELISTE_PASSORD = getInitParameter("passord");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String password = request.getParameter("password");
        HttpSession session = request.getSession(false);
        session.invalidate();
        session = request.getSession(true);

        if (!password.equals(HANDLELISTE_PASSORD)) {
            session.setAttribute("message", Loc.WRONG_PASSWORD);
            response.sendRedirect(UrlPattern.LOGIN);
            return;
        }

        session.setAttribute("user", new Object());
        response.sendRedirect(UrlPattern.HANDLELISTE);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/login.jsp");
        dispatcher.forward(request, response);
    }
}
