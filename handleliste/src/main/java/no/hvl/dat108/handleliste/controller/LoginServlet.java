package no.hvl.dat108.handleliste.controller;

import no.hvl.dat108.handleliste.Handleliste.Loc;
import no.hvl.dat108.handleliste.Handleliste.UrlPattern;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

import static no.hvl.dat108.handleliste.helper.Sessions.getNewSession;

@WebServlet(name = "LoginServlet", urlPatterns = "/login")
public class LoginServlet extends BaseServlet {

    static String HANDLELISTE_PASSORD;

    @Override
    public void init() throws ServletException {
        super.init();
        HANDLELISTE_PASSORD = getServletContext().getInitParameter("passord");
    }

    @Override
    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        String password = request.getParameter("password");
        HttpSession session = getNewSession(request);

        if (!password.equals(HANDLELISTE_PASSORD)) {
            session.setAttribute("message", Loc.WRONG_PASSWORD);
            response.sendRedirect(UrlPattern.LOGIN);
            return;
        }

        session.setAttribute("loginInfo", "asfd");
        response.sendRedirect(UrlPattern.HANDLELISTE);
    }

    @Override
    protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

        RequestDispatcher dispatcher = request.getRequestDispatcher("WEB-INF/login.jsp");
        dispatcher.forward(request, response);
    }
}
